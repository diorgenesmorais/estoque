package com.dms.caixa.model;

import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dms.caixa.AbstractTest;
import com.dms.caixa.repository.UsuarioRepository;

public class UsuarioTest extends AbstractTest {

	@Autowired
	private UsuarioRepository repository;

	@Test
	public void deveObterOEmailDoUsuario() throws Exception {
		Optional<Usuario> actual = Optional.of(new Usuario());
		actual.get().setId(1);

		Optional<Usuario> usuario = repository.findByEmail("diorgenesmorais@gmail.com");

		Assert.assertThat(actual, CoreMatchers.is(usuario));
	}
}
