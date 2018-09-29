package org.certificatic.spring.core.practica17.stereotypes.api.repositories.impl;

import javax.annotation.Resource;

import org.certificatic.spring.core.practica17.stereotypes.api.IRepositoryClass;
import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.Getter;

@Data
// Anotar repositorio, implementar Interface IRepositoryClass
@Repository
public class RepositoryClassImpl1 implements IRepositoryClass{
	@Resource(name="repositoryClassName")
	private @Getter String name;
	// Inyectar con "resource" bean repositoryClassName
	@Override
	public String getRepositoryClassName() {
		// TODO Auto-generated method stub
		return name;
	}

	
}
