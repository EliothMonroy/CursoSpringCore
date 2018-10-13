package org.certificatic.spring.aop.practica23.aspectjconfig.bean.api.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.certificatic.spring.aop.practica23.aspectjconfig.bean.api.IAdivinador;
import org.certificatic.spring.aop.util.Color;
import org.certificatic.spring.aop.util.bean.api.IColorWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define Bean
@Component
// Define Bean como Aspecto
@Aspect
public class Mago implements IAdivinador {

	// Inyecta Dependencia
	@Autowired
	private IColorWriter colorWriter;

	// Define pointcut que intercepte metodo IVoluntario.pensarxxx y que cache
	// el argumento
	@Pointcut("execution(void org.certificatic..IVoluntario.pensar*(String) ) && args(pensamiento) ")
	private void cuandoUnVoluntarioPiensaEnAlgo(String pensamiento) {
	}

	// Define pointcut que intercepte metodo IVoluntario.getPxxx y que cache el
	// argumento
	@Pointcut("execution(String org.certificatic..IVoluntario.getP*(boolean) ) && args(hacerTrampa) ")
	private void cuandoUnVoluntarioQuiereHAcerTrampa(boolean hacerTrampa) {
	}

	@Override
	// Define advice Before para interceptar el pensamiento "antes de que el
	// voluntario piense en algo"
	@Before("cuandoUnVoluntarioPiensaEnAlgo(pensamiento)")
	public void interceptarPensamiento(JoinPoint jp, String pensamiento) {
		print(colorWriter.getColoredMessage(Color.YELLOW,
				"[Mago] El voluntario se prepara para pensar en algo... [Pensará en: "
						+ pensamiento + "]"));
	}

	// Define advice Around para envolver la llamada al método getPensamiento.
	// El método evalua si el voluntairo haré trampa o no.
	@Around("cuandoUnVoluntarioQuiereHAcerTrampa(hacerTrampa)")
	public Object hacerMagia(ProceedingJoinPoint pjp, boolean hacerTrampa)
			throws Throwable {

		if (hacerTrampa)
			return "No me he bañado en 5 dias";

		Object o = pjp.proceed();
		return o;
	}

	private void print(String mensaje) {
		log.info("{}", mensaje);
	}

}
