create table topicos (
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fecha_creacion DATE NOT NULL,
    estado tinyint(1),
    autor_id bigint not null,
    curso_id bigint not null,
	PRIMARY KEY (id),
	FOREIGN KEY(curso_id) references cursos (id)
    on delete cascade on update cascade,
    FOREIGN KEY(autor_id) references usuarios (id)
    on delete cascade on update cascade

);