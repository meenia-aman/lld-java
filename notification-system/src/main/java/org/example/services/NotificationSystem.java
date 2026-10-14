package org.example.services;

import org.example.dtos.CreateTemplateRequest;
import org.example.enums.NotificationType;
import org.example.models.Notification;
import org.example.models.Preference;
import org.example.models.Template;

/**
 * NotificaionSystem
 */
public class NotificationSystem {

    private NotificaionService notificaionService;
    private PreferenceService preferenceService;
    private TemplateService templateService;
    private NotificaionDispatcher notificaionDispatcher;

    public NotificationSystem(
        NotificaionService notificaionService,
        PreferenceService preferenceService,
        TemplateService templateService,
        NotificaionDispatcher notificaionDispatcher
    ) {
        this.notificaionDispatcher = notificaionDispatcher;
        this.notificaionService = notificaionService;
        this.templateService = templateService;
        this.preferenceService = preferenceService;
    }

    public void sendNotificaion(Notification notification) {
        notification = notificaionService.create(notification);

        if (notification.isTemplateNotification()) {
            System.out.println(
                "Notificaion is by Template" +
                    " Template Id " +
                    notification.getTemplateId()
            );

            Template t = this.getTemplateById(notification.getTemplateId());

            System.out.println(" Template create successfully ");
            System.out.println("Name : " + t.getName());
            System.out.println("Title : " + t.getTitle());
            System.out.println("Message : " + t.getMessage());
            System.out.println("Type : " + t.getType());
            System.out.println("Channel : " + t.getChannel());
            notification.setMessage(t.getMessage());
            notification.setTitle(t.getTitle());
        }

        Preference preference = preferenceService.getById(
            notification.getRecipientId()
        );

        if (
            preference != null &&
            !this.canSendNotificationToUser(
                notification.getRecipientId(),
                notification.getType()
            )
        ) {
            System.out.println(
                "Can't sent the Notificaion of type " +
                    notification.getType() +
                    " to user " +
                    notification.getName()
            );
            return;
        }

        notificaionDispatcher.sendNotificaion(
            notification,
            notification.getChannelType()
        );
    }

    public Template createTemplate(CreateTemplateRequest data) {
        return templateService.create(data);
    }

    public Template getTemplateById(String templateId) {
        return templateService.getTemplateById(templateId);
    }

    public Preference addPreference(String id, NotificationType type) {
        return preferenceService.addPreference(id, type);
    }

    public Preference removePreferece(String id, NotificationType type) {
        return preferenceService.removePreference(id, type);
    }

    public boolean canSendNotificationToUser(String id, NotificationType type) {
        return preferenceService.canSend(id, type);
    }
}
