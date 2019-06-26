package com.dms.caixa.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.dms.caixa.BaseTest;

import io.restassured.http.ContentType;

public class ContaResourceTest extends BaseTest {

	@Test
	public void deveObterTaxaMasterRedeEmJson() throws Exception {
		// status code redundante (definida na base)
		/*
		 * NOTA: Anotei o pathParam no requestSpecification e gerou conflito ao
		 * executar o teste pelo Maven.
		 */

		given()
			.accept(ContentType.JSON) // por default já irá retornar um Json
			.pathParam("id", 2)
		.when()
			.get("/contas/{id}")
		.then().assertThat().statusCode(200)
			.and()
			.body("operadora.nome", is("REDE"))
			.and()
			.body("forma.tipo", is("ROT"))
			.and()
			.body("forma.cartao.tipo", is("CRÉDITO"))
			.and()
			.body("bandeira.nome", is("Master"))
			.and()
			.body("diasVencimento", is(30))
			.and()
			.body("taxa", is(0.0368f))
			;
	}

	@Test
	public void deveVerificarContaComDetalhesNaListaEmJson() throws Exception {
		given()
			.pathParam("resource", "contas")
		.when()
			.get("/{resource}")
		.then().assertThat().statusCode(200)
			.and()
			.body("find{it.id == 2}.id", is(2))
			.and()
			.body("bandeira.nome", hasItem("Master"))
			;
	}

	@Test
	public void deveVerificarContasEmXML() throws Exception {
		given()
			.log().headers()
			.accept(ContentType.XML)
		.when()
			.get("/{resource}", "contas")
		.then().assertThat().statusCode(200)
			.and()
			.rootPath("List.item")
			.body("id.find{it == 2}", is("2"))
			.and()
			.body("operadora.nome", hasItem("REDE"))
			.and()
			.log().all()
			;
	}
}
