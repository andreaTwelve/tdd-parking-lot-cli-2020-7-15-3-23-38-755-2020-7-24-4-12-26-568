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
