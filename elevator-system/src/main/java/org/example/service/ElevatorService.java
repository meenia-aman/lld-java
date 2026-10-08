package org.example.service;

import org.example.enums.Direction;
import org.example.enums.ElevatorAllocationStrategyType;
import org.example.models.*;
import org.example.state.ElevatorState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElevatorService {
    private List<Building> buildings;
    private  final RequestService requestService;
    private  SimulationEngine simulationEngine;

    public  ElevatorService(List<Building> buildings ){
        requestService = new RequestService();
        this.buildings = buildings;
        simulationEngine = new SimulationEngine(buildings);

        simulationEngine.startSimulation();
    }

    public void createInternalRequest(InternalPannel pannel, int destinationFloor){
       Request request =   requestService.createInternalRequest(pannel.getElevator(),pannel.getBuildingId(),destinationFloor);
        Elevator elevator = pannel.getElevator();
        elevator.addPendingRequest(request);
    }

    public void createExternalRequest(ExternalPannel pannel, Direction direction){
       String buildingId = pannel.getBuildingId();
       List<Elevator> elevators = this.getElevatorByBuilding(buildingId);
       Request request= requestService.createExternalRequest(pannel.getBuildingId(), pannel.getFloorId(),elevators, ElevatorAllocationStrategyType.NEAREST_ALLOCATION_STRATEGY);
       if(request!=null && request.getAssignedElevator()!=null){
           request.getAssignedElevator().addPendingRequest(request);

       }
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public  Building getBuildingById(String id){
        for(Building it:buildings){
            if(it.getId()==id){
                return it;
            }
        }
        return null;
    }

    public List<Elevator> getElevatorByBuilding(String id){
       Building building = this.getBuildingById(id) ;
       return building.getElevators();
    }

}
