package org.example.repository.driver;

import java.util.List;
import org.example.models.Driver;

/**
 * DriverRepository
 */
public interface DriverRepository {
    Driver add(Driver d);
    Driver update(Driver d);
    Driver getById(String id);
    List<Driver> getAll();
}
