package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.example.enums.FindDriverStrategyType;
import org.example.enums.RideStatus;
import org.example.enums.RideType;
import org.example.models.Driver;
import org.example.models.Location;
import org.example.models.Ride;
import org.example.models.Rider;
import org.example.observer.RideObserver;
import org.example.repository.rides.RideRepository;

/**
 * RideService
 */
public class RideService {

    private List<RideObserver> observers = new ArrayList<>();
    private RideRepository rideRepository;
    private FindDriverService findDriverService;

    public void registerObserver(RideObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RideObserver observer) {
        observers.remove(observer);
    }

    public RideService(
        RideRepository rideRepository,
        FindDriverService findDriverService
    ) {
        this.rideRepository = rideRepository;
        this.findDriverService = findDriverService;
    }

    Ride createRide(
        Rider rider,
        Location startLocation,
        Location destination,
        Map<RideType, Double> amount
    ) {
        Ride ride = new Ride(rider, startLocation, destination, amount);
        return rideRepository.add(ride);
    }

    Ride updateRideType(String rideId, RideType type) {
        Ride ride = this.getRideById(rideId);
        ride.setRideType(type);
        ride.updateRideStatus(RideStatus.RIDE_REQUESTED);
        return rideRepository.update(ride);
    }

    Ride bookRide(
        String rideId,
        RideType rideType,
        List<Driver> activeDrivers
    ) {
        Ride ride = this.getRideById(rideId);
        ride.updateRideStatus(RideStatus.RIDE_REQUESTED);
        List<Driver> driverList = findDriverService.getDrivers(
            activeDrivers,
            ride,
            FindDriverStrategyType.CLOSEST
        );

        for (Driver driver : driverList) {
            for (RideObserver observer : observers) {
                observer.onRideOffer(ride, driver);
            }
        }
        return rideRepository.update(ride);
    }

    Ride acceptRide(String rideId, Driver driver) {
        Ride ride = this.getRideById(rideId);
        ride.AssignDriver(driver);

        for (RideObserver observer : observers) {
            observer.onRideAccepted(ride);
        }
        return rideRepository.update(ride);
    }

    Ride getRideById(String rideId) {
        return rideRepository.getRideById(rideId);
    }

    Ride updateRideStatus(String rideId, RideStatus rideStatus) {
        Ride ride = this.getRideById(rideId);
        ride.setRideStatus(rideStatus);
        return rideRepository.update(ride);
    }
}
