package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;
import com.oocl.cultivation.test.Car;
import com.oocl.cultivation.test.CarTicket;
import com.oocl.cultivation.test.CarTicketSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {
    private Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private int capacity;
    private int restCapacity;

    public int getRestCapacity() {
        return capacity - this.parkingRoom.size();
    }

    public ParkLot() {
        //this.capacity = 10;
    }

    public ParkLot(int capacity) {
        this.capacity = capacity;
        //this.restCapacity = capacity - this.parkingRoom.size();
    }


    public Map<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }

    public CarTicket park(Car car) throws ErrorMessageException {
        if (this.capacity > parkingRoom.size()) {
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            return carTicket;
        } else {
            throw new ErrorMessageException("Not enough position.");
        }
    }

    public Car fetch(CarTicket carTicket) throws ErrorMessageException {
        if (parkingRoom.containsKey(carTicket)) {
            return parkingRoom.remove(carTicket);
        }
        throw new ErrorMessageException("Unrecognized parking ticket.");
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

//    public String checkTicket(CarTicket carTicket) {
//        if (!parkingRoom.containsKey(carTicket)) {
//            return "Unrecognized parking ticket.";
//        }
//    }
}
