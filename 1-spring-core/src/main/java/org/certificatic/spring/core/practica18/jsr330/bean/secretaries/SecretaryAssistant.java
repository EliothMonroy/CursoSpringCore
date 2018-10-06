package org.certificatic.spring.core.practica18.jsr330.bean.secretaries;

import javax.inject.Inject;
import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Secretary;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.SecretaryAssistantEmployeeQualifier;

@Named
@SecretaryAssistantEmployeeQualifier
public class SecretaryAssistant extends Secretary {

	@Override
	@Inject
	@SecretaryAssistantEmployeeQualifier
	public void setEmployee(Employee employee) {
		super.setEmployee(employee);
	}

}
