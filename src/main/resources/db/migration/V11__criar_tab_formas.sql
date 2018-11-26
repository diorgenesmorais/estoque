create table formas (
	id int unsigned auto_increment,
	pagto char(3) not null comment "Para o tipo de pagto: parcelado, rotativo...",
	cartao_id int unsigned not null,
	primary key (id),
	constraint FK_cartao_forma
	foreign key (cartao_id) references cartao (id)
	on delete restrict
) engine=InnoDB character set utf8mb4;
