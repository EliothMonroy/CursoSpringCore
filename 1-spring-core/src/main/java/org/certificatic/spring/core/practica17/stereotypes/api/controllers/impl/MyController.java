package org.certificatic.spring.core.practica17.stereotypes.api.controllers.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IController;
import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
// Anotar controlador, implementar Interface IController
@Controller
public class MyController implements IController {

	// Inyectar con "resource" bean controllerClassName
	@Resource(name = "controllerClassName")
	private String name;
}
