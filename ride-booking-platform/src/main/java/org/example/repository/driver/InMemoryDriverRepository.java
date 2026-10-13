package org.example.repository.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.models.Driver;

/**
 * InMemoryDriverRepository
 */
public class InMemoryDriverRepository implements DriverRepository {

    private Map<String, Driver> drivers = new HashMap<>();

    @Override
    public Driver add(Driver d) {
        drivers.put(d.getDriverId(), d);
        return d;
    }

    @Override
    public Driver update(Driver d) {
        drivers.put(d.getDriverId(), d);
        return d;
    }

    @Override
    public List<Driver> getAll() {
        return drivers.values().stream().toList();
    }

    @Override
    public Driver getById(String id) {
        return drivers.getOrDefault(id, null);
    }
}
