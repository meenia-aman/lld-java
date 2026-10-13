package org.example.repository.rides;

import java.util.List;
import org.example.models.Ride;

/**
 * RideRepository
 */
public interface RideRepository {
    Ride add(Ride ride);
    Ride update(Ride ride);
    Ride getRideById(String id);
    List<Ride> getAllRidesByUserId(String id);
}
