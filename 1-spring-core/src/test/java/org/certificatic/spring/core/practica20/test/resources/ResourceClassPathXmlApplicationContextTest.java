package org.certificatic.spring.core.practica20.test.resources;



import org.certificatic.spring.core.practica20.resources.bean.Resources;
import org.certificatic.spring.core.practica20.test.resources.utils.ResourcesTestUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceClassPathXmlApplicationContextTest {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext();

	@AfterClass
	public static void releaseApplicationContext() {
		((AbstractApplicationContext) applicationContext).close();
	}

	@Test
	public void loadTextFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadTextFileClasspathXmlApplicationContextTest -------------------");

		// load resource file:c:/certificatic-resources/my-text-file.txt
		Resource resource=applicationContext.getResource("file:/Users/eliothmonroy/Documents/Github/CursoSpringCore/my-text-file.txt");

		// loadTextFile from resource
		ResourcesTestUtils.loadTextFile(resource);
	}

	@Test
	public void loadPropertiesFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadPropertiesFileClasspathXmlApplicationContextTest -------------------");

		// load resource spring/practica20/my-properties.properties
		//Por default busca en el classpath
		Resource resource=applicationContext.getResource("/spring/practica20/my-properties.properties");

		// loadPropertiesFile from resource
		ResourcesTestUtils.loadPropertiesFile(resource);
	}

	@Test
	public void loadUrlFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadUrlFileClasspathXmlApplicationContextTest -------------------");

		// load resource http://spring.io/
		Resource resource=applicationContext.getResource("https://spring.io");

		// loadURLFile from resource
		ResourcesTestUtils.loadURLFile(resource);
	}

	@Test
	public void loadAndCopyImageFileClasspathXmlApplicationContextTest() {

		log.info(
				"loadAndCopyImageFileClasspathXmlApplicationContextTest -------------------");

		// load resource file:src/main/resources/spring/practica20/logo.png
		Resource resource=applicationContext.getResource("/spring/practica20/logo.png");

		// loadAndCopyImage from resource
		ResourcesTestUtils.loadAndCopyImage(resource, "src/main/resources/spring/practica20/copy-resources/");
	}
}
