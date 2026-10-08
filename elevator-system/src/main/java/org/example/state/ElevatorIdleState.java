package org.example.state;

import org.example.enums.Direction;
import org.example.enums.DoorState;
import org.example.enums.ElevatorStateType;
import org.example.models.Elevator;
import org.example.models.Request;

import java.util.SortedMap;

public class ElevatorIdleState implements ElevatorState{
    @Override
    public void handleTick(Elevator elevator) {

        System.out.println("Handle Tick Idle state working");
        Request request;
        if(elevator.getCurrentRequest()==null) {


            if (elevator.getPendingRequest().isEmpty()) {
                return;
            }

            request = elevator.getNextRequest();
        }else{
            request = elevator.getCurrentRequest();
        }


        if(request==null) return;
        System.out.println("Request "+request.getDestinationFloor() + " Elevator "+elevator.getCurrentFloor());

        if(request.getDestinationFloor()==elevator.getCurrentFloor()){
            System.out.println("Elevator "+elevator.getId()+ "already at destination floor "+elevator.getCurrentFloor());
            elevator.openDoor();
            elevator.setElevatorState(ElevatorStateType.OPEN_DOOR);
        }else{
            if(request.getDestinationFloor()>elevator.getCurrentFloor()){
                elevator.setDirection(Direction.UP);
            }else {
                elevator.setDirection(Direction.DOWN);
            }
            elevator.setElevatorState(ElevatorStateType.MOVING);
        }

    }

    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("User clicks on Open Door in IDLE state");
        elevator.setDoorState(DoorState.OPEN);
        elevator.setElevatorState(ElevatorStateType.OPEN_DOOR);
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("You can't close door in the open state");
    }

    @Override
    public void enterMaintenance(Elevator elevator) {
        System.out.println("Entering into maintenance mode");
    }

    @Override
    public void exitMaintenance(Elevator elevator) {
        System.out.println("You can't exit maintenance mode in IDLE State");

    }

    @Override
    public ElevatorStateType getState() {
        return ElevatorStateType.IDLE;
    }
}
