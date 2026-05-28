-- Agencias

SELECT * 
FROM AGENCIAS 
ORDER BY id;

SELECT * 
FROM AGENCIAS 
WHERE id = ?;

INSERT INTO AGENCIAS (nombre, pais fecha_fundacion, autor_examen) VALUES (?, ?, ?, ?);

UPDATE AGENCIAS SET nombre = ?,pais = ?, fecha_fundacion = ?, autor_examen = ? 
WHERE id = ?;

DELETE FROM agencias 
WHERE id = ?;



-- Satelites

SELECT S.ID, S.NOMBRE, S.ORBITA, S.PESO, S.COSTE, S.ACTIVO, S.AGENCIA, D.ID, D.VELOCIDAD_MAXIMA, D.COMBUSTIBLE, D.DIAS_VIDA_UTIL 
FROM SATELITES S INNER JOIN DETALLE_SATELITES D ON S.ID = D.SATELITE_ID 
WHERE P.ID = ? 
ORDER BY P.ID;

SELECT * 
FROM SATELITES 
ORDER BY id;

SELECT * 
FROM SATELITES
WHERE id = ?;                    

INSERT INTO SATELITES (nombre, orbita, peso, coste) VALUES (?, ?, ?, ?);        
       
UPDATE satelites SET nombre = ?, orbita = ?, peso = ?, coste = ?, activo = ? 
WHERE id = ?;

DELETE FROM satelites 
WHERE id = ?;

SELECT * 
FROM satelites
WHERE agencia = ? 
ORDER BY nombre;
