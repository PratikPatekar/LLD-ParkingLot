package strategies.spotassignment;

import models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(parkingSpot.getStatus().equals(ParkingSpotStatus.AVAILABLE)
                        && parkingSpot.getSupportedTypes().contains(vehicleType)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
