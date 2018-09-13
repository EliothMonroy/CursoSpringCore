package org.certificatic.spring.core.tarea1.notification.service.api;

import org.certificatic.spring.core.tarea1.notification.enums.NotificationType;

public interface INotificationService {

	void notifyTo(String receiver, String message,
			NotificationType notificationType);

}
