package org.example.models.Vehicle;

import org.example.enums.VehicleType;

public class Vehicle {
    final private String reg_no;
    final private VehicleType type;

   public Vehicle(String reg_no, VehicleType type){
        this.reg_no = reg_no ;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getReg_no() {
        return reg_no;
    }
}
