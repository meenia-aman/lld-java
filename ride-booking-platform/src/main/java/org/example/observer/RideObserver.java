package org.example.observer;

import org.example.models.Driver;
import org.example.models.Ride;

/**
 * RideObserver
 */
public interface RideObserver {
    void onRideAccepted(Ride ride);
    void onRideCompleted(Ride ride);
    void onRideOffer(Ride ride, Driver driver);
}
