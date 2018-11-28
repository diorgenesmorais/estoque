package com.dms.caixa.model;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.ContaRepository;


public class ContaTest extends AbstractTest {

	@Autowired
	private ContaRepository repository;
	
	@Test
	public void deveObterContaComOperadoraCaixa() throws Exception {
		Operadora operadora = new Operadora();
		operadora.setId(3); // id da operadora: Caixa
		Optional<Conta> actual = Optional.of(new Conta());
		actual.get().setOperadora(operadora);
		
		Optional<Conta> conta = repository.findById(1);
		
		Assert.assertEquals(actual.get().getOperadora(), conta.get().getOperadora());
	}
}
