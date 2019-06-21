package com.dms.caixa.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import com.dms.caixa.BaseTest;

public class BandeiraResourceTest extends BaseTest {

	@Test
	public void deveObterUmaBandeira() throws Exception {
		given()
		.when()
			.get("/bandeiras/1")
		.then()
			.assertThat()
			.statusCode(200)
			.body("id", is(1))
			;
	}
}
