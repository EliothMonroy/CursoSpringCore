package org.certificatic.spring.core.practica17.test.stereotypes;

import org.certificatic.spring.core.practica17.stereotypes.api.IComponent;
import org.certificatic.spring.core.practica17.stereotypes.api.IController;
import org.certificatic.spring.core.practica17.stereotypes.api.IRepository;
import org.certificatic.spring.core.practica17.stereotypes.api.IRestController;
import org.certificatic.spring.core.practica17.stereotypes.api.IService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
// cargar context configuration
@ContextConfiguration(locations = {
		"classpath:/spring/practica17/component-scan-stereotypes-application-context.xml" })
public class StereotypesBetterTest {

	// Inyectar todas las dependencias
	@Autowired
	private IRestController restController;

	@Autowired
	private IRestController restController2;

	@Autowired
	private IService service;

	@Autowired
	private IService service2;

	@Autowired
	private IController controller;

	@Autowired
	private IComponent component;

	@Autowired
	private IRepository repository;

	@Before
	public void beforeClass() {
		Assert.assertNotNull(restController);
		Assert.assertNotNull(component);
		Assert.assertNotNull(service);
		Assert.assertNotNull(controller);
		Assert.assertNotNull(repository);

		Assert.assertSame(restController, restController2);
		Assert.assertNotSame(service, service2);
	}

	@Test
	public void restControllerTest() {

		log.info("restControllerTest -------------------");

		String name = "My REST Controller Implementation";

		Assert.assertNotNull(restController);
		Assert.assertEquals(name, restController.getName());

		log.info("restController: {}", restController);
	}

	@Test
	public void controllerTest() {

		log.info("controllerTest -------------------");

		String name = "My Controller Implementation";

		Assert.assertNotNull(controller);
		Assert.assertEquals(name, controller.getName());

		log.info("controller: {}", controller);
	}

	@Test
	public void componentTest() {

		log.info("componentTest -------------------");

		String name = "My Component Implementation";

		Assert.assertNotNull(component);
		Assert.assertEquals(name, component.getName());

		log.info("component: {}", component);
	}

	@Test
	public void serviceTest() {

		log.info("serviceTest -------------------");

		String name = "My Service Implementation";

		Assert.assertNotNull(service);
		Assert.assertEquals(name, service.getName());

		log.info("service: {}", service);
	}

	@Test
	public void repositoryTest() {

		log.info("repositoryTest -------------------");

		String name = "My Repository Implementation";

		Assert.assertNotNull(repository);
		Assert.assertEquals(name, repository.getName());

		log.info("repository: {}", repository);
	}

}
