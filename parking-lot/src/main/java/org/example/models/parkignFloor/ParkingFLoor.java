package org.example.models.parkignFloor;

import org.example.models.parkingSlot.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFLoor {
    private int id;
    private List<ParkingSlot> slots;

   public ParkingFLoor(int id){
        this.id = id;
        slots = new ArrayList<>();
    }

    public void add(ParkingSlot slot){
           this.slots.add(slot);
    }

    public List<ParkingSlot> getSlots(){
       return this.slots;
    }

    public  int getFLoorId(){
      return this.id;
    }

    public  ParkingSlot getSlotById(int id){
      for (ParkingSlot it:this.slots){
          if(it.getId()==id){
              return it;
          }
      }
      return null;
    }

    public  List<ParkingSlot> getAllSlots(){
       return this.slots;
    }

}
