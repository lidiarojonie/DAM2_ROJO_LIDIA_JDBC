1- Explica cómo funciona la relación 1:N entre Agencia y Satelite tanto en SQL como en Java.

Cada satelite está asociado a una agencia. Cada agencia puede tener más de un satelite, por eso en el SQL, el campo de union entre las 2 tablas está en satelite. Cada satelite tiene 1 sola agencia, pero cada agencia puede tener más de uno.


2- Explica por qué en Java utilizamos:
private Agencia agencia;
y no:
private int agenciaId;

Utilizamos la primera para que nos devue