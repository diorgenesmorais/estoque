package com.dms.caixa.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.dms.caixa.BaseTest;

import io.restassured.http.ContentType;

public class BandeiraResourceTest extends BaseTest {

	private String recurso = "bandeiras";
	private Integer id = 6;

	@Test
	public void deveObterUmaBandeiraEmJson() throws Exception {
		given()
			.accept(ContentType.JSON) // não é necessário informar
			.pathParam("recurso", recurso)
			.pathParam("id", id)
		.when()
			.get("/{recurso}/{id}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("id", is(6))
			.body("nome", is("Maestro"))
			.body("descricao", is("Redeshop débito"))
			;
	}

	@Test
	public void deveObterBandeiraEmXML() throws Exception {
		given()
			.accept(ContentType.XML)
			.pathParam("recurso", recurso)
			.pathParam("id", id)
		.when()
			.get("/{recurso}/{id}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.rootPath("Bandeira")
			.body("id", is("6"))
			.body("nome", is("Maestro"))
			;
	}
}
