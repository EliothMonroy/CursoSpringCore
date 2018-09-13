package org.certificatic.spring.tx.test.programatictx;

import org.certificatic.spring.tx.pratica26.springtx.domain.BusinessObject;
import org.certificatic.spring.tx.programatictx.service.api.IProgramaticTransactionalService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/programatictx/programatic-spring-tx-application-context.xml")
public class ProgramaticPlatformTransactionManagerTest {

	@Autowired
	@Qualifier("platformTransactionManagerService")
	private IProgramaticTransactionalService programaticTransactionalService;

	@Before
	public void setUp() {
		Assert.assertNotNull(programaticTransactionalService);
	}

	@Test
	public void programaticPlatformTransactionManagerTestWithReturningObject() {
		log.info("programaticPlatformTransactionManagerTestWithReturningObject -------------------");

		log.info("calling: programaticTransactionalService.returningObjectProgramaticTransactionalMethod(5L)");
		BusinessObject bo = null;
		try {
			bo = programaticTransactionalService.returningObjectProgramaticTransactionalMethod(5L);
		} catch (Exception ex) {
			log.info(
					"programaticTransactionalService.returningObjectProgramaticTransactionalMethod(5L) throws Exception {}",
					ex.getMessage());
		}
		log.info("returningObjectProgramaticTransactionalMethod(5L): {}", bo);

		log.info("\n----------------------------------------------");

		log.info("calling: programaticTransactionalService.returningObjectProgramaticTransactionalMethod(6L)");
		bo = null;
		try {
			bo = programaticTransactionalService.returningObjectProgramaticTransactionalMethod(6L);
		} catch (Exception ex) {
			log.info(
					"programaticTransactionalService.returningObjectProgramaticTransactionalMethod(6L) throws Exception {}",
					ex.getMessage());
		}
		log.info("returningObjectProgramaticTransactionalMethod(6L): {}", bo);

		log.info("\n----------------------------------------------");
	}

	@Test
	public void programaticPlatformTransactionManagerTestWithoutReturningObject() {
		log.info("programaticPlatformTransactionManagerTestWithoutReturningObject -------------------");

		log.info("calling: programaticTransactionalService.withoutReturningObjectProgramaticTransactionalMethod(bo)");
		BusinessObject bo = BusinessObject.builder().id(5L).data(5 + " is odd").build();
		try {
			programaticTransactionalService.withoutReturningObjectProgramaticTransactionalMethod(bo);
		} catch (Exception ex) {
			log.info(
					"programaticTransactionalService.withoutReturningObjectProgramaticTransactionalMethod(bo) throws Exception {}",
					ex.getMessage());
		}

		log.info("\n----------------------------------------------");

		log.info("calling: programaticTransactionalService.withoutReturningObjectProgramaticTransactionalMethod(bo)");
		bo = BusinessObject.builder().id(6L).data(6 + " is even").build();
		try {
			programaticTransactionalService.withoutReturningObjectProgramaticTransactionalMethod(bo);
		} catch (Exception ex) {
			log.info(
					"programaticTransactionalService.withoutReturningObjectProgramaticTransactionalMethod(bo) throws Exception {}",
					ex.getMessage());
		}

		log.info("\n----------------------------------------------");
	}
}
