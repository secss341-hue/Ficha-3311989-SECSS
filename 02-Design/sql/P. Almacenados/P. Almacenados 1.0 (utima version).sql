CREATE DEFINER=`root`@`localhost` PROCEDURE `autenticar_cuenta_usuario`(
    IN p_nombre_usuario VARCHAR(50),
    IN p_es_password_valido TINYINT, -- El Backend valida el Hash de Bcrypt y envía 1 (Ok) o 0 (Fallo)
    OUT p_codigo_respuesta VARCHAR(50)
)
BEGIN
    DECLARE v_id_usuario INT;
    DECLARE v_intentos TINYINT;
    DECLARE v_bloqueada_hasta DATETIME;
    DECLARE v_estado_cuenta TINYINT;

    -- Extraer el estado actual de seguridad de la cuenta
    SELECT id_usuario, intentos_fallidos, bloqueada_hasta, estado 
    INTO v_id_usuario, v_intentos, v_bloqueada_hasta, v_estado_cuenta
    FROM cuenta
    WHERE nombre_usuario = p_nombre_usuario;

    -- Validacion 1: Verificar existencia real de la cuenta
    IF v_id_usuario IS NULL THEN
        SET p_codigo_respuesta = 'ERR_USUARIO_INEXISTENTE';

    -- Validacion 2: Verificar si está inactiva administrativamente
    ELSEIF v_estado_cuenta = 0 THEN
        SET p_codigo_respuesta = 'ERR_CUENTA_DESACTIVADA';

    -- Validacion 3: Verificar si se encuentra bloqueada por fuerza bruta
    ELSEIF v_bloqueada_hasta IS NOT NULL AND v_bloqueada_hasta > NOW() THEN
        SET p_codigo_respuesta = 'ERR_CUENTA_BLOQUEADA_TEMPORAL';

    ELSE
        -- Evaluación del resultado de autenticación
        IF p_es_password_valido = 1 THEN
            -- Autenticación Exitosa: Se restablece el contador de fallos y se estampa el login
            UPDATE cuenta 
            SET intentos_fallidos = 0, 
                bloqueada_hasta = NULL, 
                ultimo_login = NOW()
            WHERE id_usuario = v_id_usuario;
            
            SET p_codigo_respuesta = 'AUTH_SUCCESS';
        ELSE
            -- Autenticación Fallida: Incrementar contador de penalización
            SET v_intentos = v_intentos + 1;
            
            IF v_intentos >= 3 THEN
                -- Bloqueo automático preventivo durante 15 minutos
                UPDATE cuenta 
                SET intentos_fallidos = v_intentos,
                    bloqueada_hasta = DATE_ADD(NOW(), INTERVAL 15 MINUTE)
                WHERE id_usuario = v_id_usuario;
                
                SET p_codigo_respuesta = 'AUTH_FAILED_LOCKOUT';
            ELSE
                UPDATE cuenta 
                SET intentos_fallidos = v_intentos
                WHERE id_usuario = v_id_usuario;
                
                SET p_codigo_respuesta = CONCAT('AUTH_FAILED_ATTEMPT_', v_intentos);
            END IF;
        END IF;
    END IF;
END

-- ===================================================================

CREATE DEFINER=`root`@`localhost` PROCEDURE `p_aprobar_cupo_vehicular`(
    IN p_id_usuario_aprendiz INT,
    IN p_id_vehiculo INT,
    IN p_id_usuario_administrador INT
)
BEGIN
    -- Validar primero si el cupo realmente existe y está pendiente
    DECLARE v_existe_cupo INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe_cupo
    FROM cupo
    WHERE id_usuario = p_id_usuario_aprendiz AND id_vehiculo = p_id_vehiculo;

    IF v_existe_cupo = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'ERROR VALIDACIÓN: No se encontró ningún pre-registro para esta union de usuario y vehículo.';
    END IF;

    -- Actualizar el cupo: Cambiar estado a 1 (Activo) y registrar quien activo el cupo
    UPDATE cupo
    SET estado = 1,
        id_usuario_administrador = p_id_usuario_administrador
    WHERE id_usuario = p_id_usuario_aprendiz AND id_vehiculo = p_id_vehiculo;

END

-- ===================================================================

