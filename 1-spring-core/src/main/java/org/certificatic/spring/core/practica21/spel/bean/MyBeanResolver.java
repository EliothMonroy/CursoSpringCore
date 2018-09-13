package org.certificatic.spring.core.practica21.spel.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

public class MyBeanResolver implements BeanResolver, ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public Object resolve(EvaluationContext context, String beanName) throws AccessException {
		return applicationContext.getBean(beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
