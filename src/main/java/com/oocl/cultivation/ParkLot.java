package com.oocl.cultivation;

import com.oocl.cultivation.test.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {
    private Map<CarTicket, Car> carTicketMap = new HashMap<>();
    private int capacity;

    public ParkLot() {
    }

    public ParkLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        if (this.capacity > carTicketMap.size()) {
            CarTicket carTicket = new CarTicket();
            carTicketMap.put(carTicket, car);
            return carTicket;
        } else {
            return null;
        }
    }

    public Car fetch(CarTicket carTicket) {
        return carTicketMap.remove(carTicket);
    }

    public int getCapacity() {
        return capacity;
    }

    public String queryMessage(CarTicket carTicket) {
        return "Unrecognized parking ticket";
    }
}
