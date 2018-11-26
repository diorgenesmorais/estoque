create table permissoes (
	id int unsigned auto_increment,
	role varchar(30) not null comment "Tipo da permissão",
	nota varchar(255),
	primary key (id)
) engine=InnoDB character set=utf8;
