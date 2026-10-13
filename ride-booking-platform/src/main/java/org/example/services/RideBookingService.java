package org.example.services;

import java.util.List;
import java.util.Map;
import org.example.enums.FareStrategyType;
import org.example.enums.PaymentType;
import org.example.enums.RideStatus;
import org.example.enums.RideType;
import org.example.models.Driver;
import org.example.models.Location;
import org.example.models.Ride;
import org.example.models.Rider;
import org.example.models.Transaction;
import org.example.models.Vehicle;

/**
 * RideBookingService
 */
public class RideBookingService {

    private RiderService riderService;
    private DriverService driverService;
    private RideService rideService;
    private FareCalculationService fareCalculationService;
    private PaymentService paymentService;

    public RideBookingService(
        RiderService riderService,
        DriverService driverService,
        RideService rideService,
        FareCalculationService fareCalculationService,
        PaymentService paymentService,
        FindDriverService findDriverService
    ) {
        this.riderService = riderService;
        this.driverService = driverService;
        this.rideService = rideService;
        this.fareCalculationService = fareCalculationService;
        this.paymentService = paymentService;
    }

    public Rider createRider(String name, String phoneNo) {
        return riderService.createRider(name, phoneNo);
    }

    public Driver createDriver(
        String name,
        String phoneNo,
        Location location,
        Vehicle vehicle
    ) {
        return driverService.createDriver(name, phoneNo, vehicle, location);
    }

    public Driver updateDriverLocation(String driverId, Location location) {
        return driverService.updateLocation(driverId, location);
    }

    List<Driver> getActiveDriverInRangeR(
        RideType type,
        int radius,
        Location location
    ) {
        return driverService.getActiveDriverByRideType(type, radius, location);
    }

    Driver getDriverById(String id) {
        return driverService.getDriverById(id);
    }

    Map<RideType, Double> getFare(
        Location startLocation,
        Location endLocation,
        List<RideType> ride,
        FareStrategyType type
    ) {
        return fareCalculationService.getFare(
            startLocation,
            endLocation,
            ride,
            type
        );
    }

    public Ride createRide(
        Rider rider,
        Location startLocation,
        Location endLocation,
        List<RideType> rideType
    ) {
        Map<RideType, Double> amount = this.getFare(
            startLocation,
            endLocation,
            rideType,
            FareStrategyType.DISTANCE_BASED
        );

        return rideService.createRide(
            rider,
            startLocation,
            endLocation,
            amount
        );
    }

    public Ride getRideById(String rideId) {
        return this.getRideById(rideId);
    }

    public Ride bookRide(String rideId, RideType rideType) {
        Ride ride = rideService.getRideById(rideId);
        List<Driver> activeDrivers = driverService.getActiveDriverByRideType(
            rideType,
            5,
            ride.getStartLocation()
        );

        rideService.bookRide(rideId, rideType, activeDrivers);

        return ride;
    }

    public Ride acceptRide(String rideId, Driver driver) {
        return rideService.acceptRide(rideId, driver);
    }

    public Ride updateRideStatus(String rideId, RideStatus status) {
        return rideService.updateRideStatus(rideId, status);
    }

    public Transaction makePayment(String rideId, PaymentType type) {
        Ride ride = rideService.getRideById(rideId);
        Transaction t = paymentService.createPayment(
            rideId,
            ride.getAmount(),
            type
        );
        return t;
    }
}
