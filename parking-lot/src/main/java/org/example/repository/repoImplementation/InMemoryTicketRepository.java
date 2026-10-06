package org.example.repository.repoImplementation;

import org.example.models.ticket.Ticket;
import org.example.repository.repoInterface.TicketRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTicketRepository implements TicketRepository {
    private Map<String,Ticket> tickets;

    public  InMemoryTicketRepository(){
        tickets = new HashMap<>();
    }


    @Override
    public void createTicket(Ticket ticket) {
        System.out.println("Create Ticket: Ticket id "+ticket.getId());
        tickets.put(ticket.getId(),ticket);
        System.out.println("Create ticket is working");
    }

    @Override
    public Ticket getTicketById(String id) {
        return tickets.getOrDefault(id,null);
    }

    @Override
    public  void updateTicket(Ticket ticket){
        tickets.put(ticket.getId(),ticket);
    }
}
