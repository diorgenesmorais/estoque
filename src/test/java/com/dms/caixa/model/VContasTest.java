package com.dms.caixa.model;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.VContasRepository;

public class VContasTest extends AbstractTest {

	@Autowired
	private VContasRepository repository;

	@Test
	public void deveFormaDePagtoEmDinheiro() throws Exception {
		String expected = "DIN em Caixa";

		VContas conta = repository.findByConta(expected);

		Assert.assertThat(conta.getConta(), CoreMatchers.containsString(expected));
	}
}
