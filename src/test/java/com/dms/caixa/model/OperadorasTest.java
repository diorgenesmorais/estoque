package com.dms.caixa.model;

import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.OperadoraRepository;

public class OperadorasTest extends AbstractTest {

	@Autowired
	private OperadoraRepository repository;

	@Test
	public void deveObterONomeCaixa() throws Exception {
		Operadora actual = new Operadora();
		actual.setId(3);

		Optional<Operadora> operadora = repository.findById(3);

		Assert.assertThat(actual.getId(), CoreMatchers.is(operadora.get().getId()));
	}
}
