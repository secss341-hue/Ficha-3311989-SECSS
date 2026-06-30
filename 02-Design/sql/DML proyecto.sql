CREATE DATABASE SECSS;
USE SECSS;

INSERT INTO rol (nombre_rol) VALUES 
('ADMINISTRADOR'),
('JEFE_SEGURIDAD'),
('CELADOR'),
('APRENDIZ'),
('INVITADO'); 


INSERT INTO usuario (tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, n_celular, estado) VALUES 
('CC', '1021312836', 'Steven', NULL, 'Cortes', NULL, '3242551122', 1),          
('CC', '80112233', 'Marcos', 'Antonio', 'Guerra', 'Castillo', '3105554433', 1),  
('CC', '79888777', 'Carlos', 'Alberto', 'Pérez', 'Gómez', '3159998877', 1),     
('CC', '19444555', 'Edilberto', NULL, 'Ramos', 'Tobón', '3217778899', 1);         


INSERT INTO usuario (tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, n_celular, estado) VALUES 
('TI', '1055444333', 'Diego', 'Alejandro', 'Ruiz', 'Díaz', '3004445566', 1),      
('CC', '1010222333', 'Laura', 'Valentina', 'Rojas', 'Mendoza', '3126667788', 1),  
('CC', '1030444555', 'Andrés', 'Felipe', 'Castro', 'Peña', '3192223344', 1),      
('CE', 'E998877', 'Hans', 'Dieter', 'Mueller', NULL, '3051112233', 1);            


INSERT INTO usuario (tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, n_celular, estado) VALUES 
('CC', '52888999', 'Patricia', 'Elena', 'Gutiérrez', 'Sanz', '3145556677', 1),     
('PEP', 'P951753', 'Juan', 'Carlos', 'Méndez', 'Arango', '3184445566', 1),         
('PPT', 'T753159', 'María', 'José', 'Villasmil', NULL, '3229990011', 0);           


INSERT INTO usuario_rol (id_usuario, id_rol, estado) VALUES 
(1, 1, 1), 
(1, 4, 1), 
(2, 2, 1), 
(3, 3, 1), 
(4, 3, 1), 
(5, 4, 1), 
(6, 4, 1), 
(7, 4, 1), 
(8, 4, 1), 
(9, 5, 1), 
(10, 5, 1),
(11, 5, 1);


INSERT INTO cuenta (id_usuario, correo, nombre_usuario, password_hash, intentos_fallidos, bloqueada_hasta, ultimo_login, estado) VALUES 
(1, 'scortes@secss.edu.co', 'scortes', '$2b$12$EefXCo7IbbEv34', 0, NULL, NOW(), 1),
(2, 'mguerra@security.com', 'mguerra.jefe', '$2b$12$R9ZFxCHy83', 0, NULL, NULL, 1),
(3, 'cperez@security.com', 'cperez.celador', '$2b$12$P91LksW', 0, NULL, NOW(), 1),
(4, 'eramos@security.com', 'eramos.celador', '$2b$12$L83MjsA', 0, NULL, NULL, 1),
(5, 'diego.ruiz@misena.edu.co', 'druiz', '$2b$12$K71NhsP', 0, NULL, NOW(), 1),
(6, 'laura.rojas@misena.edu.co', 'lrojas', '$2b$12$M92JksO', 2, NULL, NULL, 1),
(7, 'afelipe.castro@misena.edu.co', 'afcastro', '$2b$12$Z12PlsQ', 0, NULL, NULL, 1),
(8, 'hdieter@misena.edu.co', 'hdieter', '$2b$12$X54KlsW', 0, NULL, NULL, 1),
(9, 'patricia.g@gmail.com', 'pgutierrez', '$2b$12$Y76MnsD', 0, NULL, NOW(), 1),
(10, 'juanc.mendez@outlook.com', 'jcmendez', '$2b$12$V32KjsF', 0, NULL, NULL, 1),
(11, 'mariajose@gmail.com', 'mjvillasmil', '$2b$12$B11NhsA', 0, NULL, NULL, 0);


