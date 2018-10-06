package org.certificatic.spring.core.practica20.test.resources;

import org.certificatic.spring.core.practica20.resources.bean.BeanResourceLoaderAware;
import org.certificatic.spring.core.practica20.test.resources.utils.ResourcesTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.ResourceEditorRegistrar;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementar run with spring-test
@RunWith(SpringJUnit4ClassRunner.class)
// cargar context configuration
@ContextConfiguration(ResourceLoaderAwareTest.location)
public class ResourceLoaderAwareTest {

	public static final String location = "classpath:/spring/practica20/resources-application-context.xml";

	// Inyectar
	@Autowired
	private BeanResourceLoaderAware beanResourceLoaderAware;

	@Test
	public void loadTextFileResourceLoaderAwareTest() {

		log.info("loadTextFileResourceLoaderAwareTest -------------------");
		
		String path="file:/Users/eliothmonroy/Documents/Github/CursoSpringCore/my-text-file.txt";

		// loadTextFile
		ResourcesTestUtils.loadTextFile(beanResourceLoaderAware.getResourceLoader().getResource(path));
	}

	@Test
	public void loadPropertiesResourceLoaderAwareTest() {

		log.info("loadPropertiesResourceLoaderAwareTest -------------------");

		String path="classpath:/spring/practica20/my-properties.properties";
		// loadPropertiesFile
		ResourcesTestUtils.loadPropertiesFile(beanResourceLoaderAware.getResourceLoader().getResource(path));
	}

	@Test
	public void loadUrlFileResourceLoaderAwareTest() {

		log.info("loadUrlFileResourceLoaderAwareTest -------------------");

		String path="https://spring.io";
		// loadURLFile
		ResourcesTestUtils.loadURLFile(beanResourceLoaderAware.getResourceLoader().getResource(path));
		
	}

	@Test
	public void loadAndCopyImageResourceLoaderAwareTest() {

		log.info("loadAndCopyImageResourceLoaderAwareTest -------------------");
		
		String path="classpath:/spring/practica20/logo.png";

		// loadAndCopyImage
		ResourcesTestUtils.loadAndCopyImage(beanResourceLoaderAware.getResourceLoader().getResource(path), "src/main/resources/spring/practica20/copy-resource-loader-aware/");
	}
}
