create table contas (
	id int unsigned auto_increment,
	operadora_id int unsigned not null,
	forma_id int unsigned not null,
	bandeira_id int unsigned not null,
	dias_venc tinyint(2) not null default 1 comment "Dias para vencimento",
	max_parc tinyint(2) not null default 1 comment "Número máximo de parcelas",
	taxa decimal(5,4) not null,
	taxa_acima decimal(5,4) not null comment "Acima do número máximo de parcelas",
	primary key (id),
	constraint FK_operadora_contas
	foreign key (operadora_id) references operadoras (id),
	constraint FK_forma_contas
	foreign key (forma_id) references formas (id),
	constraint FK_bandeira_contas
	foreign key (bandeira_id) references bandeiras (id)
) engine=InnoDB character set utf8mb4;
