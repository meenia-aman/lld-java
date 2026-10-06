package org.example.models.parkingBuilding;

import org.example.models.parkignFloor.ParkingFLoor;
import org.example.models.parkingSlot.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBuilding {
    private String id;
    private List<ParkingFLoor> floors;


    public ParkingBuilding(String id) {
        this.id = id;
        floors = new ArrayList<>();
    }

    public void addFloor(ParkingFLoor floor) {
        floors.add(floor);
    }

    public String getId() {
        return id;
    }

    public List<ParkingFLoor> getAllFloors() {
        return this.floors;
    }

    public ParkingSlot getSlotById(int id) {
        for (ParkingFLoor it : floors) {
            ParkingSlot slot = it.getSlotById(id);
            if (slot != null) return slot;
        }
        return null;
    }


}
