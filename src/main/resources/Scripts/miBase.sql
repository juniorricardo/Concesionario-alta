-- Crear una nueva tabla llamada 'Autos' en la base de datos 'jdbc:h2:~/test'
-- Crear la tabla en la base de datos indicada
CREATE TABLE Autos
(
    Marca VARCHAR(15) NOT NULL,
    Modelo VARCHAR(25) NOT NULL,
    Precio DOUBLE NOT NULL
    -- Agregar mas columnas si se desea
);

-- Insertar registros en la tabla 'Autos'
INSERT INTO Autos
    -- columns to insert data into
    ( Marca, Modelo, Precio )
VALUES
    -- first row: values for the columns in the list above
    ( 'Ford', 'Camaro', 73000.0 ),
    ( 'Lamborghini', 'Reventon', 1700000.0 ),
    ( 'Mercedez-Benz', 'AMG GTR', 187000.0 ),
    ( 'McLaren ', '720s', 380000.0 ),
    ( 'Porsche ', '911R', 449000.0 ),
    ( 'Lamborghini', 'Huracán Performante', 330000.0 ),
    ( 'Karma', 'Revero', 130000.0 ),
    ( 'Ford', 'GT', 500000.0 );
    -- add more rows here
