package com.dms.caixa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.model.Conta;
import com.dms.caixa.repository.ContaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contas")
public class ContaResource {

	@Autowired
	private ContaRepository repository;

	@ApiOperation(value = "Listar contas")
	@GetMapping
	public List<Conta> listar() {
		return repository.findAll();
	}
}
