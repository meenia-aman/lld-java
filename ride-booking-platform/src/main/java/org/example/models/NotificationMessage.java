package org.example.models;

import java.util.List;
import org.example.enums.NotificationChannel;

/**
 * NotificationMessage
 */
public class NotificationMessage {

    private String recipientUserId;
    private String title;
    private String body;
    private List<NotificationChannel> channels;

    public NotificationMessage(
        String recipeintUserId,
        String title,
        String body,
        List<NotificationChannel> channels
    ) {
        this.recipientUserId = recipeintUserId;
        this.title = title;
        this.body = body;
        this.channels = channels;
    }

    public String getRecipientUserId() {
        return recipientUserId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<NotificationChannel> getChannels() {
        return channels;
    }
}
