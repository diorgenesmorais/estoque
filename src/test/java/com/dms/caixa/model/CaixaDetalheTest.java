package com.dms.caixa.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.service.CaixaDetalheService;

public class CaixaDetalheTest extends AbstractTest {

	@Autowired
	private CaixaDetalheService service;

	@Test
	public void deveSomarValoresPago() throws Exception {
		BigDecimal expected = new BigDecimal(60).setScale(2, RoundingMode.DOWN);

		List<CaixaDetalhe> lista = service.buscarPorId(1);
		BigDecimal actual = lista.stream().map(CaixaDetalhe::getPago).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void deveLancaConstraintViolationException() throws Exception {
		//exception.expect(ConstraintViolationException.class);
		
		
	}
}
