package repositories;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer,ParkingLot> parkingLots = new HashMap<>();
    private int lastCount = 0;
    public ParkingLot getParkingLotForGate(Gate gate){
        return parkingLots.get(gate.getId());
    }
    public ParkingLot getById(int id){
        return parkingLots.get(id);
    }
    public ParkingLot save(ParkingLot parkingLot){
        lastCount+=1;
        parkingLot.setId(lastCount);
        parkingLots.put(lastCount,parkingLot);
        return parkingLot;
    }
    public ParkingLot update(ParkingLot parkingLot,int parkingLotId){
        parkingLots.put(parkingLotId,parkingLot);
        return parkingLots.get(parkingLotId);
    }
}
