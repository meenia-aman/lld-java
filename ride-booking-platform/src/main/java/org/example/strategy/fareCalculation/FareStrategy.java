package org.example.strategy.fareCalculation;

import java.util.List;
import java.util.Map;
import org.example.enums.FareStrategyType;
import org.example.enums.RideType;
import org.example.models.Location;

/**
 * FareStrategy
 */
public interface FareStrategy {
    Map<RideType, Double> getFare(
        Location startLocation,
        Location endLocation,
        List<RideType> ride
    );

    public FareStrategyType getStrategyType();
}
