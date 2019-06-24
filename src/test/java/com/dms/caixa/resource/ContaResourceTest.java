package com.dms.caixa.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.dms.caixa.BaseTest;

public class ContaResourceTest extends BaseTest {

	@Test
	public void deveObterTaxaMasterRede() throws Exception {
		given()
		.when()
			.get("/contas/2")
		.then()
			.assertThat()
			.body("operadora.nome", is("REDE"))
			.body("forma.tipo", is("ROT"))
			.body("forma.cartao.tipo", is("CRÉDITO"))
			.body("bandeira.nome", is("Master"))
			.body("diasVencimento", is(30))
			.body("taxa", is(0.0368f))
			;
	}

	@Test
	public void deveVerificarContaComDetalhesNaLista() throws Exception {
		given()
		.when()
			.get("/contas")
		.then()
			.assertThat()
			.body("find{it.id == 2}.id", is(2))
			.body("bandeira.nome", hasItem("Master"))
			;
	}

}
