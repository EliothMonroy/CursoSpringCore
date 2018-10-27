package org.certificatic.spring.tx.practica26.test.springtx.parte1;

import org.certificatic.spring.tx.pratica26.springtx.domain.BusinessObject;
import org.certificatic.spring.tx.pratica26.springtx.service.api.ITransactionalService;
import org.certificatic.spring.tx.util.Color;
import org.certificatic.spring.tx.util.bean.api.IColorWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/practica26/spring-tx-application-context.xml")
public class DeclarativeXMLTransactionManagerTest {

	@Autowired
	private ITransactionalService transactionalService;

	@Autowired
	private IColorWriter colorWriter;

	@Before
	public void setUp() {
		Assert.assertNotNull(transactionalService);
	}

	@Test
	public void declarativeXMLTransactionManagerTest() {
		log.info("declarativeXMLTransactionManagerTest -------------------");

		log.info("calling: transactionalService.getBusinessObject(5L)");
		BusinessObject bo = null;
		try {
			bo = transactionalService.getBusinessObject(5L);
		} catch (Exception ex) {

			log.info("{}", colorWriter.getColoredMessage(Color.RED,
					"transactionalService.getBusinessObject(5L) throws Exception " +
							ex.getMessage()));
		}
		log.info("getBusinessObject(5L): {}", bo);
	}

	@Test
	public void declarativeXMLTransactionManagerTest2() {
		log.info("declarativeXMLTransactionManagerTest2 -------------------");

		log.info("calling: transactionalService.insertBusinessObject(null)");
		try {
			transactionalService.insertBusinessObject(null);
		} catch (Exception ex) {

			log.info("{}", colorWriter.getColoredMessage(Color.RED,
					"transactionalService.insertBusinessObject(null) throws Exception " +
							ex.getMessage()));
		}
	}

	@Test
	public void declarativeXMLTransactionManagerTest3() {
		log.info("declarativeXMLTransactionManagerTest3 -------------------");

		log.info("calling: transactionalService.updateBusinessObject(bo)");

		BusinessObject bo = BusinessObject.builder().build();

		try {
			transactionalService.updateBusinessObject(bo);
		} catch (Exception ex) {

			log.info("{}", colorWriter.getColoredMessage(Color.RED,
					"transactionalService.updateBusinessObject(bo) throws Exception " +
							ex.getMessage()));
		}
	}

	@Test
	public void declarativeXMLTransactionManagerTest4() {
		log.info("declarativeXMLTransactionManagerTest4 -------------------");

		log.info("calling: transactionalService.deleteBusinessObject(5L)");
		try {
			transactionalService.deleteBusinessObject(5L);
		} catch (Exception ex) {

			log.info("{}", colorWriter.getColoredMessage(Color.RED,
					"transactionalService.deleteBusinessObject(5L) throws Exception " +
							ex.getMessage()));

		}

	}
}
