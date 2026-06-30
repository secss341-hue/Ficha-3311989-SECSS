USE secss;

-- 1. Consultas generales

-- Información general de usuarios
SELECT 
    us.id, 
    us.tipo_documento, 
    us.numero_documento, 
    CONCAT(us.primer_nombre, ' ', COALESCE(us.segundo_nombre, ''), ' ', us.primer_apellido) AS nombre_completo,
    cu.correo, 
    us.n_celular,
    GROUP_CONCAT(ro.nombre_rol SEPARATOR ', ') AS roles_asignados,
    IF(us.estado = 1, 'Activo', 'Inactivo') AS estado_usuario
FROM usuario us
INNER JOIN cuenta cu ON cu.id_usuario = us.id
LEFT JOIN usuario_rol ur ON us.id = ur.id_usuario
LEFT JOIN rol ro ON ur.id_rol = ro.id
GROUP BY us.id;

-- Información general de vehiculos
SELECT 
    ve.id AS vehiculo_id, 
    ve.tipo_vehiculo, 
    ve.marca, 
    ve.color,
    COALESCE(dmo.placa, dbi.numero_marco) AS identificacion_fisica 
FROM vehiculo ve
LEFT JOIN detalle_moto dmo ON ve.id = dmo.id_vehiculo
LEFT JOIN detalle_bicicleta dbi ON ve.id = dbi.id_vehiculo;

-- Información general de cupos
SELECT  
    cu.id_usuario AS propietario_id, 
    us.numero_documento, 
    us.tipo_documento, 
    us.primer_nombre, 
    us.primer_apellido, 
    ve.id AS vehiculo_id,
    ve.tipo_vehiculo, 
    ve.marca, 
    ve.color, 
    COALESCE(dm.placa, db.numero_marco) AS identificador_vehiculo,
    CASE cu.estado 
        WHEN 0 THEN 'PENDIENTE' 
        WHEN 1 THEN 'APROBADO' 
        ELSE 'SUSPENDIDO' 
    END AS estado_cupo,

    COALESCE(adm.primer_nombre, 'SIN ASIGNAR (PRE-REGISTRO)') AS administrador_auditor
FROM cupo cu
INNER JOIN usuario us ON us.id = cu.id_usuario
INNER JOIN vehiculo ve ON ve.id = cu.id_vehiculo
LEFT JOIN usuario adm ON adm.id = cu.id_usuario_administrador
LEFT JOIN detalle_moto dm ON ve.id = dm.id_vehiculo
LEFT JOIN detalle_bicicleta db ON ve.id = db.id_vehiculo;

-- Información general de entradas y salidas
SELECT 
    es.id AS registro_id,
    es.fecha_hora,
    es.tipo_registro AS operacion,
    ve.tipo_vehiculo,
    ve.marca,
    COALESCE(dm.placa, db.numero_marco) AS identificacion_vehiculo,
    CONCAT(u_entra.primer_nombre, ' ', u_entra.primer_apellido) AS persona_ingresa,
    u_entra.numero_documento AS doc_persona,
    CONCAT(u_cel.primer_nombre, ' ', u_cel.primer_apellido) AS celador_responsable
FROM entrada_salida es
INNER JOIN vehiculo ve ON es.id_vehiculo = ve.id
INNER JOIN usuario u_entra ON es.id_usuario_entra = u_entra.id
INNER JOIN usuario u_cel ON es.id_usuario_celador = u_cel.id
LEFT JOIN detalle_moto dm ON ve.id = dm.id_vehiculo
LEFT JOIN detalle_bicicleta db ON ve.id = db.id_vehiculo
ORDER BY es.fecha_hora DESC;



-- 2. Consulatas especificas o con detalle

-- Información detallada de un aprendiz
SELECT 
    dap.id_usuario, 
    us.tipo_documento,
    us.numero_documento, 
    us.primer_nombre, 
    us.primer_apellido, 
    cu.correo, 
    us.n_celular, 
    dap.ficha, 
    dap.direccion, 
    dap.fecha_vinculacion, 
    dap.fecha_terminacion,
    dap.imagen_url_aprendiz, 
    dap.imagen_url_identificacion, 
    dap.imagen_url_carnet_sena
