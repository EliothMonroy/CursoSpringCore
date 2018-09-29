package org.certificatic.spring.core.practica15.test.autowired.setter;

import org.certificatic.spring.core.practica15.autowired.setter.bean.Journalist;
import org.certificatic.spring.core.practica15.required.bean.Cameraman;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredSetterAnnotationTest {

	@Test
	public void autowiredSetterAnnotationTest() {

		log.info("autowiredSetterAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-setter-application-context.xml";

		// Implementar
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(ctxFile);
		Journalist journalist=ctx.getBean(Journalist.class);
		Assert.notNull(journalist);
		Assert.notNull(journalist.getAge());
		Assert.notNull(journalist.getName());
		Assert.notNull(journalist.getNotebook());
		Assert.notNull(journalist.getPen());
		log.info("journalist: {}",journalist);
		ctx.close();
	}

}
