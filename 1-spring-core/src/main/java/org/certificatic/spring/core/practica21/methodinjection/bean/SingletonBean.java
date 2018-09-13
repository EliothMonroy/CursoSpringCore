package org.certificatic.spring.core.practica21.methodinjection.bean;

import org.certificatic.spring.core.practica21.methodinjection.bean.api.IProcessor;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonBean {

	private @Setter Integer iterations;

	// Inyecta un prototype IProcessor en este bean singleton (¿¿¿¿como????)
	private IProcessor processor;

	public String process(String data) {
		log.info("SingletonBean id [{}]: sending to process data ...",
				super.hashCode());

		return processor.processData(data, iterations);
	}

}
// Define la estructura para inyectar métodos en éste bean