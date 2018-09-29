package org.certificatic.spring.core.practica15.test.autowired.constructor;

import org.certificatic.spring.core.practica15.autowired.constructor.bean.Engineer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredConstructorAnnotationTest {

	@Test
	public void autowiredConstructorAnnotationTest() {

		log.info("autowiredConstructorAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-constructor-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);

		Engineer engineer = ctx.getBean(Engineer.class);

		Assert.assertNotNull(engineer);

		Assert.assertNotNull(engineer.getName());
		Assert.assertNotNull(engineer.getAge());
		Assert.assertNotNull(engineer.getLaptop());
		Assert.assertNotNull(engineer.getStylus());

		log.info("engineer: {}", engineer);

		ctx.close();
	}

}
