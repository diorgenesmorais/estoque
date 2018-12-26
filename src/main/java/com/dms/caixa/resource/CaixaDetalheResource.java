package com.dms.caixa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.model.CaixaDetalhe;
import com.dms.caixa.service.CaixaDetalheService;

@RestController
@RequestMapping("/caixa-detalhes")
public class CaixaDetalheResource {

	@Autowired
	private CaixaDetalheService service;

	@GetMapping
	public List<CaixaDetalhe> listar() {
		return service.listar();
	}

	@GetMapping("/{caixaId}")
	public ResponseEntity<List<CaixaDetalhe>> buscarPorCaixa(@PathVariable Integer caixaId) {
		List<CaixaDetalhe> detalhes = service.buscarPorId(caixaId);
		return ResponseEntity.ok(detalhes);
	}
}
