package org.certificatic.spring.core.tarea1.notification.service.api.impl;

import org.certificatic.spring.core.tarea1.messaging.service.api.IMessageService;

public class TwitterMessageServiceImpl implements IMessageService {

	@Override
	public void sendMessage(String receiver, String message) {
		System.out.println(">>> TWITTER -------------");
		System.out.println("enviando twitt a: " + receiver);
		System.out.println("mensaje: " + message);
		System.out.println("-------------");
	}

}
