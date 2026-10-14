package org.example;

import java.util.Set;
import org.example.dtos.CreateTemplateRequest;
import org.example.enums.NotificationChannelType;
import org.example.enums.NotificationType;
import org.example.models.Notification;
import org.example.models.Template;
import org.example.repository.notification.InMemoryNotificaionRepository;
import org.example.repository.notification.NotificationRepository;
import org.example.repository.preference.InMemoryPreferenceRepository;
import org.example.repository.preference.PreferenceRepository;
import org.example.repository.template.InMemoryTemplateRepository;
import org.example.repository.template.TemplateRepository;
import org.example.services.NotificaionDispatcher;
import org.example.services.NotificaionService;
import org.example.services.NotificationSystem;
import org.example.services.PreferenceService;
import org.example.services.TemplateService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main() {
        System.out.println(
            "================= NOTIFICATION SYSTEM ===================="
        );

        NotificationRepository notificationRepository =
            new InMemoryNotificaionRepository();
        TemplateRepository templateRepository =
            new InMemoryTemplateRepository();
        PreferenceRepository preferenceRepository =
            new InMemoryPreferenceRepository();

        NotificaionDispatcher notificaionDispatcher =
            new NotificaionDispatcher();
        NotificaionService notificaionService = new NotificaionService(
            notificationRepository
        );
        TemplateService templateService = new TemplateService(
            templateRepository
        );
        PreferenceService preferenceService = new PreferenceService(
            preferenceRepository
        );

        NotificationSystem notificationSystem = new NotificationSystem(
            notificaionService,
            preferenceService,
            templateService,
            notificaionDispatcher
        );

        Notification notification = Notification.builder(
            "user_101",
            NotificationType.ACCTOUNT_CREATED,
            NotificationChannelType.SMS
        )
            .title("Welcome")
            .message("Thanks for joining our service!")
            .name("Aman Meenia")
            .email("aman@gmail.com")
            .phoneNo("123123123")
            .build();

        notificationSystem.sendNotificaion(notification);

        CreateTemplateRequest createTemplateRequest = new CreateTemplateRequest(
            "T1-A",
            "Sky",
            "Email Verifiction",
            "Please verify your email to access the platform",
            NotificationType.SEND_VERIFICATION_EMAIL,
            NotificationChannelType.EMAIL,
            Set.of()
        );
        Template template = notificationSystem.createTemplate(
            createTemplateRequest
        );

        notificationSystem.addPreference("user_101", template.getType());

        System.out.println("Template Id is " + template.getId());
        Notification notification2 = Notification.builder(
            "user_102",
            template.getType(),
            template.getChannel()
        )
            .templateId(template.getId())
            .name("Aman")
            .email("Aman")
            .build();

        notificationSystem.sendNotificaion(notification2);
    }
}
