package org.certificatic.spring.aop.practica24.bank.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.certificatic.spring.aop.practica24.bank.app.model.Account;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

// Define el Bean como Aspecto
@Aspect
@Component("daoAccountLoggingAspect")
@Slf4j
public class DAOAccountLoggingAspect implements Ordered {

	private @Getter int order = 3;

	@Autowired
	private IColorWriter colorWriter;

	// Define Pointcut que intercepte dataAccesLayer() y cache los argumentos
	@Pointcut("org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.dataAccessLayer() && args(xx, ..)")
	public void beforeDAOAccountMethodExecutionAccountPointcut(Account xx) {
	}

	// Define Advice Before
	@Before("beforeDAOAccountMethodExecutionAccountPointcut(yy)")
	public void beforeDAOAccountMethodExecutionAccount(JoinPoint jp,Account yy) {

		String clase=jp.getTarget().getClass().getSimpleName();
		String metodo=jp.getSignature().getName();
		
		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format("In %s.%s, Logging DAO Account access. Account: %s",
								clase,metodo,yy.getAccountNumber())));
	}

	// Define Pointcut que intercepte dataAccesLayer() y cache los argumentos
	@Pointcut("org.certificatic.spring.aop.practica24.bank.aop.PointcutDefinition.dataAccessLayer() && args(aa,..)")
	public void beforeDAOAccountMethodExecutionLongPointcut(Long aa) {
	}

	// Define Advice Before
	@Before("beforeDAOAccountMethodExecutionLongPointcut(bb)")
	public void beforeDAOAccountMethodExecutionLong(JoinPoint jp,Long bb) {
		
		String clase=jp.getTarget().getClass().getSimpleName();
		String metodo=jp.getSignature().getName();

		log.info("{}",
				colorWriter.getColoredMessage(Color.RED,
						String.format(
								"Logging DAO Account access. Customer Id: %s",
								bb)));
	}

}
