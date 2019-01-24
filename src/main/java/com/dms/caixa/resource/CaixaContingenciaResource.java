package com.dms.caixa.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.event.ResourceCreatedEventImpl;
import com.dms.caixa.model.CaixaContingencia;
import com.dms.caixa.service.CaixaContingenciaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/caixas", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class CaixaContingenciaResource {

	@Autowired
	private CaixaContingenciaService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@ApiOperation(value = "Listar todos os caixas")
	@GetMapping
	public List<CaixaContingencia> listar() {
		return service.listar();
	}

	@ApiOperation(value = "Obter um caixa pelo seu id")
	@GetMapping("/{id}")
	public ResponseEntity<CaixaContingencia> buscarPorId(@PathVariable Integer id) {
		CaixaContingencia caixa = service.buscarPorId(id);
		return ResponseEntity.ok(caixa);
	}

	@ApiOperation(value = "Adicionar um caixa")
	@PostMapping
	public ResponseEntity<CaixaContingencia> criar(@RequestBody CaixaContingencia caixa, HttpServletResponse response) {
		CaixaContingencia caixaSalva = service.salvar(caixa);
		
		publisher.publishEvent(new ResourceCreatedEventImpl(this, response, caixaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(caixaSalva);
	}
}
