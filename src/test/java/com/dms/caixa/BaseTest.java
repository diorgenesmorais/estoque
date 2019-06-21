package com.dms.caixa;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class BaseTest {

	@Value("${local.server.port}")
	private int port;
	
	@Before
	public void set() {
		RestAssured.port = port;
	}
}
