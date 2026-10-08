package org.example.factory;

import org.example.enums.ElevatorMovementType;
import org.example.strategy.MovementStrategy;
import org.example.strategy.NearestMovementStrategy;

public class ElevatorMovementFactory {
    public static MovementStrategy create(ElevatorMovementType type){
        return switch (type){
            case ElevatorMovementType.NEARESET -> new NearestMovementStrategy();
            default -> throw  new IllegalArgumentException("Please select the provided type only");
        };

    }
}
