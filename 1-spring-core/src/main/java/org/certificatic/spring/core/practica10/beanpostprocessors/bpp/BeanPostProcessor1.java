package org.certificatic.spring.core.practica10.beanpostprocessors.bpp;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.Worker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.Getter;

public class BeanPostProcessor1 implements BeanPostProcessor, Ordered{
	private @Getter int order=1;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("BeanPostProcesor befor: "+order);
		if(bean instanceof Worker) {
			Worker w=(Worker)bean;
			System.out.println("Worker name: "+w.getName());
			System.out.println("Worker age: "+w.getAge());
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("BeanPostProcesor after: "+order);
		if(bean instanceof Worker) {
			Worker w=(Worker)bean;
			System.out.println("Worker name: "+w.getName());
			System.out.println("Worker age: "+w.getAge());
			w.setAge(6);
			w.setName("Hola");
			System.out.println("Worker name: "+w.getName());
			System.out.println("Worker age: "+w.getAge());
		}
		return bean;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}