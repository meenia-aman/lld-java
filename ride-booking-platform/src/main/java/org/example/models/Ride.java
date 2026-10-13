package org.example.models;

import java.util.Map;
import java.util.UUID;
import org.example.enums.RideStatus;
import org.example.enums.RideType;

/**
 * Ride
 */
public class Ride {

    private final String rideId;
    private Rider rider;
    private Driver driver;
    private RideStatus rideStatus;
    private Location startLocation;
    private Location destination;
    private RideType rideType;
    private Map<RideType, Double> amount;

    public Ride(
        Rider rider,
        Location startLocation,
        Location destination,
        Map<RideType, Double> amount
    ) {
        this.rideId = UUID.randomUUID().toString();
        this.rider = rider;
        this.rideStatus = RideStatus.RIDE_CREATED;
        this.startLocation = startLocation;
        this.destination = destination;
        this.amount = amount;
    }

    public RideStatus updateRideStatus(RideStatus status) {
        this.rideStatus = status;
        return this.rideStatus;
    }

    // We are going to send the request to multiple Driver at a same time and drive who accpet
    // the request first will serve that request.That's why we are simply Assigning the status
    // to Accepted.
    public void AssignDriver(Driver driver) {
        this.driver = driver;
        this.updateRideStatus(RideStatus.RIDE_ACCEPTED);
    }

    public String getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getDestination() {
        return destination;
    }

    public double getAmount() {
        return amount.getOrDefault(this.rideType, 0.0);
    }

    public RideType getRideType() {
        return rideType;
    }

    public RideType setRideType(RideType type) {
        this.rideType = type;
        return type;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
