package com.dms.caixa.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.CaixaContigenciaRepository;

public class CaixaContigenciaTest extends AbstractTest {

	@Autowired
	private CaixaContigenciaRepository repository;

	@Test
	public void deveObterOTrocoCerto() throws Exception {
		BigDecimal expected = new BigDecimal(16.25).setScale(2, RoundingMode.DOWN);

		Optional<CaixaContigencia> caixa = repository.findById(1);
		BigDecimal troco = caixa.get().getPago().subtract(caixa.get().getValor());

		Assert.assertEquals(expected, troco);
	}
}
