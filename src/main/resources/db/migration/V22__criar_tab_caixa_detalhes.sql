create table caixa_detalhes (
	id int unsigned auto_increment,
	caixa_id int unsigned not null,
	conta_id int unsigned not null,
	pago decimal(10,2) not null default 0,
	constraint FK_caixa_contingencia_detalhes
	foreign key (caixa_id) references caixa_contingencia (id),
	constraint FK_contas_caixa_detalhes
	foreign key (conta_id) references contas (id),
	primary key (id)
) engine=InnoDB;

alter table caixa_contingencia drop foreign key FK_contas_caixa;
alter table caixa_contingencia drop index FK_contas_caixa;
alter table caixa_contingencia drop column pago, drop column conta_id;
