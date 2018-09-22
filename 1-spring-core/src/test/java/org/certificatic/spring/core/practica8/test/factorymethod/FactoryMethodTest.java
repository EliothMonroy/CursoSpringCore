package org.certificatic.spring.core.practica8.test.factorymethod;

import org.certificatic.spring.core.practica8.factorymethod.bean.Student;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryMethodTest {

	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		applicationContext=new ClassPathXmlApplicationContext(
				"spring/practica8/factory-method-application-context.xml");
	}
	
	@AfterClass
	public static void afterClass() {
		// Cerrar ApplicationContext
		((ConfigurableApplicationContext)applicationContext).close();
	}

	@Test
	public void factoryMethodTest() {

		log.info("factoryMethodTest -------------------");

		// Implementar
		Student uno=applicationContext.getBean("student1",Student.class);
		Assert.assertNotNull(uno);
		log.info("Student: {}",uno);
	}

	@Test
	public void factoryMethodTest2() {

		log.info("factoryMethodTest2 -------------------");

		// Implementar
		Student dos=applicationContext.getBean("student2",Student.class);
	}

}
