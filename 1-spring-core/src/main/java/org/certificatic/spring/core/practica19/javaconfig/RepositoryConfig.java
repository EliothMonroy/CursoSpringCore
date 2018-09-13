package org.certificatic.spring.core.practica19.javaconfig;

import org.certificatic.spring.core.practica19.javaconfig.bean.DummyRepository;

//Habilitar Clase de configuración
//Agregar Import de clases de Recurso xml
public class RepositoryConfig {

	// Define Bean
	public DummyRepository dummyRepository(String connectionString) {
		return new DummyRepository(connectionString);
	}

	// Define Bean
	public DummyRepository dummyRepository2(String connectionString) {
		return new DummyRepository(connectionString);
	}
}
