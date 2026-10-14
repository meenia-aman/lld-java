package org.example.factory;

import org.example.enums.NotificationChannelType;
import org.example.startegy.channel.EmailChannel;
import org.example.startegy.channel.NotificationChannel;
import org.example.startegy.channel.PushNotificaionChannel;
import org.example.startegy.channel.SmsChannel;

/**
 * NotificationFactory
 */
public class NotificationFactory {

    public static NotificationChannel create(NotificationChannelType type) {
        return switch (type) {
            case NotificationChannelType.SMS -> new SmsChannel();
            case NotificationChannelType.EMAIL -> new EmailChannel();
            case NotificationChannelType.PUSH -> new PushNotificaionChannel();
        };
    }
}
