package org.example.models.Vehicle;

import org.example.enums.VehicleType;

public class BikeVehicle extends  Vehicle{

    public  BikeVehicle(String reg_no){
        super(reg_no, VehicleType.BIKE);
    }

}
