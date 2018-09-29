package org.certificatic.spring.core.practica17.stereotypes.api.components.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IComponentClass;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;

@Data
// Anotar componente, implementar Interface IComponentClass
@Component
public class ComponentClassImpl1 implements IComponentClass{
	@Resource(name="componentClassName")
	private @Getter String name;
	@Override
	public String getComponentClassName() {
		return name;
	}
	
	// Inyectar con "resource" bean componentClassName
}
