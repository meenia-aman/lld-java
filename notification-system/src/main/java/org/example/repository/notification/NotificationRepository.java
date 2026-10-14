package org.example.repository.notification;

import org.example.models.Notification;

/**
 * NotificationRepository
 */
public interface NotificationRepository {
    Notification add(Notification notification);
    Notification update(Notification notification);
    Notification getById(String id);
}
