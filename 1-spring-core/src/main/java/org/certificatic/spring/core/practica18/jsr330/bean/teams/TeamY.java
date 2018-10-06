package org.certificatic.spring.core.practica18.jsr330.bean.teams;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Team;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.EmployeeQualifier;
import org.certificatic.spring.core.practica18.jsr330.qualifiers.EmployeeQualifier.EmployeeType;

@Named("team2")
public class TeamY extends Team {

	@Override
	@Resource(name="teamYListStringBean")
	public void setEmployees(List<String> employees) {
		super.setEmployees(employees);
	}

	@Override
	@Inject
	@EmployeeQualifier(employeeType=EmployeeType.ARCHITECT)
	public void setArchitect(Employee architect) {
		super.setArchitect(architect);
	}

	@Override
	@Inject
	@EmployeeQualifier(employeeType=EmployeeType.PROGRAMMER)
	public void setProgrammer(Employee programmer) {
		super.setProgrammer(programmer);
	}

	@Override
	@Inject
	@EmployeeQualifier(employeeType=EmployeeType.TESTER)
	public void setTester(Employee tester) {
		super.setTester(tester);
	}

}