INSERT INTO jefe_seguridad_celador (id_usuario_jefe_seguridad, id_usuario_celador) VALUES 
(2, 3),  
(2, 4);   


INSERT INTO centro (nombre_centro) VALUES 
('Centro de Electricidad, Electrónica y Telecomunicaciones (CEET)'),
('Centro de Gestión Industrial (CGI)'),
('Centro de Tecnologías para la Construcción y la Madera');


INSERT INTO detalle_aprendiz (id_usuario, id_centro, ficha, imagen_url_aprendiz, direccion, imagen_url_identificacion, imagen_url_carnet_sena, fecha_vinculacion, fecha_terminacion) VALUES 
(1, 3, 2501234, 'http://storage.sena/fotos/1.jpg', 'Calle 80 # 45-12', 'http://storage.sena/ids/1.jpg', 'http://storage.sena/carnets/1.jpg', '2025-07-10', '2026-12-15'),
(5, 1, 2611934, 'http://storage.sena/fotos/5.jpg', 'Calle 45 # 12-34', 'http://storage.sena/ids/5.jpg', 'http://storage.sena/carnets/5.jpg', '2026-01-15', '2027-06-15'),
(6, 2, 2833412, 'http://storage.sena/fotos/6.jpg', 'Av. Caracas # 57-10', 'http://storage.sena/ids/6.jpg', 'http://storage.sena/carnets/6.jpg', '2026-02-10', '2027-08-10'),
(7, 1, 2611935, 'http://storage.sena/fotos/7.jpg', 'Carrera 30 # 15-40', 'http://storage.sena/ids/7.jpg', 'http://storage.sena/carnets/7.jpg', '2026-01-15', '2027-06-15'),
(8, 2, 2833413, 'http://storage.sena/fotos/8.jpg', 'Diagonal 45 # 20-33', 'http://storage.sena/ids/8.jpg', 'http://storage.sena/carnets/8.jpg', '2026-02-10', '2027-08-10');


INSERT INTO vehiculo (tipo_vehiculo, marca, color, imagen_url_tarjeta_propiedad, imagen_url_identificacion_vehiculo, imagen_url_vehiculo) VALUES 
('MOTO', 'Yamaha', 'Negro Mate', 'http://storage.sena/propiedad/v1_tarjeta.jpg', 'http://storage.sena/id_v/v1_chasis.jpg', 'http://storage.sena/vehiculos/v1_moto.jpg'),
('BICICLETA', 'GW', 'Verde', 'http://storage.sena/propiedad/v2_factura.jpg', 'http://storage.sena/id_v/v2_no_aplica.jpg', 'http://storage.sena/vehiculos/v2_bici.jpg'),
('MOTO', 'Bajaj Pulsar', 'Azul', 'http://storage.sena/propiedad/v3_tarjeta.jpg', 'http://storage.sena/id_v/v3_chasis.jpg', 'http://storage.sena/vehiculos/v3_moto.jpg'),
('BICICLETA', 'Trek', 'Rojo', 'http://storage.sena/propiedad/v4_factura.jpg', 'http://storage.sena/id_v/v4_no_aplica.jpg', 'http://storage.sena/vehiculos/v4_bici.jpg'),
('MOTO', 'Suzuki', 'Blanco', 'http://storage.sena/propiedad/v5_tarjeta.jpg', 'http://storage.sena/id_v/v5_chasis.jpg', 'http://storage.sena/vehiculos/v5_moto.jpg'),
('BICICLETA', 'Specialized', 'Gris', 'http://storage.sena/propiedad/v6_factura.jpg', 'http://storage.sena/id_v/v6_no_aplica.jpg', 'http://storage.sena/vehiculos/v6_bici.jpg');


