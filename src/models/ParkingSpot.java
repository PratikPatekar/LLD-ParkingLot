package models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private List<VehicleType> supportedTypes;
    private ParkingSpotStatus status;
    private ParkingFloor parkingFloor;
    public ParkingSpot(){
        this.status = ParkingSpotStatus.AVAILABLE;
    }

    public List<VehicleType> getSupportedTypes() {
        return supportedTypes;
    }

    public void setSupportedTypes(List<VehicleType> supportedTypes) {
        this.supportedTypes = supportedTypes;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
