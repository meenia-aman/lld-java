package org.example.models.Vehicle;


import org.example.enums.VehicleType;

public class BusVehicle extends Vehicle {

    public BusVehicle(String reg_no){
        super(reg_no, VehicleType.BUS);
    }
}
