package org.example.state;

import org.example.enums.Direction;
import org.example.enums.ElevatorStateType;
import org.example.models.Elevator;
import org.example.models.Request;

public class ElevatorMovingState implements ElevatorState{
    @Override
    public void handleTick(Elevator elevator) {

        Request request = elevator.getCurrentRequest();

        if(request==null){
            elevator.setElevatorState(ElevatorStateType.IDLE);
            return;
        }
            if(elevator.getDirection()== Direction.DOWN){
                elevator.moveOneStepDown();
            }else if(elevator.getDirection()==Direction.UP){
                elevator.moveOneStepUp();
            }

            if(elevator.getCurrentFloor()==request.getDestinationFloor()){
                System.out.println(" Elevator "+elevator.getId() + " reached destination floor "+request.getDestinationFloor());
                elevator.setElevatorState(ElevatorStateType.IDLE);
            }

    }

    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("Can't open door while Elevator in Moving State");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Door already closed");
    }

    @Override
    public void enterMaintenance(Elevator elevator) {
        System.out.println("Can't enter maintenance mode while elevator in Moving State");
    }

    @Override
    public void exitMaintenance(Elevator elevator) {
        System.out.println("Exit Maintenance not works in Moving State");
    }

    @Override
    public ElevatorStateType getState() {
        return ElevatorStateType.MOVING;
    }


}
