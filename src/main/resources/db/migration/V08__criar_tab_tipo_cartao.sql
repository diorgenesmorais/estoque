create table cartao (
	id int unsigned auto_increment,
	tipo varchar(7) not null,
	primary key (id)
) engine=InnoDB character set utf8mb4;

insert into cartao (tipo) values ('CRÉDITO'),('DÉBITO');
