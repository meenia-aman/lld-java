package org.example.services;

import org.example.models.Notification;
import org.example.repository.notification.NotificationRepository;

/**
 * NotificaionService
 */
public class NotificaionService {

    private NotificationRepository notificationRepository;

    public NotificaionService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification create(Notification notification) {
        return notificationRepository.add(notification);
    }
}
