package com.dms.caixa.model;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.BandeirasRepository;

public class BandeirasTest extends AbstractTest {

	@Autowired
	private BandeirasRepository repository;

	@Test
	public void deveObterBandeiraMaster() throws Exception {
		String expected = "Master";

		Optional<Bandeira> bandeira = repository.findById(1);

		Assert.assertEquals(expected, bandeira.get().getNome());
	}
}
