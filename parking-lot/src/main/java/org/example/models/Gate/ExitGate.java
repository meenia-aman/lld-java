package org.example.models.Gate;

import org.example.enums.PaymentType;
import org.example.enums.PricingStrategyType;
import org.example.models.Vehicle.Vehicle;
import org.example.service.ParkingLotService;


public class ExitGate {
    private  final ParkingLotService parkingLotService;

    public  ExitGate(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }

    public Vehicle unparkVehicle(String ticketId, PaymentType paymentType , PricingStrategyType pricingStrategyType){
        return parkingLotService.unparkVehicle(ticketId,paymentType,pricingStrategyType);
    }

}

