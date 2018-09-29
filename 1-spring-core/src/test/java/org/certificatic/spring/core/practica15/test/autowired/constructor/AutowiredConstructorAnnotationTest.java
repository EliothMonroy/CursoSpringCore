package org.certificatic.spring.core.practica15.test.autowired.constructor;

import org.certificatic.spring.core.practica15.autowired.constructor.bean.Engineer;
import org.certificatic.spring.core.practica15.autowired.setter.bean.Journalist;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredConstructorAnnotationTest {

	@Test
	public void autowiredConstructorAnnotationTest() {

		log.info("autowiredConstructorAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-constructor-application-context.xml";

		// Implementar
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(ctxFile);
		Engineer engineer=ctx.getBean(Engineer.class);
		Assert.notNull(engineer);
		Assert.notNull(engineer.getName());
		Assert.notNull(engineer.getAge());
		Assert.notNull(engineer.getLaptop());
		Assert.notNull(engineer.getStylus());
		log.info("engineer: {}",engineer);
		ctx.close();
	}

}
