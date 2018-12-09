package com.dms.caixa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dms.caixa.model.CaixaContingencia;
import com.dms.caixa.repository.CaixaContingenciaRepository;

@Service
public class CaixaContingenciaService {

	@Autowired
	private CaixaContingenciaRepository repository;

	public List<CaixaContingencia> listar() {
		return repository.findAll();
	}

	public CaixaContingencia buscarPorId(Integer id) {
		Optional<CaixaContingencia> caixa = repository.findById(id);
		if (!caixa.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return caixa.get();
	}
}
