package controllers;

import dtos.CreateParkingFloorRequestDto;
import dtos.CreateParkingLotRequestDto;
import dtos.CreateParkingLotResponseDto;
import models.ParkingFloor;
import models.ParkingLot;
import services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }
    public CreateParkingLotResponseDto createParkingLot(CreateParkingLotRequestDto request){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(request.getName());
        parkingLot.setAddress(request.getAddress());
        parkingLot.setGates(request.getGates());
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i=0;i< request.getNumOfFloors();i++){
            parkingFloors.add(new ParkingFloor());
        }
        parkingLot.setParkingFloors(parkingFloors);
        ParkingLot createdParkingLot = parkingLotService.createParkingLot(parkingLot);

        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        response.setParkingLot(createdParkingLot);
        return response;
    }
}
