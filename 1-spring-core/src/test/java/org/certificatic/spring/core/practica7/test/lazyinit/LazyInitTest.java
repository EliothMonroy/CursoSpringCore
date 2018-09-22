package org.certificatic.spring.core.practica7.test.lazyinit;

import org.certificatic.spring.core.practica7.lazyinit.bean.Car;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyInitTest {

	private static ConfigurableApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica7/lazy-init-application-context.xml");
	}

	@AfterClass
	public static void afterClass() {
		// Apagar ApplicationContext
		applicationContext.close();
	}

	@Test
	public void lazyInitTest() {

		log.info("lazyInitTest -------------------");

		// Implementar
		Car car = applicationContext.getBean(Car.class);

		Assert.assertNotNull(car);

		log.info("car: {}", car);
	}

}
