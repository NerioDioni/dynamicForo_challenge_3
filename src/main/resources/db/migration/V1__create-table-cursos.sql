create table cursos(

id bigint not null auto_increment,
nombre varchar(200) not null unique,
categoria varchar(200) not null,

 primary key(id)
);