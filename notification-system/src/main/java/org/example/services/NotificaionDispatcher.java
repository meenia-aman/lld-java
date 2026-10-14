package org.example.services;

import org.example.enums.NotificationChannelType;
import org.example.factory.NotificationFactory;
import org.example.models.Notification;
import org.example.startegy.channel.NotificationChannel;

/**
 * NotificaionDispatcher
 */
public class NotificaionDispatcher {

    private NotificationChannel notificationChannel;

    public NotificaionDispatcher() {}

    void sendNotificaion(
        Notification notification,
        NotificationChannelType type
    ) {
        notificationChannel = NotificationFactory.create(type);
        notificationChannel.send(notification);
    }
}
