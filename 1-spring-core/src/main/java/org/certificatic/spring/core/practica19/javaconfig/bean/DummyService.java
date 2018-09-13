package org.certificatic.spring.core.practica19.javaconfig.bean;

public class DummyService {

	private DummyRepository repository;

	public DummyService(DummyRepository dummyRespository) {
		this.repository = dummyRespository;
	}

	public void executeService() {
		System.out.println("executing Service");
		System.out.println("calling repository.getData(): " + repository.getData());
	}
}
