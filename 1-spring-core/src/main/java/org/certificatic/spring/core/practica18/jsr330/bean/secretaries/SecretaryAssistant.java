package org.certificatic.spring.core.practica18.jsr330.bean.secretaries;

import javax.inject.Inject;
import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Secretary;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.SecretaryAssistantQualifier;

@Named
@SecretaryAssistantQualifier
public class SecretaryAssistant extends Secretary {

	@Override
	@Inject
	@SecretaryAssistantQualifier
	public void setEmployee(Employee employee) {
		super.setEmployee(employee);
	}

	// Luis Medina
	// luis.medina@certificatic.org
	// 55 39 22 26 32
}