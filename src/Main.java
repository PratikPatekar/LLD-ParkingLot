import controllers.TicketController;
import dtos.CreateTicketRequestDto;
import dtos.CreateTicketResponseDto;
import repositories.ParkingLotRepository;
import repositories.ParkingSpotRepository;
import repositories.TicketRepository;
import services.TicketService;
import strategies.spotassignment.RandomSpotAssignmentStrategy;
import strategies.spotassignment.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        // Create objects in topological order.
        // Store those objects at some place.
        // Run Application.
        // Whenever an object of a class is needed, fetch from X(where object is stored i.e. Registry) and use it.

        //Registry Object
        ObjectRegistry objectRegistry = new ObjectRegistry();

        objectRegistry.register("parkingLotRepository",new ParkingLotRepository());
        objectRegistry.register("parkingSpotRepository",new ParkingSpotRepository());
        objectRegistry.register("ticketRepository",new TicketRepository());

        objectRegistry.register("spotAssignmentStrategy",new RandomSpotAssignmentStrategy());

        objectRegistry.register(
                "ticketService",
                new TicketService(
                        (TicketRepository) objectRegistry.get("ticketRepository"),
                        (SpotAssignmentStrategy) objectRegistry.get("spotAssignmentStrategy"),
                        (ParkingLotRepository) objectRegistry.get("parkingLotRepository"),
                        (ParkingSpotRepository) objectRegistry.get("parkingSpotRepository")
                )
        );
        objectRegistry.register(
                "ticketController",
                new TicketController(
                        (TicketService) objectRegistry.get("ticketService")
                )
        );

        CreateTicketRequestDto request = new CreateTicketRequestDto();
        request.setGate(null);
        request.setVehicle(null);

        CreateTicketResponseDto response = ((TicketController)objectRegistry.get("ticketController")).createTicket(request);

        System.out.println("Welcome to the Parking Lot!");
    }
}