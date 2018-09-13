package org.certificatic.spring.validation.practica30.parte1.test.validator;

import java.util.Locale;

import org.certificatic.spring.validation.practica30.parte1.domain.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
// Asignar ValidatorTestConfig.class como clase de configuración del contexto
public class PersonValidatorUsTest {

	// Inyectar MessageSource messageSource;

	// Inyectar Validator personValidator;

	private Locale locale = new Locale("en", "US");

	public void setUp() {
		// Assert.assertNotNull(messageSource);
		// Assert.assertNotNull(personValidator);
	}

	@Test
	public void validationPersonUsTest1() {

		log.info("validationPersonUsTest1 -------------------");

		Person person = new Person();
		// persona sin nombre ni edad.

		// Instanciar BindException
		BindException errors = null;

		// Invocar validator

		if (errors.hasErrors()) {

			Assert.assertEquals(2, errors.getErrorCount());

			// PersonValidatorUsTestUtils.printErrors(errors, messageSource,
			// locale);

		}

	}

	@Test
	public void validationPersonUsTest2() {

		log.info("validationPersonUsTest2 -------------------");

		Person person = new Person();
		// persona sin nombre y menor de edad.
		person.setAge(16);

		// Instanciar BindException
		BindException errors = null;

		// Invocar validator

		if (errors.hasErrors()) {

			Assert.assertEquals(2, errors.getErrorCount());

			// PersonValidatorUsTestUtils.printErrors(errors, messageSource,
			// locale);
		}

	}

	@Test
	public void validationPersonUsTest3() {

		log.info("validationPersonUsTest3 -------------------");

		Person person = new Person();
		// persona con nombre y menor de edad.
		person.setName("Ivan");
		person.setAge(16);

		// Instanciar BindException
		BindException errors = null;

		// Invocar validator

		if (errors.hasErrors()) {

			Assert.assertEquals(1, errors.getErrorCount());

			// PersonValidatorUsTestUtils.printErrors(errors, messageSource,
			// locale);
		}

	}

	@Test
	public void validationPersonUsTest4() {

		log.info("validationPersonUsTest4 -------------------");

		Person person = new Person();
		// persona con nombre y mayor de edad.
		person.setName("Ivan");
		person.setAge(20);

		// Instanciar BindException
		BindException errors = null;

		// Invocar validator

		Assert.assertFalse(errors.hasErrors());
	}

}
