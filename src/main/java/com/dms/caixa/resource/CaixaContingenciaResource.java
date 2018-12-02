package com.dms.caixa.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	public ResponseEntity<CaixaContingencia> buscarPorId(@PathVariable Integer id) {
		Optional<CaixaContingencia> caixa = repository.findById(id);
		return caixa.isPresent() ? ResponseEntity.ok(caixa.get()) : ResponseEntity.notFound().build();
	}
}
