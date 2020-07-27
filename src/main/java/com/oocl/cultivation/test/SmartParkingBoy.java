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
        return null;
    }

    public String getMaxRestCapacity(Map<ParkLot, String> parkLotRestCapacity) {
        if (parkLotRestCapacity == null) {
            return null;
        }
        int length = parkLotRestCapacity.size();
        Collection<String> c = parkLotRestCapacity.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return (String) (obj[length - 1]);
    }


    @Override
    public String isContainsCapacity() {
        return super.isContainsCapacity();
    }
}
