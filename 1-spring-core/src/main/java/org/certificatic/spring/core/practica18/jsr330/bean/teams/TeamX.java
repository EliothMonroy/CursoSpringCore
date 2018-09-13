package org.certificatic.spring.core.practica18.jsr330.bean.teams;

import java.util.List;

import org.certificatic.spring.core.practica18.jsr330.bean.Employee;
import org.certificatic.spring.core.practica18.jsr330.bean.Team;

public class TeamX extends Team {

	@Override
	public void setEmployees(List<String> employees) {
		super.setEmployees(employees);
	}

	@Override
	public void setArchitect(Employee architect) {
		super.setArchitect(architect);
	}

	@Override
	public void setProgrammer(Employee programmer) {
		super.setProgrammer(programmer);
	}

	@Override
	public void setTester(Employee tester) {
		super.setTester(tester);
	}

}
