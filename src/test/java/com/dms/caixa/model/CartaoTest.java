package com.dms.caixa.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.CartaoRepository;

public class CartaoTest extends AbstractTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	private CartaoRepository repository;

	@Test
	public void deveObterCartaoTipoDinheiro() {
		Cartao actual = new Cartao();
		actual.setId(3);

		Cartao tipo = repository.findByTipo("DINHEIRO");

		Assert.assertEquals(actual, tipo);
	}
}
