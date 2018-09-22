package org.certificatic.spring.core.practica10.beanpostprocessors.bean;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.api.IWorker;

import lombok.Setter;

public class WorkerProxy implements IWorker {
	
	private @Setter IWorker tarjet;

	@Override
	public String getName() {
		System.out.println("Worker proxy Obteniendo name del tarjet");
		return tarjet.getName();
	}

	@Override
	public void setName(String name) {
		System.out.println("Worker proxy Setteano name del tarjet");
		tarjet.setName(name);

	}

	@Override
	public int getAge() {
		System.out.println("Worker proxy Obteniendo age del tarjet");
		return tarjet.getAge();
	}

	@Override
	public void setAge(int age) {
		System.out.println("Worker proxy Setteano age del tarjet");
		tarjet.setAge(age);

	}

	@Override
	public void init() {
		System.out.println("Worker proxy llamando init method");
		tarjet.init();
	}

	@Override
	public void showInfo() {
		System.out.println("Worker proxy llamando show info method");
		tarjet.showInfo();

	}

	@Override
	public void destroy() {
		System.out.println("Worker proxy llamando destroy method");
		tarjet.destroy();

	}
	@Override
	public String toString() {
		return tarjet.toString();
		
	}
	
}
