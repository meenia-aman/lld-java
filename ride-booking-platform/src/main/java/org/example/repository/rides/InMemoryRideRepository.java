package org.example.repository.rides;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.models.Ride;

/**
 * InMemoryRideRepository
 */
public class InMemoryRideRepository implements RideRepository {

    private Map<String, Ride> rides = new HashMap<>();

    @Override
    public Ride add(Ride ride) {
        this.rides.put(ride.getRideId(), ride);
        return ride;
    }

    @Override
    public Ride update(Ride ride) {
        this.rides.put(ride.getRideId(), ride);
        return ride;
    }

    @Override
    public Ride getRideById(String id) {
        return this.rides.getOrDefault(id, null);
    }

    @Override
    public List<Ride> getAllRidesByUserId(String id) {
        List<Ride> rideList = this.rides.values().stream().toList();

        List<Ride> result = new ArrayList<>();

        for (Ride ride : rideList) {
            if (
                ride.getDriver().getDriverId().equals(id) ||
                ride.getRider().getRiderId().equals(id)
            ) {
                result.add(ride);
            }
        }
        return result;
    }
}
