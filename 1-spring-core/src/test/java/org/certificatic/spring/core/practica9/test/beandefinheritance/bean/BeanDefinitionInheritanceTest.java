package org.certificatic.spring.core.practica9.test.beandefinheritance.bean;

import org.certificatic.spring.core.practica9.beandefinitioninheritance.bean.ConnectionDataBase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanDefinitionInheritanceTest {
	
	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		// Instanciar ApplicationContext
		applicationContext=new ClassPathXmlApplicationContext(
				"spring/practica9/bean-def-inheritance-application-context.xml");
	}
	@AfterClass
	public static void afterClass() {
		// Cerrar ApplicationContext
		((ConfigurableApplicationContext)applicationContext).close();
	}

	@Test
	public void beanDefinitionInheritanceTest1() {

		log.info("beanDefinitionInheritanceTest1 -------------------");

		// Implementar
		ConnectionDataBase connectionP=applicationContext.getBean("connectionProdBean",ConnectionDataBase.class);
		Assert.assertNotNull(connectionP);
		log.info("Conexión: {}",connectionP);
		connectionP.showInfo();
	}

	@Test
	public void beanDefinitionInheritanceTest2() {

		log.info("beanDefinitionInheritanceTest2 -------------------");

		// Implementar
		ConnectionDataBase connection=applicationContext.getBean("connectionTestBean",ConnectionDataBase.class);
		Assert.assertNotNull(connection);
		log.info("Conexión: {}",connection);
		connection.showInfo();
	}

}
