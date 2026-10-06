package org.example.strategy.slotAllocationStrategy;

import org.example.enums.SlotAllocationType;
import org.example.enums.VehicleType;
import org.example.models.parkingBuilding.ParkingBuilding;
import org.example.models.parkingSlot.ParkingSlot;

public interface SlotAllocationStrategy {

    ParkingSlot getVaccantSlot(VehicleType type , ParkingBuilding parkingBuilding);
    SlotAllocationType getType();

}
