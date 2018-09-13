package org.certificatic.spring.core.tarea1.messaging.service.api.impl;

import org.certificatic.spring.core.tarea1.messaging.service.api.IMessageService;
import org.certificatic.spring.core.tarea1.notification.enums.NotificationType;
import org.certificatic.spring.core.tarea1.notification.service.api.INotificationService;

import lombok.Getter;
import lombok.Setter;

public class NotificationServiceImpl implements INotificationService {

	private @Getter @Setter IMessageService facebookMessageService;

	private @Getter @Setter IMessageService twitterMessageService;

	private @Getter @Setter IMessageService emailMessageService;

	@Override
	public void notifyTo(String receiver, String message,
			NotificationType notificationType) {

		//Implementar
	}
}
