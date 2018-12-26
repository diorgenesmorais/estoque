package com.dms.caixa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.caixa.model.CaixaDetalhe;

public interface CaixaDetalheRepository extends JpaRepository<CaixaDetalhe, Integer> {

	public List<CaixaDetalhe> findByCaixa(Integer caixaId);
}
