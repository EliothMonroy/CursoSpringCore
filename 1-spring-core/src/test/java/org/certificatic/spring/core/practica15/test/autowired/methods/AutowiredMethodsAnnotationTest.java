package org.certificatic.spring.core.practica15.test.autowired.methods;

import org.certificatic.spring.core.practica15.autowired.methods.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredMethodsAnnotationTest {

	@Test
	public void autowiredMethodsAnnotationTest() {

		log.info("autowiredMethodsAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-methods-application-context.xml";

		// Implementar
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);

		Student student = ctx.getBean(Student.class);

		Assert.assertNotNull(student);

		Assert.assertNotNull(student.getName());
		Assert.assertNotNull(student.getAge());
		Assert.assertNotNull(student.getStudentBook());
		Assert.assertNotNull(student.getPropellingPencil());

		log.info("student: {}", student);

		ctx.close();
	}

}
