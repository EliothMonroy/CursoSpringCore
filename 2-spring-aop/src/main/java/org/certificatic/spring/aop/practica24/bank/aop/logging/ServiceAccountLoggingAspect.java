package org.certificatic.spring.aop.practica24.bank.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

//Define el Bean como Aspecto
@Aspect
@Component("serviceAccountLoggingAspect")
@Slf4j
public class ServiceAccountLoggingAspect implements Ordered {

	private @Getter int order = 2;

	@Autowired
	private IColorWriter colorWriter;

	// Define Advice Before que intercepte serviceLayer() y cache los argumentos
	@Before("org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.serviceLayer() && args(account, ..)")
	public void beforeServiceAccountMethodExecutionAccount(JoinPoint jp, Account account) {

		String clase=jp.getTarget().getClass().getSimpleName();
		String metodo=jp.getSignature().getName();
		
		log.info("{}",
				colorWriter.getColoredMessage(Color.MAGENTA,
						String.format("In %s.%s, Logging Service Account Account access. Account: %s",
								clase,metodo,account.getAccountNumber())));
	}

	// Define Advice Before que intercepte serviceLayer() y cache los argumentos
	@Before("org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.serviceLayer() && args(customerId, ..)")
	public void beforeServiceAccountMethodExecutionLong(JoinPoint jp,Long customerId) {

		String clase=jp.getTarget().getClass().getSimpleName();
		String metodo=jp.getSignature().getName();
		
		log.info("{}",
				colorWriter.getColoredMessage(Color.MAGENTA,
						String.format("In %s.%s, Logging Service Account Account access. customerId: %s",
								clase,metodo,customerId)));

	}
}
