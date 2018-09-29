package org.certificatic.spring.core.practica15.test.autowired.properties;


import org.certificatic.spring.core.practica15.autowired.properties.bean.Reporter;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredPropertiesAnnotationTest {

	@Test
	public void autowiredPropertiesAnnotationTest() {

		log.info("autowiredPropertiesAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-property-application-context.xml";

		// Implementar
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(ctxFile);
		Reporter reporter=ctx.getBean(Reporter.class);
		Assert.notNull(reporter);
		Assert.notNull(reporter.getName());
		Assert.notNull(reporter.getAge());
		Assert.notNull(reporter.getBooklet());
		Assert.notNull(reporter.getPencil());
		log.info("reporter: {}",reporter);
		ctx.close();
	}

}
