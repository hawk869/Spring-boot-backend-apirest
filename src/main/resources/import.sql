INSERT INTO regiones (nombre) VALUES ('Sudamerica');
INSERT INTO regiones (nombre) VALUES ('Centroamerica');
INSERT INTO regiones (nombre) VALUES ('Norteamerica');
INSERT INTO regiones (nombre) VALUES ('Europa');
INSERT INTO regiones (nombre) VALUES ('Africa');
INSERT INTO regiones (nombre) VALUES ('Asia');
INSERT INTO regiones (nombre) VALUES ('Oceania');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Andres', 'Iniesta', 'anini@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4,'Cristiano', 'Ronaldo', 'cr7@gmail.com', '2018-01-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'Lionel', 'Messi', 'liomessi@gmail.com', '2018-01-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'Neymar', 'Jr', 'ney@gmail.com', '2018-02-05');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Robert', 'Lewandosky', 'robert@gmail.com', '2018-04-04');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'Luis', 'Diaz', 'lucho@gmail.com', '2019-02-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(5, 'Sadio', 'Mane', 'sadiom@gmail.com', '2019-05-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(6, 'Hyuming', 'son', 'sonaldo@gmail.com', '2022-02-03');
-- creacion de algunos usuarios con sus roles
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('Andres', '$2a$10$aiY/Q2TTLOnvs/Wq.myw2evlzFjSIITxbvlgZskJuILZk7ds2dCpK', 1, 'Andres', 'Guzman', 'andguz@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$70HzFm9T0HQJ7KOU2NA7WOjMejb5ap9Z/l6htM.FhLgGmnzGNttaK', 1, 'Daniel', 'Rojas', 'daniroj@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, roles_id) values (1,1);
INSERT INTO `usuarios_roles` (usuario_id, roles_id) values (2,2);
INSERT INTO `usuarios_roles` (usuario_id, roles_id) values (2,1);

