package org.certificatic.spring.core.practica20.test.resources;

import org.certificatic.spring.core.practica20.resources.bean.BeanResourceLoaderAware;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementar run with spring-test
// cargar context configuration
public class ResourceLoaderAwareTest {

	public static final String location = "classpath:/spring/practica20/resources-application-context.xml";

	// Inyectar
	private BeanResourceLoaderAware beanResourceLoaderAware;

	@Test
	public void loadTextFileResourceLoaderAwareTest() {

		log.info("loadTextFileResourceLoaderAwareTest -------------------");

		// loadTextFile
	}

	@Test
	public void loadPropertiesResourceLoaderAwareTest() {

		log.info("loadPropertiesResourceLoaderAwareTest -------------------");

		// loadPropertiesFile
	}

	@Test
	public void loadUrlFileResourceLoaderAwareTest() {

		log.info("loadUrlFileResourceLoaderAwareTest -------------------");

		// loadURLFile
	}

	@Test
	public void loadAndCopyImageResourceLoaderAwareTest() {

		log.info("loadAndCopyImageResourceLoaderAwareTest -------------------");

		// loadAndCopyImage
	}
}
