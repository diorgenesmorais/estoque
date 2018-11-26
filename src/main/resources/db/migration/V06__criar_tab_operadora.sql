create table operadoras (
	id int unsigned auto_increment,
	nome varchar(30) not null comment "Operadora de cartão",
	primary key (id)
) engine=InnoDB character set utf8mb4;
