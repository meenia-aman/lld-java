package org.example.service;

import org.example.enums.ElevatorAllocationStrategyType;
import org.example.factory.ElevatorAllocationFactory;
import org.example.models.Elevator;
import org.example.models.Request;
import org.example.strategy.ElevatorAllocationStrategey;

import java.util.List;

public class ElevatorDispatcher {


    Elevator getElevator(Request request, List<Elevator> elevatorList, ElevatorAllocationStrategyType type){

        ElevatorAllocationStrategey elevatorAllocationStrategey = ElevatorAllocationFactory.create(type);

     return   elevatorAllocationStrategey.selectElevator(request,elevatorList);

    }

}
