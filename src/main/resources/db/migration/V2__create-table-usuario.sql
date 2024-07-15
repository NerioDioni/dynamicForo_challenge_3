create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    clave varchar(10) not null unique,

    primary key(id)

);