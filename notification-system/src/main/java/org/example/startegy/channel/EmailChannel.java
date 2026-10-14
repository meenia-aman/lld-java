package org.example.startegy.channel;

import org.example.enums.NotificationChannelType;
import org.example.models.Notification;

/**
 * EmailChannel
 */
public class EmailChannel implements NotificationChannel {

    @Override
    public NotificationChannelType getType() {
        return NotificationChannelType.EMAIL;
    }

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
}
