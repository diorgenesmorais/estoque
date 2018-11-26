create view v_contas as
	select contas.id, concat(formas.pagto, " ", bandeiras.nome, " ", operadoras.nome) as conta, dias_venc, max_parc, taxa, taxa_acima from contas
	inner join formas on formas.id=forma_id	
	inner join bandeiras on bandeiras.id=bandeira_id
	inner join operadoras on operadoras.id=operadora_id;
