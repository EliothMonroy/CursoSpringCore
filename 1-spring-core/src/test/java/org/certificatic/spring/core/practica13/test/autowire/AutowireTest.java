package org.certificatic.spring.core.practica13.test.autowire;

import org.certificatic.spring.core.practica13.autowire.bean.Car;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowireTest {

	@Test
	public void autowireByNameTest() {

		log.info("autowireByNameTest -------------------");

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica13/autowire-byName-application-context.xml");

		Car car = applicationContext.getBean(Car.class);

		Assert.assertNotNull(car);

		log.info("car: {}", car);

		((AbstractApplicationContext) applicationContext).close();
	}

	@Test
	public void autowireByTypeTest() {

		log.info("autowireByTypeTest -------------------");

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica13/autowire-byType-application-context.xml");

		Car car = applicationContext.getBean(Car.class);

		Assert.assertNotNull(car);

		log.info("car: {}", car);

		((AbstractApplicationContext) applicationContext).close();
	}

	@Test
	public void autowireConstructorTest() {

		log.info("autowireConstructorTest -------------------");

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica13/autowire-constructor-application-context.xml");

		Car car = applicationContext.getBean(Car.class);

		Assert.assertNotNull(car);

		log.info("car: {}", car);

		((AbstractApplicationContext) applicationContext).close();
	}

}
