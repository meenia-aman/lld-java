package org.example.dtos;

import java.util.Set;
import org.example.enums.NotificationChannelType;
import org.example.enums.NotificationType;

/**
 * CreateTemplateRequest
 */
public record CreateTemplateRequest(
    String userId,
    String name,
    String title,
    String message,
    NotificationType type,
    NotificationChannelType channelType,
    Set<String> dynamicVariables
) {}
