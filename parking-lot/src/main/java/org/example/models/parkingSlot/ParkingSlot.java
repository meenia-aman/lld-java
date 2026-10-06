package org.example.models.parkingSlot;

import org.example.enums.ParkingSlotStatus;
import org.example.enums.ParkingSlotType;
import org.example.enums.VehicleType;
import org.example.models.Vehicle.Vehicle;

import javax.swing.tree.VariableHeightLayoutCache;

public class ParkingSlot {
    private int id;
    private ParkingSlotType type;
    private ParkingSlotStatus status;
    private Vehicle vehicle=null;

    public  ParkingSlot(int id, ParkingSlotType type){
        this.id = id;
        this.type = type;
        this.status= ParkingSlotStatus.AVAILABLE;
    }

    // TODO: We can do this thing in better way that just hardcoding this stuff
    public boolean canAccomondate(VehicleType vehicleType){
        if(vehicleType==VehicleType.BIKE && type==ParkingSlotType.SMALL){
            return true;
        }else if (vehicleType==VehicleType.CAR && type == ParkingSlotType.MEDIUM){
            return true;
        }else if (vehicleType ==VehicleType.BUS && type ==ParkingSlotType.LARGE){
            return true;
        }
        return false;
    }

    public  boolean isAvailable(){
        return this.status==ParkingSlotStatus.AVAILABLE;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(canAccomondate(vehicle.getType()) && isAvailable()){
            this.vehicle = vehicle;
            this.status = ParkingSlotStatus.OCCUPIED;
            return true;
        }
        return false;
    }

    public boolean unparkVehicle(){
        if(this.status==ParkingSlotStatus.OCCUPIED){
            return true;
        }
        return false;
    }

    public int getId(){
        return this.id;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public  ParkingSlotType getType(){
        return this.type;
    }


}
