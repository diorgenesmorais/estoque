package com.dms.caixa;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Nota: Se for inserido também na classe de teste a seguinte anotação
 * &#64;<code>org.springframework.transaction.annotation.Transactional</code>
 * será feito roolback após os testes.
 * 
 * @see documentation {@link https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html#testcontext-tx}
 * @author Diorgenes Morais
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CaixaApplication.class)
@TestPropertySource(locations="classpath:test.properties")
public abstract class AbstractTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
}
