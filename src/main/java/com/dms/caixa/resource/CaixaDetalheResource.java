package com.dms.caixa.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.event.ResourceCreatedEventImpl;
import com.dms.caixa.model.CaixaDetalhe;
import com.dms.caixa.service.CaixaDetalheService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/caixa-detalhes")
public class CaixaDetalheResource {

	@Autowired
	private CaixaDetalheService service;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public ResponseEntity<List<CaixaDetalhe>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{caixaId}")
	public ResponseEntity<List<CaixaDetalhe>> buscarPorCaixa(@PathVariable Integer caixaId) {
		List<CaixaDetalhe> detalhes = service.buscarPorId(caixaId);
		return ResponseEntity.ok(detalhes);
	}

	@ApiOperation(value = "Adicionar uma lista de formas de pagtos")
	@PostMapping
	public ResponseEntity<List<CaixaDetalhe>> adicionar(@RequestBody List<CaixaDetalhe> caixaDetalhes,
			HttpServletResponse response) {
		List<CaixaDetalhe> adicionados = service.salvar(caixaDetalhes);
		Integer caixaId = adicionados.get(0).getCaixa();

		publisher.publishEvent(new ResourceCreatedEventImpl(this, response, caixaId));

		return ResponseEntity.status(HttpStatus.CREATED).body(adicionados);
	}
}
