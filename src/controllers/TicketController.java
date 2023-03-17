package controllers;

import dtos.CreateTicketRequestDto;
import dtos.CreateTicketResponseDto;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public CreateTicketResponseDto createTicket(CreateTicketRequestDto request){
        Ticket ticket = ticketService.createTicket(request.getVehicle(),request.getGate());
        CreateTicketResponseDto response = new CreateTicketResponseDto();
        response.setTicket(ticket);
        return response;
    }
}
