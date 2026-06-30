
CREATE PROCEDURE sp_RegistrarAcceso_Aprendiz(
    IN p_id_Aprendiz INT,
    IN p_id_Vehiculo INT,
    IN p_id_Celador INT
)
BEGIN
    DECLARE v_InicioDelDia DATE;
    DECLARE v_UltimoTipoIngreso VARCHAR(50);
    DECLARE v_NuevoTipoIngreso VARCHAR(50);

    --  Manejo de Errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error transaccional al registrar el acceso.';
    END;

    SET v_InicioDelDia = CURDATE();

    -- Iniciar la transacción 
    START TRANSACTION;

    -- 4. Buscar el ÚLTIMO registro del vehículo/aprendiz en el día actual
		SELECT tipo_ingreso INTO v_UltimoTipoIngreso
		FROM entrada_salida_aprendiz
		WHERE id_aprendiz = p_id_Aprendiz 
		AND id_vehiculo = p_id_Vehiculo
		AND fecha_hora >= v_InicioDelDia
    ORDER BY fecha_hora DESC
    LIMIT 1;

    --  Lógica de máquina de estados
    IF v_UltimoTipoIngreso IS NULL OR v_UltimoTipoIngreso = 'Salida' THEN
        SET v_NuevoTipoIngreso = 'Entrada';
    ELSE
        SET v_NuevoTipoIngreso = 'Salida';
    END IF;

    -- 6. Inserción del nuevo evento (usando NOW() para fecha y hora actual)
    INSERT INTO entrada_salida_aprendiz (
        id_aprendiz, 
        id_vehiculo, 
        fecha_hora, 
        id_celador, 
        tipo_ingreso
    )
    VALUES (
        p_IdAprendiz, 
        p_IdVehiculo, 
        NOW(), 
        p_IdCelador, 
        v_NuevoTipoIngreso
    );

    -- Confirmar la transacción
    COMMIT;
    
    -- 7. Retornar el estado registrado para el software cliente (Frontend / Backend)
    SELECT v_NuevoTipoIngreso AS AccionRegistrada;

END //

DELIMITER ;