CREATE DEFINER=`root`@`localhost` PROCEDURE `p_pre_registrar_vehiculo_moto`(
    IN p_placa VARCHAR(50),
    IN p_modelo VARCHAR(50),
    IN p_cilindraje INT, --
    IN p_marca VARCHAR(50),
    IN p_color VARCHAR(50),
    IN p_imagen_url_tarjeta_propiedad VARCHAR(500),
    IN p_imagen_url_identificacion_vehiculo VARCHAR(500),
    IN p_imagen_url_vehiculo VARCHAR(500),
    IN p_imagen_url_soat VARCHAR(500),
    IN p_imagen_url_tecnomecanica_vigente VARCHAR(500),
    IN p_id_usuario INT,
    OUT o_id_vehiculo_generado INT
)
BEGIN
	-- Esxcepcion
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SET o_id_vehiculo_generado = 0;
    END;

    START TRANSACTION;

        -- Insertar el registro del vehículo
        INSERT INTO vehiculo (
            tipo_vehiculo, marca, color, imagen_url_tarjeta_propiedad, 
            imagen_url_identificacion_vehiculo, imagen_url_vehiculo
        )
        VALUES (
            'MOTO', p_marca, p_color, p_imagen_url_tarjeta_propiedad, 
            p_imagen_url_identificacion_vehiculo, p_imagen_url_vehiculo
        );
		
        -- Capturar la llave primaria autogenerada
        SET o_id_vehiculo_generado = LAST_INSERT_ID();

        -- Insertar los  detalles en la tabla detalle_moto
        INSERT INTO detalle_moto (
            id_vehiculo, placa, cilindraje, modelo, 
            imagen_url_soat, imagen_url_tecnomecanica_vigente
        )
        VALUES (
            o_id_vehiculo_generado, p_placa, p_cilindraje, p_modelo, 
            p_imagen_url_soat, p_imagen_url_tecnomecanica_vigente
        );

        -- Asignar el cupo inactivo de inmediato
        INSERT INTO cupo (
            id_usuario, 
            id_vehiculo, 
            estado, 
            id_usuario_administrador
        )
        VALUES (
            p_id_usuario, 
            o_id_vehiculo_generado, 
            0,
            NULL
        );

    COMMIT;
END

-- ===================================================================

CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_acceso_vehicular`(
    IN p_id_usuario INT,
    IN p_id_vehiculo INT,
    IN p_id_celador INT,
    IN p_tipo_registro ENUM('ENTRADA', 'SALIDA')
)
BEGIN
    DECLARE v_cupo_activo INT DEFAULT 0;
    DECLARE v_ultimo_estado ENUM('ENTRADA', 'SALIDA') DEFAULT NULL;

    -- Revisar estado del vehículo en los registos
    SELECT tipo_registro INTO v_ultimo_estado
    FROM entrada_salida
    WHERE id_vehiculo = p_id_vehiculo
    ORDER BY fecha_hora DESC, id DESC
    LIMIT 1;

    -- Flujo
    IF p_tipo_registro = 'ENTRADA' THEN
        -- Primera validación: Evitar doble entrada sin salida previa
        IF v_ultimo_estado = 'ENTRADA' THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'CONTROL DE ACCESO: El vehículo ya se encuentra dentro de las instalaciones.';
        END IF;

        -- Segunda validación: El usuario debe tener un cupo debidamente AUTORIZADO y ACTIVO
        SELECT COUNT(*) INTO v_cupo_activo
        FROM cupo
        WHERE id_usuario = p_id_usuario AND id_vehiculo = p_id_vehiculo AND estado = 1;

        IF v_cupo_activo = 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'CONTROL DE ACCESO: Acceso denegado. El usuario no posee un cupo activo asignado.';
        END IF;

    ELSEIF p_tipo_registro = 'SALIDA' THEN
        -- Tercera validación: No se puede sacar un vehículo que no ha entrado
        IF v_ultimo_estado IS NULL OR v_ultimo_estado = 'SALIDA' THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'CONTROL DE ACCESO: Operación inválida. El vehículo no registra ninguna entrada activa.';
        END IF;
    END IF;

    -- Inserción del registro tras superar las validaciones
    INSERT INTO entrada_salida (id_usuario_entra, id_vehiculo, id_usuario_celador, tipo_registro, fecha_hora)
    VALUES (p_id_usuario, p_id_vehiculo, p_id_celador, p_tipo_registro, NOW());

END