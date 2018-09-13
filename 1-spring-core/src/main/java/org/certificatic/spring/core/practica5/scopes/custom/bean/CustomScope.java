package org.certificatic.spring.core.practica5.scopes.custom.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomScope implements Scope {

	private Map<String, Object> objectMap = Collections.synchronizedMap(new HashMap<String, Object>());

	private int n = 0;

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {

		// System.out.println("solicitando bean: " + name);
		log.info("solicitando bean: {}", name);

		if (n >= 5) {
			this.clearBeans();
			n = 0;
		}

		if (!objectMap.containsKey(name)) {

			// System.out.println("construyendo bean: " + name);
			log.info("construyendo bean: {}", name);

			Object o = objectFactory.getObject();

			objectMap.put(name, o);
		}

		n++;

		return objectMap.get(name);
	}

	@Override
	public Object remove(String name) {
		return objectMap.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return "CustomScope";
	}

	public void clearBeans() {
		// System.out.println("eliminando beans");
		log.info("eliminando beans");

		objectMap.clear();
		n = 0;
	}

}
