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
        List<Double> restCapacity = new ArrayList<>();
        for (ParkLot parkLot: parkLots) {
            restCapacity.add((double)parkLot.getRestCapacity() / (double)parkLot.getCapacity());
        }
        Object[] obj = restCapacity.toArray();
        Arrays.sort(obj);
        double maxPositionRate = (double)obj[restCapacity.size() - 1];
        ParkLot parkLot = parkLots.stream().filter(parkLot1 ->
                maxPositionRate == ((double)parkLot1.getRestCapacity() / (double)parkLot1.getCapacity())).findFirst().get();
        return parkLot.park(car);
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
