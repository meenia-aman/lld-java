package org.example.state;

import org.example.enums.ElevatorStateType;
import org.example.models.Elevator;

public interface ElevatorState {
    void handleTick(Elevator elevator);
    void openDoor(Elevator elevator);
    void closeDoor(Elevator elevator);
    void enterMaintenance(Elevator elevator);
    void exitMaintenance(Elevator elevator);
    ElevatorStateType getState();
}
