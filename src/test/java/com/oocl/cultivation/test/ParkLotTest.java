package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkBoy;
import com.oocl.cultivation.ParkLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkLotTest {
    @Test
    void should_return_no_car_when_fetch_given_wrong_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car1 = new Car();
        parkBoy.park(car1);
        CarTicket carTicket2 = new CarTicket();
        //when
        Car fetchCar = parkBoy.fetch(carTicket2);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_car_when_fetch_given_no_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        parkBoy.park(new Car());
        //when
        Car fetchCar = parkBoy.fetch(null);
        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_car_when_fetch_given_used_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car1 = new Car();
        CarTicket carTicket1 = parkBoy.park(car1);
        parkBoy.fetch(carTicket1);
        //when
        Car fetchCar = parkBoy.fetch(carTicket1);
        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_ticket_when_park_given_no_capacity() {
        //given
        ParkLot parkLot = new ParkLot(10);
        ParkBoy parkBoy = new ParkBoy(parkLot);

        List<Car> carList = new ArrayList<>();
        List<CarTicket> carTicketList = new ArrayList<>();
        for (int i = 0; i < parkLot.getCapacity() + 1; i++) {
            carList.add(new Car());
        }

        //when
        for (Car car: carList) {
            carTicketList.add(parkBoy.park(car));
        }
        CarTicket carTicket = carTicketList.get(carTicketList.size() - 1);
        //then
        assertNull(carTicket);
    }
}
