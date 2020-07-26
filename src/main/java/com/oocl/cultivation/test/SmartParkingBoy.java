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

    public Object park(Car car) {
        Object isParkSuccess = null;
        for (int i = 0; i< parkLots.size(); i++) {
            ParkLot parkLot = parkLots.get(i);
            int restCapacity = parkLot.getCapacity() - parkLot.getParkingRoom().size();
            if (parkLots.size() == 1) {
                isParkSuccess = parkLot.park(car);
            }
            if (restCapacity == 0 && i == parkLots.size() - 1) {
                isParkSuccess = isContainsCapacity();
                break;
            }
            if (restCapacity == Integer.parseInt(getMaxRestCapacity(parkLotRestCapacity))) {
                parkLot.park(car);
                parkLotRestCapacity.put(parkLot, String.valueOf(restCapacity - 1));
                isParkSuccess = String.format("the car is parked in the parkingLot %d and has %d rest capacity", i + 1, restCapacity - 1);
                break;
            }
        }
        return isParkSuccess;
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
    public String checkTicket(CarTicket carTicket) {
        return super.checkTicket(carTicket);
    }

    @Override
    public String isContainsCapacity() {
        return super.isContainsCapacity();
    }
}
