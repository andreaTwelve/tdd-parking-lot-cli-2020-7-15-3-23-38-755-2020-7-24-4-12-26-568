package com.oocl.cultivation.test;

import com.oocl.cultivation.test.Car;
import com.oocl.cultivation.test.CarTicket;
import com.oocl.cultivation.test.CarTicketSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {
    private Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private int capacity;
    private CarTicketSystem carTicketSystem;

    public ParkLot() {
        //this.capacity = 10;
    }

    public Map<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }

    public ParkLot(CarTicketSystem carTicketSystem, int capacity) {
        this.carTicketSystem = carTicketSystem;
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        if (this.capacity > parkingRoom.size()) {
            CarTicket carTicket = carTicketSystem.generateTicket();
            parkingRoom.put(carTicket, car);
            return carTicket;
        } else {
            return null;
        }
    }

    public Car fetch(CarTicket carTicket) {
        if (carTicket != null && parkingRoom.containsKey(carTicket)) {
            carTicketSystem.updateTicketMessage(carTicket);
        }
        return parkingRoom.remove(carTicket);
    }

    public int getCapacity() {
        return capacity;
    }

    public String isContainsCapacity() {
        String message;
        if (parkingRoom.size() == this.capacity) {
            message =  "Not enough position";
        } else {
            message = null;
        }
        return message;
    }

    public String checkTicket(CarTicket carTicket) {
        return carTicketSystem.checkTicket(carTicket);
    }
}
