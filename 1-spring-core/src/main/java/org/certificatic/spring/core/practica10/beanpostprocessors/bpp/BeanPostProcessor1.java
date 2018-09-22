package org.certificatic.spring.core.practica10.beanpostprocessors.bpp;

import org.certificatic.spring.core.practica10.beanpostprocessors.bean.Worker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.Getter;

public class BeanPostProcessor1 implements BeanPostProcessor, Ordered {

	private @Getter int order = 1;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("[BPP Before Init " + order + " ]");

		if (bean instanceof Worker) {
			Worker w = (Worker) bean;

			System.out.println("[BPP] worker name: " + w.getName());
			System.out.println("[BPP] worker age: " + w.getAge());
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("[BPP After Init " + order + " ]");

		if (bean instanceof Worker) {
			Worker w = (Worker) bean;

			System.out.println("[BPP] worker name: " + w.getName());
			System.out.println("[BPP] worker age: " + w.getAge());

			w.setName("Paula");
			w.setAge(6);
		}

		return bean;
	}

}