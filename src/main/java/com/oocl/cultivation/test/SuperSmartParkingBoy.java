package com.oocl.cultivation.test;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {
    private List<ParkLot> parkLots;
    public SuperSmartParkingBoy(List<ParkLot> parkLots) {
        super(parkLots);
        this.parkLots = parkLots;
    }

    //// TODO: 7/28/2020 refactor
    @Override
    public CarTicket park(Car car) throws Exception {
        ParkLot parkLot = parkLots.stream().max(Comparator.comparingDouble(ParkLot::getMaxPositionRate)).orElse(null);
        if (parkLot == null) {
            return null;
        }
        return parkLot.park(car);
    }
}
