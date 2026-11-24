package org.example.services;

import org.example.models.Booking;
import org.example.models.ShowSeat;
import org.example.models.Ticket;

import java.util.*;

public class TicketService {
    private Map<String, Ticket> tickets = new HashMap<>();

    public TicketService() {
    }


    public List<Ticket> generatTicket(Booking booking) {

        List<Ticket> ticketList = new ArrayList<>();
        for (ShowSeat showSeat : booking.getShowSeats()) {
            Ticket ticket = new Ticket(UUID.randomUUID().toString(), booking.getId(), booking.getShowId(), booking.getUserId());
            tickets.put(ticket.getId(), ticket);
            ticketList.add(ticket);
            System.out.println("Ticket generated " + ticket.getId() + " for booking " + ticket.getBookingId());
        }

        return ticketList;
    }

}
