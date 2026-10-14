package org.example.models;

import java.util.Set;
import java.util.UUID;
import org.example.enums.NotificationChannelType;
import org.example.enums.NotificationType;

/**
 * Template
 */
public class Template {

    private final String id;
    private final String userId;
    private String name;
    private String title;
    private String message;
    private Set<String> dynamicVariables;
    private NotificationType type;
    private NotificationChannelType channel;

    public Template(
        String userId,
        String name,
        String title,
        String message,
        NotificationType type,
        NotificationChannelType channel,
        Set<String> dynamicVariables
    ) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.name = name;
        this.title = title;
        this.message = message;
        this.dynamicVariables = dynamicVariables;
        this.channel = channel;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Set<String> getDynamicVariables() {
        return dynamicVariables;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationChannelType getChannel() {
        return channel;
    }
}
