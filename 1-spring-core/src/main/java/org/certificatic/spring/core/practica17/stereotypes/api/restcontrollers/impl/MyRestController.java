package org.certificatic.spring.core.practica17.stereotypes.api.restcontrollers.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IRestController;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.Getter;

@Data
// Anotar rest controlador, implementar Interface IRestController
@RestController
public class MyRestController implements IRestController {

	// Inyectar con "resource" bean restControllerClassName
	@Resource(name = "restControllerClassName")
	private @Getter String name;
}
