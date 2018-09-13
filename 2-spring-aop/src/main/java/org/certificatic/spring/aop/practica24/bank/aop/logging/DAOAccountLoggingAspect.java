package org.certificatic.spring.aop.practica24.bank.aop.logging;

import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

// Define el Bean como Aspecto
@Component("daoAccountLoggingAspect")
@Slf4j
public class DAOAccountLoggingAspect implements Ordered {

	private @Getter int order = 3;

	@Autowired
	private IColorWriter colorWriter;

	// Define Pointcut que intercepte dataAccesLayer() y cache los argumentos
	public void beforeDAOAccountMethodExecutionAccountPointcut(Account xx) {
	}

	// Define Advice Before
	public void beforeDAOAccountMethodExecutionAccount(Account yy) {

		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format("Logging DAO Account access. Account: %s",
								yy.getAccountNumber())));
	}

	// Define Pointcut que intercepte dataAccesLayer() y cache los argumentos
	public void beforeDAOAccountMethodExecutionLongPointcut(Long aa) {
	}

	// Define Advice Before
	public void beforeDAOAccountMethodExecutionLong(Long bb) {

		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format(
								"Logging DAO Account access. Customer Id: %s",
								bb)));
	}

}
