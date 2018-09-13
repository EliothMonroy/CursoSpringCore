package org.certificatic.spring.core.practica19.javaconfig;

import org.certificatic.spring.core.practica19.javaconfig.bean.DummyRepository;
import org.certificatic.spring.core.practica19.javaconfig.bean.DummyService;

//Habilitar Clase de configuración
public class ServiceConfig {

	// Define Bean
	public DummyService dummyService(DummyRepository dummyRespository) {
		return new DummyService(dummyRespository);
	}

	// Define Bean
	public DummyService dummyService2(DummyRepository dummyRespository) {
		return new DummyService(dummyRespository);
	}
}
