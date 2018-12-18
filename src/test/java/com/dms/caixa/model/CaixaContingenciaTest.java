package com.dms.caixa.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.service.CaixaContingenciaService;

public class CaixaContingenciaTest extends AbstractTest {

	@Autowired
	private CaixaContingenciaService service;

	@Test
	public void deveObterOTrocoCerto() throws Exception {
		BigDecimal expected = new BigDecimal(26.25).setScale(2, RoundingMode.DOWN);

		CaixaContingencia caixa = service.buscarPorId(1);
		BigDecimal troco = caixa.getTroco();

		Assert.assertEquals(expected, troco);
	}
}
