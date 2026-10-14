package org.example.models;

import java.util.Map;
import java.util.UUID;
import org.example.enums.NotificationChannelType;
import org.example.enums.NotificationStatus;
import org.example.enums.NotificationType;

/**
 * Notificaion
 */
public class Notification {

    private final String id;
    private String recipientId;
    private String message;
    private String title;
    private String templateId;
    private Map<String, String> dynamicVariables;
    private NotificationType type;
    private NotificationStatus staus;
    private boolean isTemplateNotification;
    private String email;
    private String phonNo;
    private String name;
    private NotificationChannelType channelType;

    private Notification(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.recipientId = builder.recipientId;
        this.message = builder.message;
        this.title = builder.title;
        this.dynamicVariables = builder.dynamicVariables;
        this.type = builder.type;
        this.staus = builder.status;
        this.isTemplateNotification = builder.templateId != null;
        this.email = builder.email;
        this.phonNo = builder.phoneNo;
        this.name = builder.name;
        this.channelType = builder.channelType;
        this.templateId = builder.templateId;
    }

    public static Builder builder(
        String recipientId,
        NotificationType type,
        NotificationChannelType channelType
    ) {
        return new Builder(recipientId, type, channelType);
    }

    public static class Builder {

        private final String recipientId;
        private final NotificationType type;

        private String message;
        private String title;
        private String templateId;
        private String email;
        private String phoneNo;
        private String name;
        private NotificationChannelType channelType;

        private Map<String, String> dynamicVariables;
        private NotificationStatus status = NotificationStatus.CREATED;

        public Builder(
            String recipientId,
            NotificationType type,
            NotificationChannelType channelType
        ) {
            this.recipientId = recipientId;
            this.type = type;
            this.channelType = channelType;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder templateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Builder dynamicVariables(Map<String, String> dynmaicVariables) {
            this.dynamicVariables = dynmaicVariables;
            return this;
        }

        public Builder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Notification build() {
            if (message == null && templateId == null) {
                throw new IllegalStateException(
                    "Notificaion must have either a direct message or a template"
                );
            }
            return new Notification(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getTemplateId() {
        return templateId;
    }

    public Map<String, String> getDynamicVariables() {
        return dynamicVariables;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationStatus getStaus() {
        return staus;
    }

    public boolean isTemplateNotification() {
        return isTemplateNotification;
    }

    public void setStaus(NotificationStatus staus) {
        this.staus = staus;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonNo() {
        return phonNo;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationChannelType getChannelType() {
        return channelType;
    }
}
