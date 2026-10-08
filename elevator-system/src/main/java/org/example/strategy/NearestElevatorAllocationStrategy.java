package org.example.strategy;

import org.example.models.Elevator;
import org.example.models.Request;

import java.util.List;

public class NearestElevatorAllocationStrategy implements ElevatorAllocationStrategey{
    @Override
    public Elevator selectElevator(Request request, List<Elevator> elevators) {
        Elevator assignedElevator;
        assignedElevator = null;
        for (Elevator it:elevators){
           if(assignedElevator==null) {
               assignedElevator = it;
           }else if(Math.abs(assignedElevator.getCurrentFloor()-request.getDestinationFloor())>
           Math.abs(it.getCurrentFloor()-request.getDestinationFloor())){
            assignedElevator = it;

           }
        }
        return assignedElevator;
    }
}
