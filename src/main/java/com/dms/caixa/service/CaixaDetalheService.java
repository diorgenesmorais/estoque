package com.dms.caixa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.caixa.model.CaixaDetalhe;
import com.dms.caixa.repository.CaixaDetalheRepository;

@Service
public class CaixaDetalheService {

	@Autowired
	private CaixaDetalheRepository repository;

	public List<CaixaDetalhe> buscarPorId(Integer id) {
		return repository.findByCaixa(id);
	}

	public List<CaixaDetalhe> listar() {
		return repository.findAll();
	}

	public List<CaixaDetalhe> salvar(List<CaixaDetalhe> caixaDetalhes) {
		return repository.saveAll(caixaDetalhes);
	}
}
