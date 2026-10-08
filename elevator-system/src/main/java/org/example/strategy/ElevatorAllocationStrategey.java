package org.example.strategy;

import org.example.models.Elevator;
import org.example.models.Request;

import java.util.List;

public interface ElevatorAllocationStrategey {
    Elevator selectElevator(Request request, List<Elevator> elevators);
}
