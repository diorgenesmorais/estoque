package com.dms.caixa.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dms.caixa.BaseTest;

import io.restassured.RestAssured;

public class ContaResourceXMLTest extends BaseTest {

	@BeforeClass
	public static void setup() {
		RestAssured.basePath = "/XML";
	}

	@Test
	public void deveVerificarContasEmXML() throws Exception {
		given()
			.log().uri()
		.when()
			.get("/contas")
		.then()
			.assertThat()
			.statusCode(200)
			.body("id.findAll{it == 2}", hasItem(2))
			.body("operadora.nome", hasItem("REDE"))
			;
	}

}
