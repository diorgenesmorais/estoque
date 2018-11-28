package com.dms.caixa.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.FormaRepository;

public class FormaTest extends AbstractTest {

	@Autowired
	private FormaRepository repository;

	@Test
	public void deveObeterFormaPagtoDinheiro() throws Exception {
		Optional<Forma> actual = Optional.of(new Forma());
		actual.get().setId(4);

		Optional<Forma> forma = repository.findById(4);

		assertThat(actual, equalTo(forma));
	}
}
