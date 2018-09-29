package org.certificatic.spring.core.practica16.test.jsr250;

import org.certificatic.spring.core.practica16.jsr250.bean.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Jsr250AnnotationTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void beforeClass() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica16/annotations-jsr250-application-context.xml");
	}

	@Test
	public void jsr250AnnotationTest() {

		log.info("jsr250AnnotationTest -------------------");

		// Implementar
		Student student=applicationContext.getBean(Student.class);
		Assert.notNull(student);
		Assert.notNull(student.getName());
		Assert.notNull(student.getEnrollment());
		Assert.notNull(student.getSubject());
		log.info("student: {}",student);
		applicationContext.close();
	}

}
