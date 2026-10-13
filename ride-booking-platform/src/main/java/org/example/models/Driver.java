package org.example.models;

import java.util.UUID;
import org.example.enums.DriverStatusType;

/**
 * Driver
 */
public class Driver {

    private final String driverId;
    private String name;
    private String phoneNo;
    private DriverStatusType status;
    private Vehicle vehicle;
    private Location location;

    public Driver(
        String name,
        String phoneNo,
        Vehicle vehicle,
        Location location
    ) {
        this.driverId = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNo = phoneNo;
        this.vehicle = vehicle;
        this.status = DriverStatusType.AVAILABLE;
        this.location = location;
    }

    void updateLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public DriverStatusType uDriverStatusType(DriverStatusType status) {
        this.status = status;
        return this.status;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public DriverStatusType getStatus() {
        return status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
