package org.example.state;

import org.example.enums.ElevatorStateType;
import org.example.models.Elevator;

public class ElevatorMaintanceState implements  ElevatorState{
    @Override
    public void handleTick(Elevator elevator) {
    }

    @Override
    public void openDoor(Elevator elevator) {
    }

    @Override
    public void closeDoor(Elevator elevator) {

    }

    @Override
    public ElevatorStateType getState() {
        return ElevatorStateType.MAINTENANCE;
    }

    @Override
    public void exitMaintenance(Elevator elevator) {
        System.out.println("Exiting Maintenance Mode");
        elevator.setElevatorState(ElevatorStateType.IDLE);

    }

    @Override
    public void enterMaintenance(Elevator elevator) {
        System.out.println("Already in maintenance mode");

    }
}
