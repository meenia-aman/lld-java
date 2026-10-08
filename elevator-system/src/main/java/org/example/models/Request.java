package org.example.models;

import org.example.enums.RequestType;

import java.util.UUID;

public class Request {
    private final String id;
    private final String buildingId;
    private final  int sourceFloor;
    private int destinationFloor;
    private Elevator assignedElevator;
    private RequestType requestType;

    public Request(String buildingId, int sourceFloor, RequestType type,int destinationFloor) {
        this.id = UUID.randomUUID().toString();
        this.buildingId = buildingId;
        this.sourceFloor = sourceFloor;
        this.requestType = type;
        this.destinationFloor = destinationFloor;

    }

    public String getId() {
        return id;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public Elevator getAssignedElevator() {
        return assignedElevator;
    }

    public void setAssignedElevator(Elevator assignedElevator) {
        this.assignedElevator = assignedElevator;
    }

    public RequestType getRequestType(){
        return this.requestType;
    }
}
