package org.example.service;

import org.example.models.Vehicle.Vehicle;
import org.example.models.ticket.Ticket;
import org.example.repository.repoInterface.TicketRepository;

public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    Ticket createTicket(Vehicle vehicle, int slotId ){
        Ticket t = new Ticket(vehicle,slotId);
        ticketRepository.createTicket(t);
        return t;
    }

    Ticket getTicketById(String ticketId){
       return ticketRepository.getTicketById(ticketId) ;
    }

    boolean makePayment(String ticketId){
        Ticket t = getTicketById(ticketId);
        if(t==null) return false;
       boolean paymentDone =  t.makePayment();
       if(!paymentDone) return false;
       ticketRepository.updateTicket(t);
        return true;
    }





}
