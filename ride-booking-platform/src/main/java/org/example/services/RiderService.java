package org.example.services;

import org.example.models.Rider;
import org.example.repository.rider.RiderRepository;

/**
 * RiderService
 */
public class RiderService {

    private RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    Rider createRider(String name, String phoneNo) {
        Rider rider = new Rider(name, phoneNo);
        return riderRepository.add(rider);
    }

    Rider getRiderById(String riderId) {
        return riderRepository.getById(riderId);
    }
}
