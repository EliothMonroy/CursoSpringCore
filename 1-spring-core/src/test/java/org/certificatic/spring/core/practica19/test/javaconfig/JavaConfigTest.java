package org.certificatic.spring.core.practica19.test.javaconfig;

import org.apache.commons.math3.complex.Complex;
import org.certificatic.spring.core.practica19.javaconfig.bean.DummyRepository;
import org.certificatic.spring.core.practica19.javaconfig.bean.DummyService;
import org.certificatic.spring.core.practica19.javaconfig.bean.QuadraticEquation;
import org.certificatic.spring.core.practica19.javaconfig.bean.QuadraticEquation.QuadraticEquationValue;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.IQuadraticEquationService;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.QuadraticEquationResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Implementar run with spring-test
// cargar context configuration
public class JavaConfigTest {

	// Inyectar todas las dependencias

	private ApplicationContext applicationContext;

	private IQuadraticEquationService quadraticService;

	private IQuadraticEquationService quadraticService2;

	private IQuadraticEquationService quadraticService2x;

	private IQuadraticEquationService quadraticService2xx;

	private IQuadraticEquationService quadraticService3;

	private QuadraticEquation quadraticEquation;

	private DummyService dummyService;

	private DummyService dummyServiceBean;

	private DummyRepository dummyRepository;

	@Before
	public void beforeClass() {
		Assert.assertNotNull(applicationContext);
	}

	@Test
	public void quadraticEquationService() {

		log.info("quadraticEquationService -------------------");

		Assert.assertNotNull(quadraticService);

		double a = 3;
		double b = 2;
		double c = -9;

		QuadraticEquationResult quadraticEquationResultExpected = QuadraticEquationResult
				.builder().x1(new Complex(1.4305)).x2(new Complex(-2.0972))
				.build();

		String equation = quadraticService.quadraticEquationToString(a, b, c);

		QuadraticEquationResult quadraticEquationResult = quadraticService
				.solve(a, b, c);

		Assert.assertNotNull(quadraticEquationResult);

		Assert.assertEquals(quadraticEquationResultExpected,
				quadraticEquationResult);

		log.info("[{}] solved => {}", equation, quadraticEquationResult);
	}

	@Test
	public void quadraticEquationServiceImaginaryNumber() {

		log.info("quadraticEquationServiceImaginaryNumber -------------------");

		Assert.assertNotNull(quadraticService);

		double a = 6;
		double b = 9;
		double c = 10;

		QuadraticEquationResult quadraticEquationResultExpected = QuadraticEquationResult
				.builder().x1(new Complex(-0.75, 1.0508))
				.x2(new Complex(-0.75, -1.0508)).build();

		String equation = quadraticService.quadraticEquationToString(a, b, c);

		QuadraticEquationResult quadraticEquationResult = quadraticService
				.solve(a, b, c);

		Assert.assertNotNull(quadraticEquationResult);

		Assert.assertEquals(quadraticEquationResultExpected,
				quadraticEquationResult);

		log.info("[{}] solved => {}", equation, quadraticEquationResult);
	}

	@Test
	public void getBeanJavaConfigTest() {

		log.info("getBeanJavaConfigTest -------------------");

		IQuadraticEquationService otherQuadraticService = applicationContext
				.getBean("quadraticService", IQuadraticEquationService.class);

		Assert.assertEquals(quadraticService, otherQuadraticService);
		Assert.assertSame(quadraticService, otherQuadraticService);
	}

	@Test
	public void getBeanByQualifierJavaConfigTest() {

		log.info("getBeanByQualifierJavaConfigTest -------------------");

		Assert.assertEquals(quadraticService2, quadraticService2x);
		Assert.assertEquals(quadraticService2, quadraticService2xx);
		Assert.assertEquals(quadraticService2x, quadraticService2xx);

		Assert.assertSame(quadraticService2, quadraticService2x);
		Assert.assertSame(quadraticService2, quadraticService2xx);
		Assert.assertSame(quadraticService2x, quadraticService2xx);

	}

