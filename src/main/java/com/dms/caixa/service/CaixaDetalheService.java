package com.dms.caixa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dms.caixa.model.CaixaDetalhe;
import com.dms.caixa.repository.CaixaDetalheRepository;

@Service
public class CaixaDetalheService {

	@Autowired
	private CaixaDetalheRepository repository;

	public List<CaixaDetalhe> buscarPorId(Integer id) {
		List<CaixaDetalhe> detalhes = repository.findByCaixa(id);
		if(detalhes.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return detalhes;
	}

	public List<CaixaDetalhe> listar() {
		return repository.findAll();
	}

	public List<CaixaDetalhe> salvar(List<CaixaDetalhe> caixaDetalhes) {
		return repository.saveAll(caixaDetalhes);
	}
}
