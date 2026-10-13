package org.example.strategy.fareCalculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.enums.FareStrategyType;
import org.example.enums.RideType;
import org.example.models.Location;

/**
 * DistanceBasedFareStrategy
 */
public class DistanceBasedFareStrategy implements FareStrategy {

    @Override
    public Map<RideType, Double> getFare(
        Location startLocation,
        Location endLocation,
        List<RideType> rideType
    ) {
        Map<RideType, Double> priceList = new HashMap<>();

        for (RideType type : rideType) {
            if (type == RideType.AUTO) {
                priceList.put(RideType.AUTO, 100.0);
            } else if (type == RideType.BIKE) {
                priceList.put(RideType.BIKE, 80.0);
            } else if (type == RideType.CAR) {
                priceList.put(RideType.CAR, 300.0);
            } else {
                priceList.put(RideType.CAR, 90.0);
            }
        }

        return priceList;
    }

    @Override
    public FareStrategyType getStrategyType() {
        return FareStrategyType.DISTANCE_BASED;
    }
}
