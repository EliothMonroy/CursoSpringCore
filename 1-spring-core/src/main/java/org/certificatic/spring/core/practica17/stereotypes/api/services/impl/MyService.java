package org.certificatic.spring.core.practica17.stereotypes.api.services.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;

@Data
// Anotar servicio, implementar Interface IService
@Service
@Scope("prototype")
public class MyService implements IService {

	// Inyectar con "resource" bean serviceClassName
	@Resource(name = "serviceClassName")
	private @Getter String name;
}
