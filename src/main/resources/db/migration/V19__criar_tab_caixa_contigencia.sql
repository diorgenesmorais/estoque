create table caixa_contigencia (
	id int unsigned auto_increment,
	usuario_id int unsigned not null,
	pedido int unsigned not null,
	valor decimal(10,2) not null default 0,
	conta_id int unsigned not null comment "forma de pagto",
	pago decimal(10,2) not null default 0,
	constraint FK_usuario_caixa
	foreign key (usuario_id) references usuarios (id),
	constraint FK_contas_caixa
	foreign key (conta_id) references contas (id),
	primary key (id)
) Engine=InnoDB default charset=utf8;
