package org.certificatic.spring.core.practica19.javaconfig.bean;

public class DummyRepository {

	private String connectionString;

	public DummyRepository(String connectionString) {
		this.connectionString = connectionString;
	}

	public String getData() {
		System.out.println("repository: connectiong to: " + connectionString);
		return "my data";
	}

}
