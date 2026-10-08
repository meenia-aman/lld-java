package org.example.factory;

import org.example.enums.ElevatorAllocationStrategyType;
import org.example.strategy.ElevatorAllocationStrategey;
import org.example.strategy.LookAllocationStrategy;
import org.example.strategy.NearestElevatorAllocationStrategy;

public class ElevatorAllocationFactory {

    public  static ElevatorAllocationStrategey create(ElevatorAllocationStrategyType type){

        return switch (type) {
            case ElevatorAllocationStrategyType.LOOK_ALGORITHM_STRATEGY ->new LookAllocationStrategy();
            case ElevatorAllocationStrategyType.NEAREST_ALLOCATION_STRATEGY->new NearestElevatorAllocationStrategy();
            default -> throw  new IllegalArgumentException("Please select the provided type only");
        };
    }
}
