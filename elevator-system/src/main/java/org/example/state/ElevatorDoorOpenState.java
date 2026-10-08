package org.example.state;

import org.example.enums.DoorState;
import org.example.enums.ElevatorStateType;
import org.example.models.Elevator;

public class ElevatorDoorOpenState implements ElevatorState{
    @Override
    public void handleTick(Elevator elevator) {
        System.out.println("Elevatro "+elevator.getId() + " doors closing after passenger picup/dorpoff");
        this.closeDoor(elevator);
        elevator.completeCurrentRequest();
        elevator.setElevatorState(ElevatorStateType.IDLE);
    }

    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("Door is already open");
    }

    @Override
    public void enterMaintenance(Elevator elevator) {
        System.out.println("Can't enter into Maintenance mode from Door Open State");
    }

    @Override
    public void exitMaintenance(Elevator elevator) {
        System.out.println("Exit Maintenance only works in Maintenance Mode");
    }

    @Override
    public ElevatorStateType getState() {
        return ElevatorStateType.OPEN_DOOR;
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Closing elevator door ");
        elevator.setDoorState(DoorState.CLOSE);
        elevator.setElevatorState(ElevatorStateType.IDLE);
    }
}
