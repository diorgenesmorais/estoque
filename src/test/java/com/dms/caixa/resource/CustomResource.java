package com.dms.caixa.resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import com.dms.caixa.AbstractTest;

public class CustomResource extends AbstractTest {

	private MockMvc mockMvc;

	@Autowired
	private ResourceTest resourceTest;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(resourceTest).build();
	}

	@Test
	public void deveResultarStatusOk() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deveRetornarNoAcceptable() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/test/noAcceptable")).andExpect(MockMvcResultMatchers.status().isNotAcceptable());
	}
	
	@Test
	public void deveLancarHttpMediaTypeNotAcceptableException() throws Exception {
		exception.expectMessage("Tipo de mídia não aceita");
		exception.expect(HttpMediaTypeNotAcceptableException.class);
		
		resourceTest.notAcceptable();
	}
}
