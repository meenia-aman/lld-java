package org.example.startegy.channel;

import org.example.enums.NotificationChannelType;
import org.example.models.Notification;

/**
 * PushNotificaionChannel
 */
public class PushNotificaionChannel implements NotificationChannel {

    @Override
    public boolean send(Notification notification) {
        System.out.println(
            "Sending Notification to " +
                notification.getName() +
                " Via " +
                this.getType() +
                " Title : " +
                notification.getTitle()
        );
        return true;
    }

    @Override
    public NotificationChannelType getType() {
        return NotificationChannelType.PUSH;
    }
}
