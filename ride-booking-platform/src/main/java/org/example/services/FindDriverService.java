package org.example.services;

import java.util.List;
import org.example.enums.FindDriverStrategyType;
import org.example.models.Driver;
import org.example.models.Ride;
import org.example.strategy.findDriverStrategy.ClosesDriverStrategy;
import org.example.strategy.findDriverStrategy.FindDriverStrategy;

/**
 * FindDriverService
 */
public class FindDriverService {

    private int no_of_dirvers = 5;
    private int radius = 5; // Km

    private FindDriverStrategy findDriverStrategy;

    void createDriverStrategy(FindDriverStrategyType type) {
        if (type == FindDriverStrategyType.CLOSEST) {
            findDriverStrategy = new ClosesDriverStrategy();
        }
    }

    public List<Driver> getDrivers(
        List<Driver> drivers,
        Ride ride,
        FindDriverStrategyType type
    ) {
        createDriverStrategy(type);

        List<Driver> driverList = findDriverStrategy.getDriverList(
            drivers,
            ride,
            no_of_dirvers,
            radius
        );

        return driverList;
    }
}
