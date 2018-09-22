package org.certificatic.spring.core.practica10.beanpostprocessors.bean;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.api.IWorker;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Worker implements IWorker{
	private @Getter @Setter String name;
	private @Getter @Setter int age;

	public Worker() {
		this.name = "Ivan Garc�a";
		this.age = 10;

		System.out.println("[Construct] Worker name: " + this.name);
		System.out.println("[Construct] Worker name: " + this.age);
	}

	public void init() {
		System.out.println("[init] Initializing Worker.");

		System.out.println("[init] Worker name: " + this.name);

		this.name = "Worker 1";

		System.out.println("[init] Worker name: " + this.name);
	}

	public void showInfo() {
		String msg = String.format("> I'm Worker: %s. [%s]",
				this.name, this.hashCode());

		System.out.println("[showInfo] " + msg);
	}

	public void destroy() {
		System.out.println("[destroy] Destructing Worker.");
	}
}
