-- Crear una nueva tabla llamada 'Autos' en la base de datos 'jdbc:h2:~/test'
-- Crear la tabla en la base de datos indicada
create TABLE `Autos`(
    id Long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Marca VARCHAR(15) NOT NULL,
    Modelo VARCHAR(25) NOT NULL,
    Precio DOUBLE NOT NULL
    -- Agregar mas columnas si se desea
);

-- Insertar registros en la tabla 'Autos'
insert into Autos
    -- columnas a insertar datos
    ( Marca, Modelo, Precio )
values
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


--CREATE database IF NOT exists `demo`;

--use `demo`;

create TABLE `bicicletas`(
 `id` long NOT NULL AUTO_INCREMENT,
 `marca` VARCHAR(45) NULL,
 `modelo` VARCHAR(45) NULL,
 PRIMARY KEY (`id`));


insert into bicicletas (`marca`, `modelo`) VALUES ('Venzo', 'MX-5');
insert into bicicletas (`marca`, `modelo`) VALUES ('Venzo', 'Viper');
 insert into bicicletas (`marca`, `modelo`) VALUES ('Trek', 'Procaliber');
 insert into bicicletas (`marca`, `modelo`) VALUES ('Giant', 'Escape 3');
 insert into bicicletas (`marca`, `modelo`) VALUES ('Giant', 'Reign Advanced');
 insert into bicicletas (`marca`, `modelo`) VALUES ('Shimano', 'Pro R29');


 -- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 -- https://platzi.com/tutoriales/1557-git-github/2304-instalar-oh-my-zsh-en-ubuntu/


----------------------------------------------------------------
DROP TABLE IF EXISTS TEST;
CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));
INSERT INTO TEST VALUES(1, 'Hello');
INSERT INTO TEST VALUES(2, 'World');
SELECT * FROM TEST ORDER BY ID;
UPDATE TEST SET NAME='Hi' WHERE ID=1;
DELETE FROM TEST WHERE ID=2;
-----------------------------------------------------------------

create table Empleado(
 id long not null AUTO_INCREMENT,
nombre varchar(25) not null,
apellido varchar(25),
primary key (Id)
);

create table Permiso(
 id long not null AUTO_INCREMENT,
comentario varchar(50) not null,
primary key (Id)
);

create table Empleado_Permiso(
 id long not null AUTO_INCREMENT,
empleadoId int not null,
permisoId int not null,
comentario varchar(10),
primary key (Id),
foreign key (empleadoId) references Empleado(Id)
);

INSERT INTO EMPLEADO ( NOMBRE , APELLIDO )
VALUES  ('Elisabeth','Kidd'),
        ('Irving','England'),
        ('Eddy','Carver'),
        ('Angie','Blevins'),
        ('Keira','McCullough');

insert into permiso ( comentario )
values ('leer'),('modificar'),('eliminar');

insert into empleado_permiso
                    ( empleadoid , permisoid , comentario )
values      (1,1,'paso1'),
            (1,2,'paso2'),
            (2,1,''),
            (2,2,'paso2'),
            (2,3,'23'),
            (3,1,'paso1'),
            (4,1,'pasi'),
            (5,1,'paso1'),
            (5,2,'paso2');