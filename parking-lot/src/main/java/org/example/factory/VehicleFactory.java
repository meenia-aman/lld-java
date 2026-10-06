package org.example.factory;

import org.example.enums.VehicleType;
import org.example.models.Vehicle.BikeVehicle;
import org.example.models.Vehicle.BusVehicle;
import org.example.models.Vehicle.CarVehicle;
import org.example.models.Vehicle.Vehicle;

public class VehicleFactory {

public static Vehicle createVehicle(String reg_no, VehicleType type){

    return switch (type) {
        case VehicleType.BIKE -> new BikeVehicle(reg_no);
        case VehicleType.CAR -> new CarVehicle(reg_no);
        case VehicleType.BUS -> new BusVehicle(reg_no);
        default -> throw new IllegalArgumentException(
                "Please select the valid Vehicle type"
        );
    };

    }
}
