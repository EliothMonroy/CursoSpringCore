package org.certificatic.spring.core.practica20.test.resources;

import org.certificatic.spring.core.practica20.resources.bean.Resources;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementar run with spring-test
// cargar context configuration
public class ResourcesTest {

	public static final String location = "classpath:/spring/practica20/resources-application-context.xml";

	// Inyectar
	private Resources resources;

	@Test
	public void loadTextFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadTextFileClasspathXmlApplicationContextTest -------------------");

		// loadTextFile
	}

	@Test
	public void loadPropertiesFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadPropertiesFileClasspathXmlApplicationContextTest -------------------");

		// loadPropertiesFile
	}

	@Test
	public void loadUrlFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadUrlFileClasspathXmlApplicationContextTest -------------------");

		// loadURLFile
	}

	@Test
	public void loadAndCopyImageFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadAndCopyImageFileClasspathXmlApplicationContextTest -------------------");

		// loadAndCopyImage
	}
}
