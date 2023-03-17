package services;

import models.ParkingFloor;
import models.ParkingLot;
import repositories.ParkingFloorRepository;
import repositories.ParkingLotRepository;

import java.util.List;

public class ParkingFloorService {
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    public ParkingFloorService(ParkingFloorRepository parkingFloorRepository,ParkingLotRepository parkingLotRepository){
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
    }
    public ParkingFloor createParkingFloor(ParkingFloor parkingFloor,int parkingLotId){
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        parkingFloors.add(parkingFloor);
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.update(parkingLot,parkingLotId);
        return parkingFloorRepository.save(parkingFloor);
    }
}
