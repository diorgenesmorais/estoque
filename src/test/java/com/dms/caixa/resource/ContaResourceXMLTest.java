package com.dms.caixa.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dms.caixa.BaseTest;

public class ContaResourceXMLTest extends BaseTest {

	@BeforeClass
	public static void init() {
		requestSpecification.basePath("/XML");
	}

	@Test
	public void deveVerificarContasEmXML() throws Exception {
		given()
		.when()
			.get("/contas")
		.then()
			.assertThat()
			.body("id.find{it == 2}", is(2))
			.body("operadora.nome", hasItem("REDE"))
			;
	}

}
