package org.certificatic.spring.core.practica10.beanpostprocessors.bean.api;

public interface IWorker {
	public String getName();
	public void setName(String name);
	public int getAge();
	public void setAge(int age);
	public void init();
	public void showInfo();
	public void destroy();
	
}
