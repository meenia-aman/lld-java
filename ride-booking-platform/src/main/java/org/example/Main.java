package org.example;

import java.util.List;
import org.example.enums.RideType;
import org.example.models.Driver;
import org.example.models.Location;
import org.example.models.Ride;
import org.example.models.Rider;
import org.example.models.Vehicle;
import org.example.observer.RideNotificationListener;
import org.example.observer.RideObserver;
import org.example.repository.driver.DriverRepository;
import org.example.repository.driver.InMemoryDriverRepository;
import org.example.repository.payment.InMemoryPaymentRepository;
import org.example.repository.payment.PaymentRepository;
import org.example.repository.rider.InMemoryRiderRepository;
import org.example.repository.rider.RiderRepository;
import org.example.repository.rides.InMemoryRideRepository;
import org.example.repository.rides.RideRepository;
import org.example.services.DriverService;
import org.example.services.FareCalculationService;
import org.example.services.FindDriverService;
import org.example.services.NotificationService;
import org.example.services.PaymentService;
import org.example.services.RideBookingService;
import org.example.services.RideService;
import org.example.services.RiderService;
import org.example.strategy.notificationStrategy.ConsoleNotificationStrategy;
import org.example.strategy.notificationStrategy.NotificationStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main() {
        System.out.println(
            "================= RIDE BOOKING PLATFORM =================="
        );

        PaymentRepository paymentRepository = new InMemoryPaymentRepository();
        RiderRepository riderRepository = new InMemoryRiderRepository();
        DriverRepository driverRepository = new InMemoryDriverRepository();
        RideRepository rideRepository = new InMemoryRideRepository();

        PaymentService paymentService = new PaymentService(paymentRepository);
        RiderService riderService = new RiderService(riderRepository);
        DriverService driverService = new DriverService(driverRepository);

        FindDriverService findDriverService = new FindDriverService();
        RideService rideService = new RideService(
            rideRepository,
            findDriverService
        );
        FareCalculationService fareCalculationService =
            new FareCalculationService();

        NotificationStrategy strategy = new ConsoleNotificationStrategy();

        NotificationService notificationService = new NotificationService(
            strategy
        );
        RideObserver observer = new RideNotificationListener(
            notificationService
        );

        rideService.registerObserver(observer);

        RideBookingService uber = new RideBookingService(
            riderService,
            driverService,
            rideService,
            fareCalculationService,
            paymentService,
            findDriverService
        );

        Rider rider = uber.createRider("Aman", "121231233");
        System.out.println("Rider created successfully ");
        System.out.println(
            " Name " + rider.getName() + " Id " + rider.getRiderId()
        );
        System.out.println("");

        Location location = new Location(10.0, 12.0);
        Vehicle vehicle = new Vehicle("JK02CX2252", RideType.BIKE);

        Driver driver = uber.createDriver(
            "Meenia",
            "12312312",
            location,
            vehicle
        );

        System.out.println("Driver created successfully");
        System.out.println(
            " Name " + driver.getName() + " Id " + driver.getDriverId()
        );

        Location startLocation = new Location(10, 12);
        Location endLocation = new Location(10, 12);

        List<RideType> rideTypes = List.of(RideType.BIKE, RideType.CAR);

        Ride ride = uber.createRide(
            rider,
            startLocation,
            endLocation,
            rideTypes
        );

        System.out.println(
            "Ride created successfully " +
                ride.getRideId() +
                " From " +
                ride.getStartLocation().getxCoordinates() +
                ", " +
                ride.getStartLocation().getyCoordinates() +
                " Status " +
                ride.getRideStatus()
        );

        ride = uber.bookRide(ride.getRideId(), RideType.BIKE);

        System.out.println(
            "Ride created successfully " +
                ride.getRideId() +
                " From " +
                ride.getStartLocation().getxCoordinates() +
                ", " +
                ride.getStartLocation().getyCoordinates() +
                " Status " +
                ride.getRideStatus()
        );

        ride = uber.acceptRide(ride.getRideId(), driver);

        System.out.println(
            "Ride created successfully " +
                ride.getRideId() +
                " From " +
                ride.getStartLocation().getxCoordinates() +
                ", " +
                ride.getStartLocation().getyCoordinates() +
                " Status " +
                ride.getRideStatus()
        );
    }
}
