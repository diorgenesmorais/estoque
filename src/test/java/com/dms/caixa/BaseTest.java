package com.dms.caixa;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations="classpath:test.properties")
public abstract class BaseTest {

	public static RequestSpecification requestSpecification;
	public static ResponseSpecification responseSpecification;

	@BeforeClass
	public static void setup() {
		// port was not set because the default is 8080, defined in test.properties
		requestSpecification = new RequestSpecBuilder()
				.log(LogDetail.METHOD)
				.log(LogDetail.URI)
				.build();
		responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.build();
		RestAssured.requestSpecification = requestSpecification;
		RestAssured.responseSpecification = responseSpecification;
	}
}
