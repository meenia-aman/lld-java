package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Building {
    private String id;
    private List<Floor> floors;
    private  List<Elevator> elevators;

    public Building(){
        this.id = UUID.randomUUID().toString();
        floors = new ArrayList<>();
        elevators = new ArrayList<>();
    }

    public  void addFloor(Floor floor){
        System.out.println("Adding Floor "+floor.getFloorId());
        floors.add(floor);
    }

public     void addElevator(Elevator elevator){
        elevators.add(elevator);
    }

    public  List<Elevator> getElevators(){
        return this.elevators;
    }

    public  List<Floor> getFloors(){
        return this.floors;
    }

    public  Elevator getElevatorById(String elevatorId){
        for(Elevator it:elevators){
            if(it.getId()==elevatorId){
                return  it;
            }
        }
        return null;
    }

    public String getId(){

        return  this.id;
    }
}
