package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {
    private Map<CarTicket, Car> parkingRoom = new HashMap<>();
    private int capacity;

    public int getRestCapacity() {
        return capacity - this.parkingRoom.size();
    }

    public ParkLot(int capacity) {
        this.capacity = capacity;
    }

    Map<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }

    public CarTicket park(Car car) throws ErrorMessageException {
        if (this.capacity > parkingRoom.size()) {
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            return carTicket;
        } else {
            throw new ErrorMessageException(ErrorMessage.NOT_ENOUGH_POSITION);
        }
    }

    public Car fetch(CarTicket carTicket) throws ErrorMessageException {
        if (parkingRoom.containsKey(carTicket)) {
            return parkingRoom.remove(carTicket);
        }
        throw new ErrorMessageException(ErrorMessage.UNRECOGNIZED_PARKING_TICKET);
    }

    public int getCapacity() {
        return capacity;
    }

    double getMaxPositionRate() {
        return (double)getRestCapacity() / (double)getCapacity();
    }
}
