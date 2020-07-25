package com.oocl.cultivation;

import com.oocl.cultivation.test.Car;

public class ParkBoy {
    private ParkLot parkLot;

    public ParkBoy(ParkLot parkLot) {
        this.parkLot = parkLot;
    }

    public CarTicket park(Car car){
        return parkLot.park(car);
    }

    public String queryMessage(CarTicket carTicket) {
        return null;
    }
}
