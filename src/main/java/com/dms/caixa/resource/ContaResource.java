package com.dms.caixa.resource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.model.Conta;
import com.dms.caixa.repository.ContaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/contas", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ContaResource {

	@Autowired
	private ContaRepository repository;

	@ApiOperation(value = "Listar contas")
	@GetMapping
	public ResponseEntity<List<Conta>> listar() {
		List<Conta> contas = repository.getAll();

		CacheControl cacheControl = CacheControl.maxAge(1000, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(contas);
	}
}
