package org.certificatic.spring.core.practica10.test.beanpostprocessors;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessorsTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica10/bean-post-processors-application-context.xml");
	}

	@Test
	public void beanPostProcessorsTest() {

		log.info("beanPostProcessorsTest -------------------");

		Worker worker = applicationContext.getBean(Worker.class);

		Assert.assertNotNull(worker);

		log.info("worker: {}", worker);

		((AbstractApplicationContext) applicationContext).close();
	}

}
