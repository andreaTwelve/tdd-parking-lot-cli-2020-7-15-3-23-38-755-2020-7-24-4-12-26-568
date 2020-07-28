package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {
    private List<ParkLot> parkLots;
    public SuperSmartParkingBoy(List<ParkLot> parkLots) {
        super(parkLots);
        this.parkLots = parkLots;
    }

    //// TODO: 7/28/2020 ..
    @Override
    public CarTicket park(Car car) throws Exception {
        List<Double> restCapacity = new ArrayList<>();
        for (ParkLot parkLot: parkLots) {
            restCapacity.add((double)parkLot.getRestCapacity() / (double)parkLot.getCapacity());
        }
        //restCapacity.sort((a,b)->(int) (b-a));
        Object[] obj = restCapacity.toArray();
        ParkLot parkLot = parkLots.stream().max(Comparator.comparingDouble(ParkLot::getRestCapacity)).orElse(null);
        //Double[] obj = restCapacity.toArray();
//        Arrays.sort(obj);
//        double maxPositionRate = (double)obj[restCapacity.size() - 1];
//        ParkLot parkLot = parkLots.stream().filter(parkLot1 ->
//                maxPositionRate == ((double)parkLot1.getRestCapacity() / (double)parkLot1.getCapacity())).findFirst().orElse(null);
        if (parkLot == null) {
            return null;
        }
        return parkLot.park(car);
    }
}
