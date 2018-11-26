create table usuarios (
	id int unsigned auto_increment,
	nome varchar(45) not null,
	email varchar(128) not null,
	passe varchar(64) not null,
	primary key (id)
) engine=InnoDB character set=utf8mb4;
