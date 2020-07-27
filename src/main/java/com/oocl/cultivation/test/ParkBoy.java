package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;

import java.util.ArrayList;
import java.util.List;

public class ParkBoy {
    private ParkLot parkLot;
    private List<ParkLot> parkLots = new ArrayList<>();

    public ParkBoy(ParkLot parkLot) {
        this.parkLot = parkLot;
        this.parkLots.add(parkLot);
    }

    public ParkBoy(List<ParkLot> parkLots) {
        this.parkLots = parkLots;
    }

    public CarTicket park(Car car) throws Exception {
        ParkLot parkLot = parkLots.stream().filter(parkLot1 -> parkLot1.getRestCapacity() > 0).findFirst().get();
        return parkLot.park(car);
    }

    public Car fetch(CarTicket carTicket) throws ErrorMessageException {
        if (parkLot.getParkingRoom().containsKey(carTicket)) {
            return parkLot.fetch(carTicket);
        } else {
            throw new ErrorMessageException("Please provide your parking ticket.");
        }
    }
}
