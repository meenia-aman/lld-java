package org.example.services;

import org.example.models.NotificationMessage;
import org.example.models.UserContactInfo;
import org.example.strategy.notificationStrategy.NotificationStrategy;

/**
 * NotificationService
 */
public class NotificationService {

    private final NotificationStrategy strategy;

    public NotificationService(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendNotificaion(
        NotificationMessage message,
        UserContactInfo contactInfo
    ) {
        strategy.send(message, contactInfo);
    }
}
