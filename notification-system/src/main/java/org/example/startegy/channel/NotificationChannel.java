package org.example.startegy.channel;

import org.example.enums.NotificationChannelType;
import org.example.models.Notification;

/**
 * NotificationChannel
 */
public interface NotificationChannel {
    boolean send(Notification notification);
    NotificationChannelType getType();
}
