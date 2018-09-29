package org.certificatic.spring.core.practica17.stereotypes.api.components.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IComponent;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
// Anotar componente, implementar Interface IComponent
@Component
public class MyComponent implements IComponent {

	// Inyectar con "resource" bean componentClassName
	@Resource(name = "componentClassName")
	private String name;
}