FROM usuario us
INNER JOIN cuenta cu ON cu.id_usuario = us.id
INNER JOIN detalle_aprendiz dap ON dap.id_usuario = us.id
WHERE us.id = 1;

-- Información detallada de una moto
SELECT 
    ve.id AS id_vehiculo, 
    ve.tipo_vehiculo,
    ve.marca, 
    ve.color, 
    ve.imagen_url_tarjeta_propiedad, 
    ve.imagen_url_identificacion_vehiculo, 
    ve.imagen_url_vehiculo, 
    dmo.placa, 
    dmo.cilindraje, 
    dmo.modelo, 
    dmo.imagen_url_soat, 
    dmo.imagen_url_tecnomecanica_vigente
FROM vehiculo ve
INNER JOIN detalle_moto dmo ON dmo.id_vehiculo = ve.id
WHERE ve.id = 2;

-- Información detallada de una bicicleta
SELECT 
    ve.id AS id_vehiculo, 
    ve.tipo_vehiculo,
    ve.marca, 
    ve.color, 
    ve.imagen_url_tarjeta_propiedad, 
    ve.imagen_url_vehiculo, 
    dbi.numero_marco, 
    dbi.clase_bicicleta
FROM vehiculo ve
INNER JOIN detalle_bicicleta dbi ON dbi.id_vehiculo = ve.id
WHERE ve.id = 4;

-- Información detallada de un cupo - moto
SELECT  
    CASE cu.estado 
        WHEN 0 THEN 'PENDIENTE DE VALIDACIÓN' 
        WHEN 1 THEN 'APROBADO / ACTIVO' 
        ELSE 'SUSPENDIDO / INACTIVO' 
    END AS estado_cupo_sistema,
    COALESCE(CONCAT(adm.primer_nombre, ' ', adm.primer_apellido), 'SOPORTE SIN AUDITAR (PRE-REGISTRO)') AS administrador_auditor,
    us.id AS aprendiz_id,
    us.tipo_documento AS aprendiz_tipo_doc,
    us.numero_documento AS aprendiz_documento,
    CONCAT(us.primer_nombre, ' ', COALESCE(us.segundo_nombre, ''), ' ', us.primer_apellido, ' ', COALESCE(us.segundo_apellido, '')) AS aprendiz_nombre_completo,
    us.n_celular AS aprendiz_celular,
    cnt.correo AS aprendiz_correo,
    dap.ficha AS sena_ficha,
    dap.direccion AS aprendiz_direccion,
    dap.fecha_vinculacion AS sena_fecha_ingreso,
    ve.id AS vehiculo_id,
    ve.marca AS vehiculo_marca,
    ve.color AS vehiculo_color,
    dmo.placa AS moto_placa,
    dmo.cilindraje AS moto_cilindraje,
    dmo.modelo AS moto_modelo,
    dap.imagen_url_aprendiz AS url_foto_perfil,
    dap.imagen_url_identificacion AS url_documento_identidad,
    dap.imagen_url_carnet_sena AS url_carnet_sena,
    ve.imagen_url_tarjeta_propiedad AS url_tarjeta_propiedad,
    ve.imagen_url_identificacion_vehiculo AS url_improntas,
    ve.imagen_url_vehiculo AS url_foto_fisica_moto,
    dmo.imagen_url_soat AS url_soat_moto,
    dmo.imagen_url_tecnomecanica_vigente AS url_tecnomecanica_moto

FROM cupo cu
INNER JOIN usuario us ON us.id = cu.id_usuario
INNER JOIN cuenta cnt ON us.id = cnt.id_usuario
INNER JOIN detalle_aprendiz dap ON us.id = dap.id_usuario
INNER JOIN vehiculo ve ON ve.id = cu.id_vehiculo
INNER JOIN detalle_moto dmo ON ve.id = dmo.id_vehiculo -- INNER JOIN: Garantiza que solo busque motos
LEFT JOIN usuario adm ON adm.id = cu.id_usuario_administrador
WHERE 
    cu.id_usuario = 5;
    
