package controllers;

import dtos.CreateParkingFloorRequestDto;
import dtos.CreateParkingFloorResponseDto;
import models.ParkingFloor;
import models.ParkingSpot;
import services.ParkingFloorService;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloorController {
    private ParkingFloorService parkingFloorService;

    public ParkingFloorController(ParkingFloorService parkingFloorService){
        this.parkingFloorService = parkingFloorService;
    }

    public CreateParkingFloorResponseDto createParkingFloor(CreateParkingFloorRequestDto request){
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber(request.getFloorNumber());
        int numberOfSpots = request.getNumberOfSpots();
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for(int i=0;i<numberOfSpots;i++){
            parkingSpots.add(new ParkingSpot());
        }
        parkingFloor.setParkingSpots(parkingSpots);
        ParkingFloor createdParkingFloor = parkingFloorService.createParkingFloor(parkingFloor,request.getParkingLotId());

        CreateParkingFloorResponseDto response = new CreateParkingFloorResponseDto();
        response.setParkingFloor(createdParkingFloor);
        return response;
    }
}
