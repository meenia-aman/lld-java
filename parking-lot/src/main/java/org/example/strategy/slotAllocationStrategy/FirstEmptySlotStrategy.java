package org.example.strategy.slotAllocationStrategy;

import org.example.enums.SlotAllocationType;
import org.example.enums.VehicleType;
import org.example.models.parkignFloor.ParkingFLoor;
import org.example.models.parkingBuilding.ParkingBuilding;
import org.example.models.parkingSlot.ParkingSlot;

import java.util.List;

public class FirstEmptySlotStrategy implements org.example.strategy.slotAllocationStrategy.SlotAllocationStrategy {

    @Override
    public ParkingSlot getVaccantSlot(VehicleType type, ParkingBuilding parkingBuilding) {

        List<ParkingFLoor> fLoors = parkingBuilding.getAllFloors();

        for(ParkingFLoor it:fLoors){
            List<ParkingSlot> parkingSlots = it.getAllSlots();
            for(ParkingSlot parkingSlot:parkingSlots){
                if(parkingSlot.canAccomondate(type) && parkingSlot.isAvailable()){
                    return parkingSlot;
                }

            }
        }
        return null;

    }

    @Override
    public SlotAllocationType getType() {
        return SlotAllocationType.FirstEmptySlotStrategy;
    }
}
