package org.example;

import org.example.enums.ParkingSlotType;
import org.example.enums.PaymentType;
import org.example.enums.PricingStrategyType;
import org.example.enums.VehicleType;
import org.example.factory.VehicleFactory;
import org.example.models.Gate.EntryGate;
import org.example.models.Gate.ExitGate;
import org.example.models.Vehicle.Vehicle;
import org.example.models.parkignFloor.ParkingFLoor;
import org.example.models.parkingBuilding.ParkingBuilding;
import org.example.models.parkingSlot.ParkingSlot;
import org.example.models.ticket.Ticket;
import org.example.repository.repoImplementation.InMemoryPaymentRepository;
import org.example.repository.repoImplementation.InMemoryTicketRepository;
import org.example.repository.repoInterface.PaymentRepository;
import org.example.repository.repoInterface.TicketRepository;
import org.example.service.*;
import org.example.strategy.pricingStrategy.HourlyPricingStrategy;
import org.example.strategy.pricingStrategy.PricingStrategy;
import org.example.strategy.slotAllocationStrategy.FirstEmptySlotStrategy;
import org.example.strategy.slotAllocationStrategy.SlotAllocationStrategy;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        // Creating Parking Building
        ParkingBuilding parkingBuilding = new ParkingBuilding("Aman-Parking-Lot");

        // Creating the multiple parking floors for the building
        ParkingFLoor istFloor = new ParkingFLoor(1);
        ParkingFLoor secondFloor = new ParkingFLoor(2);
        ParkingFLoor thirdFloor = new ParkingFLoor(3);

        // Creating parking slots for floors

        ParkingSlot slot1 = new ParkingSlot(1, ParkingSlotType.SMALL);
        ParkingSlot slot2 = new ParkingSlot(2,ParkingSlotType.MEDIUM);

        istFloor.add(slot1);
        istFloor.add(slot2);

        parkingBuilding.addFloor(istFloor);


        PaymentRepository paymentRepository = new InMemoryPaymentRepository();

        PaymentService paymentService = new PaymentService(paymentRepository);


        TicketRepository ticketRepository = new InMemoryTicketRepository();

        TicketService ticketService = new TicketService(ticketRepository);


        PricingStrategy pricingStrategy = new HourlyPricingStrategy();
        SlotAllocationStrategy slotAllocationStrategy = new FirstEmptySlotStrategy();
        SlotAllocationService slotAllocationService = new SlotAllocationService(slotAllocationStrategy);


        PricingService pricingService = new PricingService();


        ParkingLotService parkingLotService = new ParkingLotService(paymentService,ticketService,parkingBuilding,slotAllocationService,pricingService);
        EntryGate entryGate = new EntryGate(parkingLotService);
        ExitGate exitGate = new ExitGate(parkingLotService);


        Vehicle vehicle1  = VehicleFactory.createVehicle("Jk-02", VehicleType.BIKE);
        Vehicle vehicle2  = VehicleFactory.createVehicle("Jk-03", VehicleType.CAR);
        Vehicle vehicle3  = VehicleFactory.createVehicle("Jk-04", VehicleType.BIKE);

       Ticket ticket =  entryGate.parkVehicle(vehicle1);
        Ticket ticket2 =  entryGate.parkVehicle(vehicle2);
        Ticket ticket3 =  entryGate.parkVehicle(vehicle3);

        Vehicle vehicle = exitGate.unparkVehicle(ticket.getId(),PaymentType.UPI, PricingStrategyType.HourlyPricingStrategy);

        if(vehicle!=null){
            System.out.println("Vehicle reg_no "+vehicle.getReg_no());
        }


//        List<ParkingSlot> slots = istFloor.getAllSlots();
//
//
//        for(ParkingSlot it:slots){
//            System.out.println("Slot Id "+it.getId() + " Type "+ it.getType());
//        }



    }
}
