package org.certificatic.spring.tx.programatictx.service.api.impl;

import org.certificatic.spring.tx.pratica26.springtx.domain.BusinessObject;
import org.certificatic.spring.tx.programatictx.service.api.IProgramaticTransactionalService;
import org.certificatic.spring.tx.util.Color;
import org.certificatic.spring.tx.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("platformTransactionManagerService")
public class PlatformTransactionManagerService implements IProgramaticTransactionalService {

	@Autowired
	private IColorWriter colorWriter;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Override
	public BusinessObject returningObjectProgramaticTransactionalMethod(Long id) {
		log.info("{}",
				colorWriter.getColoredMessage(Color.BLUE, "inside returningObjectProgramaticTransactionalMethod"));

		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		transactionDefinition.setName("transactionName");
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

		try {

			if (id % 2 == 0)
				throw new RuntimeException("Id cannot be even number");

			log.info("{}", colorWriter.getColoredMessage(Color.BLUE,
					"creating businessObject..."));

			transactionManager.commit(status);

			return BusinessObject.builder().id(id).data(id + " is odd").build();

		} catch (RuntimeException ex) {
			transactionManager.rollback(status);
			throw ex;
		}
	}

	@Override
	public void withoutReturningObjectProgramaticTransactionalMethod(BusinessObject businessObject) {
		log.info("{}", colorWriter.getColoredMessage(Color.BLUE,
				"inside withoutReturningObjectProgramaticTransactionalMethod"));

		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		transactionDefinition.setName("transactionName");
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

		try {

			if (businessObject.getId() % 2 == 0)
				throw new RuntimeException("businessObject.getId() cannot be even number");

			log.info("{}", colorWriter.getColoredMessage(Color.BLUE,
					"processing businessObject..."));

			transactionManager.commit(status);

		} catch (RuntimeException ex) {
			transactionManager.rollback(status);
			throw ex;
		}
	}

}
