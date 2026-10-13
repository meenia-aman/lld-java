package org.example.strategy.notificationStrategy;

import org.example.enums.NotificationChannel;
import org.example.models.NotificationMessage;
import org.example.models.UserContactInfo;

/**
 * ConsoleNotificationStrategy
 */
public class ConsoleNotificationStrategy implements NotificationStrategy {

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.CONSOLE;
    }

    @Override
    public void send(NotificationMessage message, UserContactInfo contact) {
        System.out.println(
            "[NOTIFICATION - " +
                message.getBody() +
                " Name " +
                contact.name() +
                " Email " +
                contact.phoneNumber()
        );
    }
}
