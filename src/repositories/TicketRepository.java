package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    // Storing tickets in-memory using some data structure for this project and will be implementing real db in the next project
    private Map<Integer,Ticket> tickets = new HashMap<>();
    private int lastIdCount = 0;
    public Ticket save(Ticket ticket){
        ticket.setId(lastIdCount+1);
        lastIdCount+=1;
        tickets.put(lastIdCount,ticket);
        return ticket;
    }
}
