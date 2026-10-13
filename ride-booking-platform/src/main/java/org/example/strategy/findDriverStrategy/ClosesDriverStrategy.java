package org.example.strategy.findDriverStrategy;

import java.util.ArrayList;
import java.util.List;
import org.example.enums.FindDriverStrategyType;
import org.example.models.Driver;
import org.example.models.Ride;

/**
 * ClosesDriverStrategy
 */
public class ClosesDriverStrategy implements FindDriverStrategy {

    @Override
    public List<Driver> getDriverList(
        List<Driver> drivers,
        Ride ride,
        int no_of_driver,
        int radius
    ) {
        List<Driver> driverList = new ArrayList<>();

        for (Driver it : drivers) {
            if (it.getLocation().inRange(ride.getStartLocation(), radius)) {
                driverList.add(it);
            }
        }

        return driverList;
    }

    @Override
    public FindDriverStrategyType getType() {
        return FindDriverStrategyType.CLOSEST;
    }
}
