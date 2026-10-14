package org.example.repository.notification;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Notification;

/**
 * InMemoryNotificaionRepository
 */
public class InMemoryNotificaionRepository implements NotificationRepository {

    private Map<String, Notification> notifications = new HashMap<>();

    @Override
    public Notification add(Notification notification) {
        this.notifications.put(notification.getId(), notification);
        return notification;
    }

    @Override
    public Notification update(Notification notification) {
        this.notifications.put(notification.getId(), notification);
        return notification;
    }

    @Override
    public Notification getById(String id) {
        return this.notifications.getOrDefault(id, null);
    }
}
