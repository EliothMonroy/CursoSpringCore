package org.certificatic.spring.core.practica17.stereotypes.api.controllers.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IControllerClass;
import org.springframework.stereotype.Controller;

import lombok.Data;
import lombok.Getter;

@Data
// Anotar controlador, implementar Interface IControllerClass
@Controller
public class ControllerClassImpl1 implements IControllerClass{
	@Resource(name="controllerClassName")
	private @Getter String name;
	@Override
	public String getControllerClassName() {
		// TODO Auto-generated method stub
		return name;
	}

	// Inyectar con "resource" bean controllerClassName
}
