package com.oocl.cultivation.test;

import java.util.*;

public class SmartParkingBoy extends ParkBoy {
    private List<ParkLot> parkLots;
    private Map<ParkLot, String> parkLotRestCapacity = new HashMap<>();

    public SmartParkingBoy(List<ParkLot> parkLots) {
        super(parkLots);
        this.parkLots = parkLots;
        for (ParkLot parkLot: parkLots) {
            parkLotRestCapacity.put(parkLot, String.valueOf(parkLot.getCapacity()));
        }
    }

    public CarTicket park(Car car) throws Exception {
        List<Integer> restCapacity = new ArrayList<>();
        for (ParkLot parkLot: parkLots) {
            restCapacity.add(parkLot.getRestCapacity());
        }
        int maxRestCapacity = Collections.max(restCapacity);
        ParkLot parkLot = parkLots.stream().filter(parkLot1 -> maxRestCapacity == parkLot1.getRestCapacity()).findFirst().get();
        return parkLot.park(car);
    }


    @Override
    public String isContainsCapacity() {
        return super.isContainsCapacity();
    }
}
