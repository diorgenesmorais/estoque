package com.dms.caixa.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.dms.caixa.BaseTest;

import io.restassured.http.ContentType;

public class BandeiraResourceTest extends BaseTest {

	@Test
	public void deveObterUmaBandeiraEmJson() throws Exception {
		given()
			.accept(ContentType.JSON) // não é necessário informar
			.pathParam("resource", "bandeiras")
			.pathParam("id", 6)
		.when()
			.get("/{resource}/{id}")
		.then().assertThat().statusCode(200)
			.and()
			.body("id", is(6))
			.and()
			.body("nome", is("Maestro"))
			.and()
			.body("descricao", is("Redeshop débito"))
			;
	}

	@Test
	public void deveObterBandeiraEmXML() throws Exception {
		given()
			.accept(ContentType.XML)
		.when()
			.get("/{resource}/{id}", "bandeiras", 6)
		.then().assertThat().statusCode(200)
			.and()
			.rootPath("Bandeira")
			.and()
			.body("id", is("6"))
			.and()
			.body("nome", is("Maestro"))
			.and()
			.log().all()
			;
	}
}
