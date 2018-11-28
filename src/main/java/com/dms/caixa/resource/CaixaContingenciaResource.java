package com.dms.caixa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.model.CaixaContingencia;
import com.dms.caixa.repository.CaixaContingenciaRepository;

@RestController
@RequestMapping("/caixas")
public class CaixaContingenciaResource {

	@Autowired
	private CaixaContingenciaRepository repository;

	@GetMapping
	public List<CaixaContingencia> listar() {
		return repository.findAll();
	}
}
