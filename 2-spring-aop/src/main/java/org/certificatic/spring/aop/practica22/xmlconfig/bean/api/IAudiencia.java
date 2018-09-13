package org.certificatic.spring.aop.practica22.xmlconfig.bean.api;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IAudiencia {

	public void aplaudir();

	public void abuchear();

	public void sePoneDePie();

	public void seSienta();

	public void gritaGol();

	public void gritaOle();

	public Object sePoneDeNervios(ProceedingJoinPoint pjp) throws Throwable;
}