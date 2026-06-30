CREATE DATABASE SECSS;
USE SECSS;

CREATE TABLE rol(
	id int auto_increment,
	nombre_rol varchar(50) not null unique,
	primary key (id)
);
 
 
 CREATE TABLE usuario(
	id int auto_increment,
	tipo_documento ENUM('CC', 'TI', 'CE', 'PEP', 'PPT') NOT NULL,
	numero_documento varchar(20) not null unique,
	primer_nombre varchar(50) not null,
	segundo_nombre varchar(50),
	primer_apellido varchar(50) not null,
	segundo_apellido varchar(50),
	n_celular varchar(20) not null unique,
	estado tinyint(3) not null,
	primary key (id)
 );


 CREATE TABLE usuario_rol(
	id_usuario int,
	id_rol int,
	estado tinyint NOT NULL,  
	primary key (id_usuario, id_rol), 
 
	foreign key (id_usuario) references usuario(id) ON DELETE CASCADE,
	foreign key (id_rol) references rol(id) ON DELETE CASCADE
 );  


CREATE TABLE cuenta (
    id_usuario INT , 
    correo varchar(100) not null unique,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    intentos_fallidos TINYINT(3) NOT NULL DEFAULT 0, 
    bloqueada_hasta DATETIME NULL, 
    ultimo_login DATETIME NULL, 
    estado tinyint(3) not null,
    PRIMARY KEY (id_usuario),
    
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);
 

 CREATE TABLE jefe_seguridad_celador(
	id_usuario_jefe_seguridad int,
	id_usuario_celador int,
	primary key (id_usuario_celador, id_usuario_jefe_seguridad), 
 
	foreign key (id_usuario_celador) references usuario(id) ON DELETE CASCADE,
	foreign key (id_usuario_jefe_seguridad) references usuario(id) ON DELETE CASCADE
 );
  
  
 CREATE TABLE centro(
	id int auto_increment,
	nombre_centro varchar(100) not null unique,
	primary key (id)
);
 
 
 CREATE TABLE detalle_aprendiz(
	id_usuario int,
	id_centro int not null,
	ficha int not null,
	imagen_url_aprendiz varchar(500) not null,
	direccion varchar(50) not null,
	imagen_url_identificacion varchar(500) not null,
	imagen_url_carnet_sena varchar(500) not null,
	fecha_vinculacion date not null,
	fecha_terminacion date null,
	primary key (id_usuario),
 
	foreign key (id_usuario) references usuario(id) ON DELETE CASCADE,
	foreign key (id_centro) references centro(id) ON DELETE CASCADE
 );
 
 
  CREATE TABLE vehiculo(
	id int auto_increment,
	tipo_vehiculo ENUM('MOTO', 'BICICLETA') NOT NULL,
	marca varchar(50) not null,
	color varchar(50) not null,
	imagen_url_tarjeta_propiedad varchar(500) not null,
	imagen_url_identificacion_vehiculo varchar(500) not null,
	imagen_url_vehiculo varchar(500) not null,
	primary key (id)
    
  );
  
  
  CREATE TABLE detalle_moto(
	id_vehiculo int,
	placa varchar(50) not null unique,
	cilindraje int not null, -- antes varchar (50)
	modelo varchar (50) not null,
	imagen_url_soat varchar(500) not null,
	imagen_url_tecnomecanica_vigente varchar(500) not null,
	primary key (id_vehiculo),
  
	foreign key (id_vehiculo) references vehiculo(id) ON DELETE CASCADE
  );
  
  
  CREATE TABLE detalle_bicicleta(
	id_vehiculo int,
	numero_marco varchar(50) not null unique,
	clase_bicicleta varchar(50) not null,
	primary key (id_vehiculo),
  
	foreign key (id_vehiculo) references vehiculo(id) ON DELETE CASCADE
  );


CREATE TABLE cupo(
	id_usuario int,
	id_vehiculo int,
	estado tinyint(3) NOT NULL DEFAULT 0, -- antes int
	id_usuario_administrador int null,
	primary key (id_usuario, id_vehiculo),

	foreign key (id_usuario) references usuario(id) ON DELETE CASCADE,
	foreign key (id_vehiculo) references vehiculo(id) ON DELETE CASCADE,
	foreign key (id_usuario_administrador) references usuario(id) ON DELETE CASCADE
);


CREATE TABLE entrada_salida(
	id int auto_increment,
	id_usuario_entra int not null,
	id_vehiculo int not null,
	fecha_hora datetime not null default now(),
	id_usuario_celador int not null,
	tipo_registro ENUM('ENTRADA', 'SALIDA') NOT NULL, 
	primary key (id),

	foreign key (id_usuario_entra) references usuario(id) ON DELETE CASCADE,
	foreign key (id_usuario_celador) references usuario(id) ON DELETE CASCADE,
	foreign key (id_vehiculo) references vehiculo(id) ON DELETE CASCADE
);


CREATE TABLE reporte(
	id int auto_increment,
	id_usuario_celador int not null,
	fecha_hora datetime not null,
	asunto varchar(500) not null,
	cuerpo varchar(1000) not null,
	estado ENUM('REVISADO', 'NO_REVISADO') NOT NULL DEFAULT 'NO_REVISADO',
	id_entrada_salida int null,
	primary key (id),

	foreign key (id_usuario_celador) references usuario(id) ON DELETE CASCADE,
	foreign key (id_entrada_salida) references entrada_salida(id) ON DELETE CASCADE
);


CREATE TABLE pqrs(
	id int auto_increment,
	id_usuario int not null,
	asunto varchar(500) not null,
	cuerpo varchar(1000) not null,
	estado ENUM('RADICADO', 'EN_TRAMITE', 'RESUELTO', 'CERRADO') NOT NULL DEFAULT 'RADICADO',
	fecha_creacion DATETIME NOT NULL DEFAULT NOW(),
	primary key (id),

	foreign key (id_usuario) references usuario(id) ON DELETE CASCADE
);


CREATE TABLE respuesta(
	id int auto_increment,
	id_pqrs int not null unique,
	id_usuario_administrador int not null,
	asunto varchar(500) not null,
	cuerpo varchar(1000) not null,
	primary key (id),

	foreign key (id_pqrs) references pqrs(id) ON DELETE CASCADE,
	foreign key (id_usuario_administrador) references usuario(id) ON DELETE CASCADE
);









