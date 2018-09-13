package org.certificatic.spring.core.practica17.test.stereotypes;

import org.certificatic.spring.core.practica17.stereotypes.api.IRestControllerClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StereotypesTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica17/component-scan-stereotypes-application-context.xml");
	}

	@Test
	public void restControllerTest() {

		log.info("restControllerTest -------------------");

		IRestControllerClass restController = applicationContext.getBean(IRestControllerClass.class);

		String name = "My REST Controller Implementation";

		Assert.assertNotNull(restController);
		Assert.assertEquals(name, restController.getRestControllerClassName());

		log.info("restController: {}", restController);

		((AbstractApplicationContext) applicationContext).close();
	}

}
