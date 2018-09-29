package org.certificatic.spring.core.practica16.test.jsr250;

import org.certificatic.spring.core.practica16.jsr250.bean.Student;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Jsr250AnnotationTest {

	private static ConfigurableApplicationContext ctx;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext(
				"spring/practica16/annotations-jsr250-application-context.xml");
	}

	@Test
	public void jsr250AnnotationTest() {

		log.info("jsr250AnnotationTest -------------------");

		// Implementar
		Student student = ctx.getBean(Student.class);

		Assert.assertNotNull(student);
		Assert.assertNotNull(student.getName());
		Assert.assertNotNull(student.getEnrollment());
		Assert.assertNotNull(student.getSubject());

		log.info("student: {}", student);

		ctx.close();
	}

}
