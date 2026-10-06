package org.example.service;

import org.example.enums.VehicleType;
import org.example.models.Vehicle.Vehicle;
import org.example.models.parkingBuilding.ParkingBuilding;
import org.example.models.parkingSlot.ParkingSlot;
import org.example.strategy.slotAllocationStrategy.SlotAllocationStrategy;

public class SlotAllocationService
{
    private SlotAllocationStrategy slotAllocationStrategy;

    public SlotAllocationService(SlotAllocationStrategy slotAllocationStrategy){
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public ParkingSlot getVaccantSpot(VehicleType type, ParkingBuilding parkingBuilding){
       return slotAllocationStrategy.getVaccantSlot(type,parkingBuilding) ;
    }

}