	@Test
	public void getBeanByQualifierJavaConfigTest2() {

		log.info("getBeanByQualifierJavaConfigTest2 -------------------");

		IQuadraticEquationService otherQuadraticService = applicationContext
				.getBean("quadraticService2", IQuadraticEquationService.class);

		Assert.assertEquals(otherQuadraticService, quadraticService2);
		Assert.assertEquals(otherQuadraticService, quadraticService2x);
		Assert.assertEquals(otherQuadraticService, quadraticService2xx);
		Assert.assertEquals(otherQuadraticService, quadraticService2xx);

		Assert.assertSame(otherQuadraticService, quadraticService2);
		Assert.assertSame(otherQuadraticService, quadraticService2x);
		Assert.assertSame(otherQuadraticService, quadraticService2xx);
		Assert.assertSame(otherQuadraticService, quadraticService2xx);

	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void getBeanByQualifierJavaConfigTest3() {

		log.info("getBeanByQualifierJavaConfigTest3 -------------------");

		IQuadraticEquationService otherQuadraticService = applicationContext
				.getBean("quadraticEquationServiceBean",
						IQuadraticEquationService.class);

		Assert.assertEquals(otherQuadraticService, quadraticService2);
		Assert.assertEquals(otherQuadraticService, quadraticService2x);
		Assert.assertEquals(otherQuadraticService, quadraticService2xx);
		Assert.assertEquals(otherQuadraticService, quadraticService2xx);

		Assert.assertSame(otherQuadraticService, quadraticService2);
		Assert.assertSame(otherQuadraticService, quadraticService2x);
		Assert.assertSame(otherQuadraticService, quadraticService2xx);
		Assert.assertSame(otherQuadraticService, quadraticService2xx);

		Assert.fail("This thes must have fail now.");

	}

	@Test
	public void getBeanByQualifierPrototypeJavaConfigTest() {

		log.info(
				"getBeanByQualifierPrototypeJavaConfigTest -------------------");

		IQuadraticEquationService otherQuadraticService = applicationContext
				.getBean("quadraticService3", IQuadraticEquationService.class);

		Assert.assertNotEquals(otherQuadraticService, quadraticService3);
		Assert.assertNotSame(otherQuadraticService, quadraticService3);

	}

	@Test
	public void componentScanPrototypeJavaConfigTest() {

		log.info("componentScanPrototypeJavaConfigTest -------------------");

		QuadraticEquation otherQuadraticEquation = applicationContext
				.getBean(QuadraticEquation.class);

		Assert.assertNotEquals(otherQuadraticEquation, quadraticEquation);
		Assert.assertNotSame(otherQuadraticEquation, quadraticEquation);

		double a = 10;
		double b = 5;
		double c = -3;

		otherQuadraticEquation.setValue(a, QuadraticEquationValue.Ax2);
		otherQuadraticEquation.setValue(b, QuadraticEquationValue.Bx);
		otherQuadraticEquation.setValue(c, QuadraticEquationValue.C);

		quadraticEquation.setValue(a, QuadraticEquationValue.Ax2);
		quadraticEquation.setValue(b, QuadraticEquationValue.Bx);
		quadraticEquation.setValue(c, QuadraticEquationValue.C);

		Assert.assertEquals(otherQuadraticEquation.solve(),
				quadraticEquation.solve());

	}

	@Test
	public void importAndImportResourceJavaConfigTest() {

		log.info("importAndImportResourceJavaConfigTest -------------------");

		Assert.assertNotNull(dummyService);
		Assert.assertNotNull(dummyServiceBean);
		Assert.assertNotNull(dummyRepository);

		Assert.assertNotSame(dummyService, dummyServiceBean);

		dummyService.executeService();

		Assert.assertEquals("my data", dummyRepository.getData());

	}

}
