package com.dms.caixa.resource;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.model.Conta;
import com.dms.caixa.repository.ContaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class ContaResource {

	@Autowired
	private ContaRepository repository;

	@ApiOperation(value = "Listar contas")
	@RequestMapping(path = "/contas", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Conta>> listar() {
		List<Conta> contas = repository.getAll();

		CacheControl cacheControl = CacheControl.maxAge(3600, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(contas);
	}

	@RequestMapping(path = "/contas/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Conta> buscarPorConta(@PathVariable Integer id){
		Optional<Conta> conta = repository.findById(id);
		
		CacheControl cacheControl = CacheControl.maxAge(3600, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(conta.get());
	}

	@RequestMapping(path = "/XML/contas", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Conta>> listarXML() {
		List<Conta> contas = repository.getAll();

		CacheControl cacheControl = CacheControl.maxAge(3600, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(contas);
	}
}
