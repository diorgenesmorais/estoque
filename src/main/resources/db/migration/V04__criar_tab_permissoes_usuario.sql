create table permissoes_usuario (
	permissao_id int unsigned not null,
	usuario_id int unsigned not null,
	primary key (permissao_id, usuario_id),
	constraint FK_permissao_usuario
	foreign key (permissao_id) references permissoes (id),
	constraint FK_usuario_permissao
	foreign key (usuario_id) references usuarios (id)
) engine=InnoDB;
