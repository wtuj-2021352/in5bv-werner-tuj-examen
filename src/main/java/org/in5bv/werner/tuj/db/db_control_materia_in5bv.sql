DROP DATABASE IF EXISTS db_control_materia_in5bv;

CREATE DATABASE IF NOT EXISTS db_control_materia_in5bv;
USE db_control_materia_in5bv;

DROP TABLE IF EXISTS materia;
CREATE TABLE IF NOT EXISTS materia (
	id_materia INT AUTO_INCREMENT NOT NULL,
    nombre_materia VARCHAR(45) NOT NULL,
    ciclo_escolar YEAR,
    horario_inicio TIME,
    horario_final TIME,
    catedratico VARCHAR(45) NOT NULL,
    salon VARCHAR(45) NOT NULL,
    cupo_maximo INT,
    cupo_minimo INT,
    
    CONSTRAINT pk_materia PRIMARY KEY (id_materia)
);

INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Lenguaje", '2022','03:05:06', '10:30:00', "Mateo Ramos", "C30", 25, 20);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Matemáticas", '2019','05:00:06', '01:10:10', "Christopher Duarte", "C37", 50, 15);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Química", '2020','15:00:00', '16:30:00', "Luis del Cid", "C25", 30, 22);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Estadística", '2018','12:00:30', '13:00:00', "Juan Rivas", "C31", 40, 20);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Tecnología", '2021','12:40:00', '17:40:00', "Jorge Pérez", "C35", 25, 15);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Sociales", '2015','16:00:00', '18:20:00', "Darwin Coronado", "C21", 50, 10);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Teatro", '2019','01:04:00', '14:35:00', "Erasmo Pacheco", "C39", 28, 14);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Danza", '2013','17:00:00', '20:30:40', "Zamira López", "C27", 35, 27);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Física", '2022','12:32:06', '10:50:00', "Oscar Bernard", "C36", 41, 18);
INSERT INTO materia (nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo)
VALUES ("Historia", '2020','15:00:00', '16:50:00', "Diego Armando", "C37", 50, 25);