INSERT INTO detalle_moto (id_vehiculo, placa, cilindraje, modelo, imagen_url_soat, imagen_url_tecnomecanica_vigente) VALUES 
(1, 'ABC12G', 150, '2025', 'http://storage.sena/soat/v1.jpg', 'http://storage.sena/tecno/v1.jpg'),
(3, 'XYZ98F', 200, '2024', 'http://storage.sena/soat/v3.jpg', 'http://storage.sena/tecno/v3.jpg'),
(5, 'KLO45E', 125, '2026', 'http://storage.sena/soat/v5.jpg', 'http://storage.sena/tecno/v5.jpg');


INSERT INTO detalle_bicicleta (id_vehiculo, numero_marco, clase_bicicleta) VALUES 
(2, 'GW-98765-MARCO-X', 'Montaña'),
(4, 'TREK-1234-ALPHA', 'Ruta'),
(6, 'SPEC-7766-COMP', 'Urbana');


INSERT INTO cupo (id_usuario, id_vehiculo, estado, id_usuario_administrador) VALUES 
(5, 1, 1, 1), 
(6, 2, 1, 1), 
(7, 3, 1, 1),
(8, 4, 1, 1), 
(9, 5, 1, 1), 
(10, 6, 1, 1);


INSERT INTO entrada_salida (id_usuario_entra, id_vehiculo, fecha_hora, id_usuario_celador, tipo_registro) VALUES 
(5, 1, '2026-06-02 06:45:00', 3, 'ENTRADA'), 
(5, 1, '2026-06-02 12:30:00', 3, 'SALIDA'); 


INSERT INTO entrada_salida (id_usuario_entra, id_vehiculo, fecha_hora, id_usuario_celador, tipo_registro) VALUES 
(6, 2, '2026-06-02 07:05:00', 3, 'ENTRADA'), 
(6, 2, '2026-06-02 17:15:00', 4, 'SALIDA');  


INSERT INTO entrada_salida (id_usuario_entra, id_vehiculo, fecha_hora, id_usuario_celador, tipo_registro) VALUES 
(9, 5, '2026-06-03 08:00:00', 4, 'ENTRADA'); 


INSERT INTO entrada_salida (id_usuario_entra, id_vehiculo, fecha_hora, id_usuario_celador, tipo_registro) VALUES 
(7, 3, '2026-06-03 06:10:00', 3, 'ENTRADA'), 
(7, 3, '2026-06-03 11:00:00', 3, 'SALIDA'); 


INSERT INTO reporte (id_usuario_celador, fecha_hora, asunto, cuerpo, estado, id_entrada_salida) VALUES 
(3, '2026-06-02 06:50:00', 'Espejo retrovisor roto al ingreso', 'La motocicleta con placa ABC12G ingresa con el retrovisor derecho agrietado. El conductor afirma que ocurrió en trayecto vial.', 'REVISADO', 1);


INSERT INTO reporte (id_usuario_celador, fecha_hora, asunto, cuerpo, estado, id_entrada_salida) VALUES 
(4, '2026-06-02 15:30:00', 'Casco abandonado en zona de Bicicletas', 'Se halla un casco marca Shaft color verde abandonado sobre la reja perimetral. Se traslada a la oficina de control de seguridad.', 'NO_REVISADO', NULL);


INSERT INTO pqrs (id_usuario, asunto, cuerpo, estado, fecha_creacion) VALUES 
(5, 'Falta de iluminación zona posterior', 'El área asignada para motos en la parte de atrás carece de reflectores operacionales en el turno matutino.', 'RESUELTO', '2026-06-02 09:00:00'),
(9, 'Demora en validación de credenciales', 'Como invitada, el sistema tardó más de 15 minutos en validar mi usuario para permitir el ingreso de mi vehículo.', 'RADICADO', NOW());


INSERT INTO respuesta (id_pqrs, id_usuario_administrador, asunto, cuerpo) VALUES (1, 1, 'Solución Técnica - Luminarias traseras', 'Se informa al aprendiz que la solicitud de luminarias ha sido ejecutada con éxito por el departamento de mantenimiento técnico.');

