package org.example.strategy.notificationStrategy;

import org.example.enums.NotificationChannel;
import org.example.models.NotificationMessage;
import org.example.models.UserContactInfo;

/**
 * NotificationStrategy
 */
public interface NotificationStrategy {
    NotificationChannel getChannel();

    void send(NotificationMessage message, UserContactInfo contactInfo);
}
