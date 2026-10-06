package org.example.models.Gate;

import org.example.models.Vehicle.Vehicle;
import org.example.models.ticket.Ticket;
import org.example.service.ParkingLotService;

public class EntryGate {

    private final ParkingLotService parkingLotService;

    public  EntryGate(ParkingLotService parkingLotService){
       this.parkingLotService = parkingLotService;
    }

        public Ticket parkVehicle(Vehicle vehicle){
       return parkingLotService.parkVehicle(vehicle);
    }

}

