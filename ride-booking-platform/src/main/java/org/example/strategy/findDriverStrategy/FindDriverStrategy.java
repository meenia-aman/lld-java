package org.example.strategy.findDriverStrategy;

import java.util.List;
import org.example.enums.FindDriverStrategyType;
import org.example.models.Driver;
import org.example.models.Ride;

/**
 * AssignDriverStrategy
 */
public interface FindDriverStrategy {
    List<Driver> getDriverList(
        List<Driver> drivers,
        Ride rider,
        int no_of_driver,
        int radius
    );
    FindDriverStrategyType getType();
}
