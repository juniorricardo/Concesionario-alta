-- Crear una nueva tabla llamada 'Autos' en la base de datos 'jdbc:h2:~/test'
-- Crear la tabla en la base de datos indicada
CREATE TABLE Auto
(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Marca VARCHAR(15) NOT NULL,
    Modelo VARCHAR(25) NOT NULL,
    Precio DOUBLE NOT NULL
    -- Agregar mas columnas si se desea
);

-- Insertar registros en la tabla 'Autos'
INSERT INTO Auto
    -- columnas a insertar datos
    ( Marca, Modelo, Precio )
VALUES
    -- primera fila: valores de las columna mencionada anteriormente
    ( 'Ford', 'Camaro', 73000.0 ),
    ( 'Lamborghini', 'Reventon', 1700000.0 ),
    ( 'Mercedez-Benz', 'AMG GTR', 187000.0 ),
    ( 'McLaren ', '720s', 380000.0 ),
    ( 'Porsche ', '911R', 449000.0 ),
    ( 'Lamborghini', 'Huracán Performante', 330000.0 ),
    ( 'Karma', 'Revero', 130000.0 ),
    ( 'Ford', 'GT', 500000.0 );
    -- agregar mas registros si se desea
