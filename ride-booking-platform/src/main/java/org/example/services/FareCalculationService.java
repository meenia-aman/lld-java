package org.example.services;

import java.util.List;
import java.util.Map;
import org.example.enums.FareStrategyType;
import org.example.enums.RideType;
import org.example.models.Location;
import org.example.strategy.fareCalculation.DistanceBasedFareStrategy;
import org.example.strategy.fareCalculation.FareStrategy;

/**
 * FareCalculationService
 */
public class FareCalculationService {

    private FareStrategy fareStrategy;

    void getFareStrategyOject(FareStrategyType type) {
        fareStrategy = new DistanceBasedFareStrategy();
    }

    public Map<RideType, Double> getFare(
        Location startLocation,
        Location endLocation,
        List<RideType> ride,
        FareStrategyType type
    ) {
        getFareStrategyOject(type);

        return fareStrategy.getFare(startLocation, endLocation, ride);
    }
}
