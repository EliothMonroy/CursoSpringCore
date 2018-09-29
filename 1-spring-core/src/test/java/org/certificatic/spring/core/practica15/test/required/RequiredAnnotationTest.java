package org.certificatic.spring.core.practica15.test.required;

import org.certificatic.spring.core.practica15.required.bean.Cameraman;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequiredAnnotationTest {

	@Test
	public void requiredAnnotationTest() {

		log.info("requiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(ctxFile);
		Cameraman cameraman=ctx.getBean("okCameraman",Cameraman.class);
		Assert.notNull(cameraman);
		Assert.notNull(cameraman.getName());
		Assert.notNull(cameraman.getDni());
		//Assert.notNull(cameraman);
		log.info("cameraman: {}",cameraman);
	}

	@Test(expected = BeanCreationException.class)
	public void badRequiredAnnotationTest() {

		log.info("badRequiredAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-required-application-context.xml";

		// Implementar
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(ctxFile);
		Cameraman cameraman=ctx.getBean("badCameraman",Cameraman.class);
		Assert.notNull(cameraman);
		Assert.notNull(cameraman.getName());
		Assert.notNull(cameraman.getDni());
		//Assert.notNull(cameraman);
		log.info("cameraman: {}",cameraman);
	}

}
