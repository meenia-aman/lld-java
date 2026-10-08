package org.example.models;

import org.example.enums.Direction;
import org.example.enums.DoorState;
import org.example.enums.ElevatorStateType;
import org.example.state.*;
import org.example.strategy.MovementStrategy;
import org.example.strategy.NearestMovementStrategy;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Elevator {
    private  final String id;
    private ElevatorStateType elevatorStateType;
    private int currentFloor;
    private Request currentRequest;
    private List<Request> pendingRequest = new ArrayList<>();
    private MovementStrategy movementStrategy;
    private DoorState doorState = DoorState.CLOSE;
    private Direction direction;
    private ElevatorState elevatorState;
    public InternalPannel internalPannel;


    public Elevator() {
        this.id = UUID.randomUUID().toString();
        currentFloor = 1;
        setElevatorState(ElevatorStateType.IDLE);
        this.movementStrategy = new NearestMovementStrategy();
    }

    public void setInternalPannel(InternalPannel internalPannel) {
        this.internalPannel = internalPannel;
    }

    public InternalPannel getInernalPannel(){
        return this.internalPannel;
    }
    public void moveOneStepUp(){
        System.out.println("Moving UP by 1 step form Floor "+currentFloor + " to "+(currentFloor+1));
        this.currentFloor+=1;
    }
    public void moveOneStepDown(){
        System.out.println("Moving Down by 1 step from Floor " +currentFloor + " to "+(currentFloor-1));
        this.currentFloor-=1;
    }

    public Request getNextRequest(){
        if(currentRequest!=null) return currentRequest;
        Request request = movementStrategy.getNextRequest(pendingRequest,this.currentFloor);
        this.currentRequest = request;
        removePendingRequest(request.getId());

        return currentRequest;
    }

    void removePendingRequest(String id){

        for (int i=0; i<pendingRequest.size(); i++){
            if(pendingRequest.get(i).getId()==id){
                pendingRequest.remove(i);
                break;
            }
        }

    }


    // This function will run every second
    public  void getTick(){
        this.handleTick();
    }

    public ElevatorStateType geteLevatorState() {
        return elevatorStateType;
    }

    public void setElevatorState(ElevatorStateType elevatorStateType) {
        this.elevatorStateType = elevatorStateType;
        if(elevatorStateType==ElevatorStateType.IDLE){
            elevatorState = new ElevatorIdleState();
        }else if(elevatorStateType==ElevatorStateType.OPEN_DOOR){
            elevatorState = new ElevatorDoorOpenState();
        }else if(elevatorStateType==ElevatorStateType.MOVING){
            elevatorState = new ElevatorMovingState();
        }else {
            elevatorState = new ElevatorMaintanceState();
        }
    }

    public void handleTick(){
        elevatorState.handleTick(this);
    }

    public  void openDoor(){
        elevatorState.openDoor(this);
    }
    public void closeDoor(){
        elevatorState.closeDoor(this);
    }

    public void  enterMaintenanceMode(){
        elevatorState.enterMaintenance(this);
    }
    public void exiteMaintenanceMode(){
        elevatorState.exitMaintenance(this);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Request getCurrentRequest() {
        return currentRequest;
    }


    public List<Request> getPendingRequest() {
        return pendingRequest;
    }

    public void addPendingRequest(Request pendingRequest) {
        System.out.println("Elevator "+this.getId() +" got new request to floor "+pendingRequest.getDestinationFloor());
        this.pendingRequest.add(pendingRequest);

    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public String getId() {
        return id;
    }
    public void setDoorState(DoorState state){
        this.doorState = state;
    }
    public  DoorState getDoorState(){
        return this.doorState;
    }

    public Direction getDirection() {
        return direction;
    }
    public  void setDirection(Direction direction){
        this.direction = direction;
    }
    public  void completeCurrentRequest(){
        if(this.currentRequest!=null){
            System.out.println(" Request "+currentRequest.getId() + " completed successfully");
            this.currentRequest = null;
        }
    }
}
