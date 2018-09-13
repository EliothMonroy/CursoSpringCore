package org.certificatic.spring.aop.practica23.aspectjconfig.bean.api;

import org.aspectj.lang.JoinPoint;

public interface IAdivinador {
	void interceptarPensamiento(JoinPoint jp, String pensamiento);
}
