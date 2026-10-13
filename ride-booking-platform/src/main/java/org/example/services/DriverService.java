package org.example.services;

import java.util.ArrayList;
import java.util.List;
import org.example.enums.DriverStatusType;
import org.example.enums.RideType;
import org.example.models.Driver;
import org.example.models.Location;
import org.example.models.Vehicle;
import org.example.repository.driver.DriverRepository;

/**
 * DriverService
 */
public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    Driver createDriver(
        String name,
        String phoneNo,
        Vehicle vehicle,
        Location location
    ) {
        Driver driver = new Driver(name, phoneNo, vehicle, location);
        return driverRepository.add(driver);
    }

    Driver updateDriverStatus(String driverId, DriverStatusType type) {
        Driver driver = getDriverById(driverId);
        driver.uDriverStatusType(type);
        return driver;
    }

    Driver getDriverById(String driverId) {
        return driverRepository.getById(driverId);
    }

    Driver updateLocation(String driverId, Location location) {
        Driver driver = this.getDriverById(driverId);
        driver
            .getLocation()
            .updateLocation(
                location.getxCoordinates(),
                location.getyCoordinates()
            );

        return driverRepository.update(driver);
    }

    List<Driver> getActiveDriverByRideType(
        RideType type,
        int radius,
        Location location
    ) {
        List<Driver> drivers = driverRepository.getAll();

        List<Driver> driverList = new ArrayList<>();

        for (Driver driver : drivers) {
            if (
                driver.getStatus().equals(DriverStatusType.AVAILABLE) &&
                driver.getLocation().inRange(location, radius)
            ) {
                driverList.add(driver);
            }
        }

        return driverList;
    }
}
