package org.example.repository.repoInterface;

import org.example.models.ticket.Ticket;

public interface TicketRepository {
    Ticket getTicketById(String id);
    void createTicket(Ticket ticket);
    void updateTicket(Ticket ticket);

}
