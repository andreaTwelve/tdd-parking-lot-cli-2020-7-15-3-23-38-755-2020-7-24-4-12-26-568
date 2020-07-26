package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkBoy {
    private ParkLot parkLot;
    //private Map<ParkLot, Integer> parkLotMessage = new HashMap<>();
    private List<ParkLot> parkLots = new ArrayList<>();

    public ParkBoy(ParkLot parkLot) {
        this.parkLot = parkLot;
        this.parkLots.add(parkLot);
    }

    public ParkBoy(List<ParkLot> parkLots) {
        this.parkLots = parkLots;
    }

    public Object park(Car car){
        Object isParkSuccess = null;
        int restCapacity = 0;
        for (int i = 0; i < parkLots.size(); i++) {
            ParkLot parkLot = parkLots.get(i);
            //restCapacity = parkLot.getCapacity();
            if (parkLot.isContainsCapacity() == null) {
                if (parkLots.size() > 1) {
                    parkLot.park(car);
                    isParkSuccess = String.format("the car is parked in the parkingLot %d and has %d rest capacity", i + 1, parkLot.getCapacity() - parkLot.getParkingRoom().size());
                    break;
                } else {
                    isParkSuccess = parkLot.park(car);
                }
            } else {
                isParkSuccess = parkLot.isContainsCapacity();
                continue;
            }
        }
        return isParkSuccess;
    }

    public Car fetch(CarTicket carTicket) {
        return parkLot.fetch(carTicket);
    }

    public String checkTicket(CarTicket carTicket) {
        return parkLot.checkTicket(carTicket);
    }

    public String isContainsCapacity() {
        return parkLot.isContainsCapacity();
    }
}
