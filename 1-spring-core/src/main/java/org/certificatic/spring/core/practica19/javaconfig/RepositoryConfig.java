package org.certificatic.spring.core.practica19.javaconfig;

import org.certificatic.spring.core.practica19.javaconfig.bean.DummyRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//Habilitar Clase de configuraci�n
@Configuration
//Agregar Import de clases de Recurso xml
@ImportResource(locations=("classpath:/spring/practica19/datasource-application-context.xml"))
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
