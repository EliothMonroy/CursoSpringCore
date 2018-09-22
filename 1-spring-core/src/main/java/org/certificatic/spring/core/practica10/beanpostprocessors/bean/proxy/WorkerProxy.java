package org.certificatic.spring.core.practica10.beanpostprocessors.bean.proxy;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.api.IWorker;

import lombok.Setter;

public class WorkerProxy implements IWorker {

	private @Setter IWorker target;

	@Override
	public String getName() {
		System.out.println("[Worker proxy] obteniendo name de target object");
		return target.getName();
	}

	@Override
	public void setName(String name) {
		System.out.println("[Worker proxy] asignado name en target object");
		target.setName(name);
	}

	@Override
	public int getAge() {
		System.out.println("[Worker proxy] obteniendo age de target object");
		return target.getAge();
	}

	@Override
	public void setAge(int age) {
		System.out.println("[Worker proxy] asignando age en target object");
		target.setAge(age);
	}

	@Override
	public void init() {
		System.out.println("[Worker proxy] llamando init method");
		target.init();
	}

	@Override
	public void showInfo() {
		System.out.println("[Worker proxy] llamando showInfo method");
		target.showInfo();
		System.out.println("[Worker proxy] despues del llamado de showInfo method");
	}

	@Override
	public void destroy() {
		System.out.println("[Worker proxy] llamando destroy method");
		target.destroy();
	}

	@Override
	public String toString() {
		return target.toString();
	}

}
