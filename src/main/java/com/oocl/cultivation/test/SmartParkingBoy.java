package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkBoy {
    private List<ParkLot> parkLots;

    public SmartParkingBoy(List<ParkLot> parkLots) {
        this.parkLots = parkLots;
    }

    //// TODO: 7/28/2020 nullptr
    public CarTicket park(Car car) throws Exception {
        ParkLot parkLot = parkLots.stream().max(Comparator.comparingDouble(ParkLot::getRestCapacity)).orElse(null);
        if (parkLot == null) {
            return null;
        }
        return parkLot.park(car);
    }

    @Override
    public Car fetch(CarTicket carTicket) throws ErrorMessageException {
        ParkLot parkLot1 = parkLots.stream().filter(parkLot -> parkLot.getParkingRoom().containsKey(carTicket)).findFirst().get();
        return parkLot1.fetch(carTicket);
    }
}
