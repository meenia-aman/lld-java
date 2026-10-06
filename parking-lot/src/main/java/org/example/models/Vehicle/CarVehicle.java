package org.example.models.Vehicle;

import org.example.enums.VehicleType;

public class CarVehicle extends Vehicle {

  public CarVehicle(String reg_no){
      super(reg_no,VehicleType.CAR);
    }

}
