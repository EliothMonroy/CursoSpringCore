package org.certificatic.spring.core.practica19.javaconfig;

import org.certificatic.spring.core.practica19.javaconfig.bean.api.IQuadraticEquationService;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.impl.QuadraticEquationServiceImpl;

// Habilitar Clase de configuración
// Habilitar component scan
// Agregar Import de clases de configuraciónRepository y Service
public class ApplicationConfig {

	// Definir bean
	public IQuadraticEquationService quadraticService() {
		return new QuadraticEquationServiceImpl();
	}

	// Definir bean
	public IQuadraticEquationService quadraticService2() {
		return new QuadraticEquationServiceImpl();
	}

	// Definir bean
	public IQuadraticEquationService quadraticService3() {
		return new QuadraticEquationServiceImpl();
	}

}
