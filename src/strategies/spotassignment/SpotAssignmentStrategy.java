package strategies.spotassignment;

import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
