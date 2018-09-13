package org.certificatic.spring.aop.practica22.xmlconfig.bean.api;

public interface IJugador {

	public void ejecutarPase();

	public void cometerFalta();

	public void esExpulsado();

	public void tirarAGol(boolean gol) throws Throwable;

	public void cobrarPenal(boolean gol) throws Throwable;
}
