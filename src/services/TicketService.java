package services;

import models.*;
import repositories.ParkingLotRepository;
import repositories.ParkingSpotRepository;
import repositories.TicketRepository;
import strategies.spotassignment.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;
    public TicketService(TicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository,
                         ParkingSpotRepository parkingSpotRepository){
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }
    public Ticket createTicket(Vehicle vehicle, Gate gate){
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLotRepository.getParkingLotForGate(gate),vehicle.getVehicleType());
        parkingSpot.setStatus(ParkingSpotStatus.FILLED);
        parkingSpotRepository.save(parkingSpot);
        ticket.setParkingSpot(parkingSpot);
        return ticketRepository.save(ticket);
    }
}
