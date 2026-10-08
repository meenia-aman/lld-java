package org.example.service;

import org.example.enums.ElevatorAllocationStrategyType;
import org.example.enums.RequestType;
import org.example.models.Elevator;
import org.example.models.Request;

import java.util.List;

public class RequestService {
    private  ElevatorDispatcher elevatorDispatcher;

public     RequestService(){
        elevatorDispatcher = new ElevatorDispatcher();
    }

    Request createExternalRequest(String buildingId, int currentFloor, List<Elevator> elevators, ElevatorAllocationStrategyType type){
       Request request = new Request(buildingId,currentFloor, RequestType.EXTERNAL_PANNEL,currentFloor);
        Elevator assignedElevator= elevatorDispatcher.getElevator(request,elevators,type);
        if(assignedElevator==null) {
            System.out.println("No Elevator available at a moment");
            return null;
        }
        request.setAssignedElevator(assignedElevator);
        System.out.println("RequestId "+request.getId() + " BuildingId "+request.getBuildingId()+" CurrentFloor "+request.getSourceFloor() +" Elevator "+assignedElevator.getId());
        return request;
    }

    Request createInternalRequest(Elevator elevator,String buildingId , int destinationFloor){
    Request request = new Request(buildingId,elevator.getCurrentFloor(),RequestType.INTERNAL_PANNEL,destinationFloor);
    request.setAssignedElevator(elevator);
    System.out.println("RequestId "+request.getId() + " BuildingId "+request.getBuildingId()+" CurrentFloor "+request.getSourceFloor() +" Elevator "+elevator.getId());
    return request;
    }
}
