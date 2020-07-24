package com.oocl.cultivation;

import com.oocl.cultivation.test.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {
    private Map<CarTicket, Car> carTicketMap = new HashMap<>();
    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        carTicketMap.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        for (Map.Entry<CarTicket, Car> entry: carTicketMap.entrySet()) {
            if (entry.getKey().equals(carTicket)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
