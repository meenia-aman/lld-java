package org.example.service;

import com.sun.security.jgss.GSSUtil;
import org.example.enums.PaymentType;
import org.example.enums.PricingStrategyType;
import org.example.models.Vehicle.Vehicle;
import org.example.models.parkingBuilding.ParkingBuilding;
import org.example.models.parkingSlot.ParkingSlot;
import org.example.models.ticket.Ticket;
import org.example.models.transaction.Transaction;

public class ParkingLotService {
    private  PaymentService paymentService;
    private TicketService ticketService;
    private ParkingBuilding parkingBuilding;
    private SlotAllocationService slotAllocationService;
    private  PricingService pricingService;


    public  ParkingLotService(PaymentService paymentService, TicketService ticketService,
                              ParkingBuilding parkingBuilding,SlotAllocationService slotAllocationService,
                              PricingService pricingService){
        this.paymentService = paymentService;
        this.ticketService = ticketService;
        this.parkingBuilding = parkingBuilding;
        this.slotAllocationService = slotAllocationService;
        this.pricingService = pricingService;
    }

    public  Ticket parkVehicle(Vehicle vehicle){

        ParkingSlot slot = slotAllocationService.getVaccantSpot(vehicle.getType(),parkingBuilding);
        if(slot==null) {
            System.out.println("No spot available");
            return null;
        }

       Ticket ticket =  ticketService.createTicket(vehicle,slot.getId());

        slot.parkVehicle(vehicle);

        System.out.println(" ============== Parking Vehicle ============");
        System.out.println(" Parking vehicle of type "+vehicle.getType()+" with reg_no "+vehicle.getReg_no() +" at spot "+slot.getId());

        return ticket;
    }


public  Vehicle unparkVehicle(String ticketId, PaymentType paymentType, PricingStrategyType parkingStrategyType){

        Ticket ticket = ticketService.getTicketById(ticketId);


        if(ticket==null || !ticket.isValid()){
            System.out.println("Invalid ticketId");
            return null;
        }

    System.out.println("Ticket "+ticket.getId() + "payemnt type "+paymentType);


        int slotId = ticket.getSlotId();

        ParkingSlot slot = parkingBuilding.getSlotById(slotId);

        if (slot.getVehicle()==null) {
            System.out. println("No vehicle found at slot "+slotId);
            return null;
        }

        double parkingFee = pricingService.getTotalPrice(slot.getVehicle().getType(),ticket,parkingStrategyType);


        Transaction transaction = paymentService.createTransaction(ticketId,parkingFee,paymentType);
    System.out.println("Payment Type "+transaction.getPaymentType());
         paymentService.makePayment(transaction.getId());


        slot.unparkVehicle();

        System.out.println("Successfully unpark the vehicle "+slot.getVehicle().getReg_no());
        System.out.println(" ================ Unparked Successfully ==============");
        System.out.println();
        return slot.getVehicle();

    }


}
