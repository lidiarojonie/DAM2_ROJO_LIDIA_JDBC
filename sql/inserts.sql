INSERT INTO AGENCIAS (agencia_id, nombre, pais fecha_fundacion, autor_examen, ) VALUES (1, "NASA", "ESTADOS_UNIDOS", "ROJO_LIDIA_DAM2");
INSERT INTO AGENCIAS (agencia_id, nombre, pais fecha_fundacion, autor_examen, ) VALUES (2, "ESA", "ESPAÑA", "ROJO_LIDIA_DAM2");
INSERT INTO AGENCIAS (agencia_id, nombre, pais fecha_fundacion, autor_examen, ) VALUES (3, "OSA", "JAPON", "ROJO_LIDIA_DAM2");
INSERT INTO AGENCIAS (agencia_id, nombre, pais fecha_fundacion, autor_examen, ) VALUES (4, "LSA", "CHINA", "ROJO_LIDIA_DAM2");
INSERT INTO AGENCIAS (agencia_id, nombre, pais fecha_fundacion, autor_examen, ) VALUES (5, "JED", "POLONIA", "ROJO_LIDIA_DAM2");

INSERT INTO SATELITES (satelite_id, nombre, orbita, peso, coste, activo, fecha_lanzamiento, agencia_id, autor_examen) VALUES (1, "O123", "SATURNO", 156484, 9719.99 , True, '14/02/1992', 5,"ROJO_LIDIA_DAM2");
INSERT INTO SATELITES (satelite_id, nombre, orbita, peso, coste, activo, fecha_lanzamiento, agencia_id, autor_examen) VALUES (2, "L489", "MERCURIO", 379827, 4914.99, False, '07/2/2000', 3,"ROJO_LIDIA_DAM2");
INSERT INTO SATELITES (satelite_id, nombre, orbita, peso, coste, activo, fecha_lanzamiento, agencia_id, autor_examen) VALUES (3, "K489", "LUNA", 341, 78901.99, False, '06/12/2004', 4,"ROJO_LIDIA_DAM2");
INSERT INTO SATELITES (satelite_id, nombre, orbita, peso, coste, activo, fecha_lanzamiento, agencia_id, autor_examen) VALUES (4, "R448", "JUPITER", 178381, 487971.99, True, '22/02/1998', 1,"ROJO_LIDIA_DAM2");
INSERT INTO SATELITES (satelite_id, nombre, orbita, peso, coste, activo, fecha_lanzamiento, agencia_id, autor_examen) VALUES (5, "Y117", "JUPITER", 19531, 78979.99, False, '03/11/1983', 2,"ROJO_LIDIA_DAM2");

INSERT INTO DETALLE_SATELITE (detalle_satelite_id, velocidadMaxima, combustible, diasVidaUtil, temperatura_maxima, satelite_id, autor_examen) VALUES (1, 28921, 1000, 100, 153, 1, "ROJO_LIDIA_DAM2");
INSERT INTO DETALLE_SATELITE (detalle_satelite_id, velocidadMaxima, combustible, diasVidaUtil, temperatura_maxima, satelite_id, autor_examen) VALUES (2, 20145, 8547, 152, 895, 2, "ROJO_LIDIA_DAM2");
INSERT INTO DETALLE_SATELITE (detalle_satelite_id, velocidadMaxima, combustible, diasVidaUtil, temperatura_maxima, satelite_id, autor_examen) VALUES (3, 12425, 3362, 234, 1524, 3, "ROJO_LIDIA_DAM2");
INSERT INTO DETALLE_SATELITE (detalle_satelite_id, velocidadMaxima, combustible, diasVidaUtil, temperatura_maxima, satelite_id, autor_examen) VALUES (4, 14253, 4758, 88, 885, 4, "ROJO_LIDIA_DAM2");
INSERT INTO DETALLE_SATELITE (detalle_satelite_id, velocidadMaxima, combustible, diasVidaUtil, temperatura_maxima, satelite_id, autor_examen) VALUES (5, 20014, 6245, 147, 364, 5, "ROJO_LIDIA_DAM2");