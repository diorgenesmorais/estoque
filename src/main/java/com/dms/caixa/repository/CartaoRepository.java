package com.dms.caixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.caixa.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

	Cartao findByTipo(String string);

}
