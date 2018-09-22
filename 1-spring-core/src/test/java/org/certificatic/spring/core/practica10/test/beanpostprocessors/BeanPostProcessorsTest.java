package org.certificatic.spring.core.practica10.test.beanpostprocessors;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.api.IWorker;
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

		IWorker worker = applicationContext.getBean(IWorker.class);

		Assert.assertNotNull(worker);

		log.info("worker: {}", worker);

		worker.showInfo();

		((AbstractApplicationContext) applicationContext).close();
	}

}
