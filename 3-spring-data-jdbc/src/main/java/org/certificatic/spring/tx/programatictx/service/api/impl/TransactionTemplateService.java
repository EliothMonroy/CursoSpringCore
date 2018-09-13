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
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("transactionTemplateService")
public class TransactionTemplateService implements IProgramaticTransactionalService {

	private TransactionTemplate transactionTemplate;

	@Autowired
	private IColorWriter colorWriter;

	@Autowired
	public void init(PlatformTransactionManager transactionManager) {
		this.transactionTemplate = new TransactionTemplate(transactionManager);

		this.transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		this.transactionTemplate.setTimeout(30);
	}

	@Override
	public BusinessObject returningObjectProgramaticTransactionalMethod(Long id) {
		log.info("{}",
				colorWriter.getColoredMessage(Color.BLUE, "inside returningObjectProgramaticTransactionalMethod"));

		BusinessObject bo = null;

		bo = this.transactionTemplate.execute(new TransactionCallback<BusinessObject>() {

			@Override
			public BusinessObject doInTransaction(TransactionStatus status) {
				try {

					if (id % 2 == 0)
						throw new RuntimeException("Id cannot be even number");

					log.info("{}", colorWriter.getColoredMessage(Color.BLUE,
							"creating businessObject..."));

					return BusinessObject.builder().id(id).data(id + " is odd").build();

				} catch (RuntimeException ex) {
					// status.setRollbackOnly();
					throw ex;
				}
				// return null;
			}
		});

		return bo;
	}

	@Override
	public void withoutReturningObjectProgramaticTransactionalMethod(BusinessObject businessObject) {
		log.info("{}", colorWriter.getColoredMessage(Color.BLUE,
				"inside withoutReturningObjectProgramaticTransactionalMethod"));

		this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try {

					if (businessObject.getId() % 2 == 0)
						throw new RuntimeException("businessObject.getId() cannot be even number");

					log.info("{}", colorWriter.getColoredMessage(Color.BLUE,
							"processing businessObject..."));

				} catch (RuntimeException ex) {
					status.setRollbackOnly();
					// throw ex;
				}
			}
		});
	}

}
