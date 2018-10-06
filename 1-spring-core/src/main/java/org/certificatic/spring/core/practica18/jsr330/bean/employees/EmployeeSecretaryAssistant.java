package org.certificatic.spring.core.practica18.jsr330.bean.employees;

import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.SecretaryAssistantQualifier;

@Named
@SecretaryAssistantQualifier
public class EmployeeSecretaryAssistant extends Employee {

	public EmployeeSecretaryAssistant() {
		this.name = "Alejandra Moras";
		this.dni = "AA-BB-CC-DD";
	}
}
