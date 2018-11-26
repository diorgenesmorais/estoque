create table caixa_contigencia (
	id int unsigned auto_increment,
	usuario_id int unsigned not null,
	pedido int unsigned not null,
	valor decimal(10,2) not null default 0,
	forma_pagto int unsigned not null,

	constraint FK
	constraint FK_usuario_caixa
	forein key (usuario_id) references usuarios (id),
	primary key (id)
) Engine=InnoDB default charset=utf8;
