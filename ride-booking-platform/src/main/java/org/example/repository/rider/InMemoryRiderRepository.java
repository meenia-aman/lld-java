package org.example.repository.rider;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Rider;

/**
 * InMemoryRiderRepository
 */
public class InMemoryRiderRepository implements RiderRepository {

    private Map<String, Rider> riders = new HashMap<>();

    @Override
    public Rider add(Rider rider) {
        riders.put(rider.getRiderId(), rider);
        return rider;
    }

    @Override
    public Rider update(Rider rider) {
        riders.put(rider.getRiderId(), rider);
        return rider;
    }

    @Override
    public Rider getById(String id) {
        return riders.getOrDefault(id, null);
    }
}
