package repositories;

import models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloors = new HashMap<>();
    private int lastCount = 0;
    public ParkingFloor save(ParkingFloor parkingFloor){
        lastCount+=1;
        parkingFloors.put(lastCount,parkingFloor);
        return parkingFloor;
    }
}
