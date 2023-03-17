package services;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingLotStatus;
import repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    public ParkingLot createParkingLot(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }
}
