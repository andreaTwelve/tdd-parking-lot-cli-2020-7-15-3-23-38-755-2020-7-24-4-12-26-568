package com.oocl.cultivation.test;

import java.util.*;

public class SuperSmartParkingBoy extends SmartParkingBoy {
    Map<ParkLot, String> parkLotPositionRate = new HashMap<>();
    private List<ParkLot> parkLots;
    public SuperSmartParkingBoy(List<ParkLot> parkLots) {
        super(parkLots);
        this.parkLots = parkLots;
        for (ParkLot parkLot: parkLots) {
            parkLotPositionRate.put(parkLot, "1");
        }
    }

    @Override
    public CarTicket park(Car car) throws Exception {
        Object isParkSuccess = null;
        for (int i = 0; i< parkLots.size(); i++) {
            ParkLot parkLot = parkLots.get(i);
            int restCapacity = parkLot.getCapacity() - parkLot.getParkingRoom().size();
            double positionRate = (double)restCapacity / (double)parkLot.getCapacity();
            if (parkLots.size() == 1) {
                isParkSuccess = parkLot.park(car);
                break;
            }
            if (restCapacity == 0 && i == parkLots.size() - 1) {
                isParkSuccess = parkLot.isContainsCapacity();
                break;
            }
            if (restCapacity > 0 && positionRate == Double.parseDouble(getMaxRestCapacity(parkLotPositionRate))) {
                parkLot.park(car);
                parkLotPositionRate.put(parkLot, String.valueOf((double)(restCapacity - 1) / (double)parkLot.getCapacity()));
                int gcd = gcd(restCapacity - 1, parkLot.getCapacity());
                isParkSuccess = String.format("the car is parked in the parkingLot %d and position rate is %d/%d", i + 1, (restCapacity - 1) / gcd, parkLot.getCapacity() / gcd);
                break;
            }
        }
        return null;
    }

    @Override
    public String getMaxRestCapacity(Map<ParkLot, String> parkLotRestCapacity) {
        return super.getMaxRestCapacity(parkLotRestCapacity);
    }

    public int gcd(int n, int m) {
        int temp,r;
        if(n<m)
        {
            temp=n;
            n=m;
            m=temp;
        }
        while(m!=0)
        {
            r=n%m;
            n=m;
            m=r;
        }
        return n;
    }
}