-- Información detallada de un cupo - bicicleta
SELECT  
    CASE cu.estado 
        WHEN 0 THEN 'PENDIENTE DE VALIDACIÓN' 
        WHEN 1 THEN 'APROBADO / ACTIVO' 
        ELSE 'SUSPENDIDO / INACTIVO' 
    END AS estado_cupo_sistema,
    COALESCE(CONCAT(adm.primer_nombre, ' ', adm.primer_apellido), 'SOPORTE SIN AUDITAR (PRE-REGISTRO)') AS administrador_auditor,
    us.id AS aprendiz_id,
    us.tipo_documento AS aprendiz_tipo_doc,
    us.numero_documento AS aprendiz_documento,
    CONCAT(us.primer_nombre, ' ', COALESCE(us.segundo_nombre, ''), ' ', us.primer_apellido, ' ', COALESCE(us.segundo_apellido, '')) AS aprendiz_nombre_completo,
    us.n_celular AS aprendiz_celular,
    cnt.correo AS aprendiz_correo,
    dap.ficha AS sena_ficha,
    dap.direccion AS aprendiz_direccion,
    dap.fecha_vinculacion AS sena_fecha_ingreso,
    ve.id AS vehiculo_id,
    ve.marca AS vehiculo_marca,
    ve.color AS vehiculo_color,
    dbi.numero_marco AS bicicleta_numero_marco,
    dbi.clase_bicicleta AS bicicleta_tipo,
    dap.imagen_url_aprendiz AS url_foto_perfil,
    dap.imagen_url_identificacion AS url_documento_identidad,
    dap.imagen_url_carnet_sena AS url_carnet_sena,
    ve.imagen_url_tarjeta_propiedad AS url_factura_o_propiedad,
    ve.imagen_url_identificacion_vehiculo AS url_serial_marco,
    ve.imagen_url_vehiculo AS url_foto_fisica_bicicleta

FROM cupo cu
INNER JOIN usuario us ON us.id = cu.id_usuario
INNER JOIN cuenta cnt ON us.id = cnt.id_usuario
INNER JOIN detalle_aprendiz dap ON us.id = dap.id_usuario
INNER JOIN vehiculo ve ON ve.id = cu.id_vehiculo
INNER JOIN detalle_bicicleta dbi ON ve.id = dbi.id_vehiculo
LEFT JOIN usuario adm ON adm.id = cu.id_usuario_administrador
WHERE 
    cu.id_usuario = 6;


-- 3. Modulo de reportes

-- Información general de reportes
SELECT 
    re.id AS reporte_id, 
    re.fecha_hora, 
    re.asunto, 
    re.cuerpo, 
    re.estado AS estado_revision, -- ENUM: 'REVISADO', 'NO_REVISADO'
    CONCAT(u_cel.primer_nombre, ' ', u_cel.primer_apellido) AS celador_reporta,
    re.id_entrada_salida AS vinculo_suceso
FROM reporte re
INNER JOIN usuario u_cel ON u_cel.id = re.id_usuario_celador;

-- Información general prqs y respuestas(si aplica)
SELECT 
    pq.id AS pqrs_id, 
    CONCAT(u_crea.primer_nombre, ' ', u_crea.primer_apellido) AS usuario_creador,
    pq.asunto AS pqrs_asunto, 
    pq.cuerpo AS pqrs_cuerpo, 
    pq.estado AS pqrs_estado, 
    pq.fecha_creacion,
    res.id AS respuesta_id,
    res.asunto AS resp_asunto,
    res.cuerpo AS resp_cuerpo,
    CONCAT(u_adm.primer_nombre, ' ', u_adm.primer_apellido) AS administrador_responde
FROM pqrs pq
INNER JOIN usuario u_crea ON u_crea.id = pq.id_usuario
LEFT JOIN respuesta res ON pq.id = res.id_pqrs
LEFT JOIN usuario u_adm ON u_adm.id = res.id_usuario_administrador;