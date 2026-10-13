package org.example.observer;

import java.util.List;
import org.example.enums.NotificationChannel;
import org.example.models.Driver;
import org.example.models.NotificationMessage;
import org.example.models.Ride;
import org.example.models.UserContactInfo;
import org.example.services.NotificationService;

/**
 * RideNotificationListener
 */
public class RideNotificationListener implements RideObserver {

    private final NotificationService notificationService;

    public RideNotificationListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void onRideAccepted(Ride ride) {
        List<NotificationChannel> channels = List.of(
            NotificationChannel.CONSOLE
        );
        String recipeintUserId = ride.getRider().getRiderId();
        String title = "Ride Accepted";
        String body = "Ride Accepted and opt for verification is 1022";

        NotificationMessage message = new NotificationMessage(
            recipeintUserId,
            title,
            body,
            channels
        );

        UserContactInfo contactInfo = new UserContactInfo(
            ride.getRideId(),
            ride.getRider().getName(),
            ride.getRider().getPhoneNo()
        );
        notificationService.sendNotificaion(message, contactInfo);
    }

    @Override
    public void onRideCompleted(Ride ride) {
        List<NotificationChannel> channels = List.of(
            NotificationChannel.CONSOLE
        );
        String recipeintUserId = ride.getRider().getRiderId();
        String title = "Ride Completed";
        String body = "Ride completed successfully, Thanks for choosing us.";

        NotificationMessage message = new NotificationMessage(
            recipeintUserId,
            title,
            body,
            channels
        );

        UserContactInfo contactInfo = new UserContactInfo(
            ride.getRideId(),
            ride.getRider().getName(),
            ride.getRider().getPhoneNo()
        );
        notificationService.sendNotificaion(message, contactInfo);
    }

    @Override
    public void onRideOffer(Ride ride, Driver driver) {
        List<NotificationChannel> channels = List.of(
            NotificationChannel.CONSOLE
        );
        String recipeintUserId = ride.getRider().getRiderId();
        String title = "New Ride Offered";

        String body =
            "New ride from %s to %s | Rider: %s | Est. Fare: $%.2f".formatted(
                " Location A",
                "Location B",
                ride.getRider().getName(),
                ride.getAmount()
            );

        NotificationMessage message = new NotificationMessage(
            recipeintUserId,
            title,
            body,
            channels
        );

        UserContactInfo contactInfo = new UserContactInfo(
            driver.getDriverId(),
            driver.getName(),
            driver.getPhoneNo()
        );

        notificationService.sendNotificaion(message, contactInfo);
    }
}
