package org.certificatic.spring.core.practica15.test.autowired.methods;


import org.certificatic.spring.core.practica15.autowired.methods.bean.Student;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredMethodsAnnotationTest {

	@Test
	public void autowiredMethodsAnnotationTest() {

		log.info("autowiredMethodsAnnotationTest -------------------");

		String ctxFile = "spring/practica15/annotations-autowired-methods-application-context.xml";

		// Implementar
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext(ctxFile);
		Student student=ctx.getBean(Student.class);
		Assert.notNull(student);
		Assert.notNull(student.getName());
		Assert.notNull(student.getAge());
		Assert.notNull(student.getPropellingPencil());
		Assert.notNull(student.getStudentBook());
		log.info("student: {}",student);
		ctx.close();
	}

}
