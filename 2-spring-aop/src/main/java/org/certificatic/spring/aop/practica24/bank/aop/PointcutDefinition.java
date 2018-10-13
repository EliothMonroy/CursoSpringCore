package org.certificatic.spring.aop.practica24.bank.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// Define Aspecto
@Aspect
public class PointcutDefinition {

	// Define poitcut que intercepte cualquier ejecucion de cualquier clase en
	// el paquete bank.web
	@Pointcut("within(org.certificatic.spring.aop.practica24.bank.web..*)")
	public void webLayer() {
	}

	// Define poitcut que intercepte cualquier ejecucion de cualquier clase en
	// el paquete bank.service
	@Pointcut("within(org.certificatic.spring.aop.practica24.bank.service..*)")
	public void serviceLayer() {
	}

	// Define poitcut que intercepte cualquier ejecucion de cualquier clase en
	// el paquete bank.dao
	@Pointcut("within(org.certificatic.spring.aop.practica24.bank.dao..*)")
	public void dataAccessLayer() {
	}
}
