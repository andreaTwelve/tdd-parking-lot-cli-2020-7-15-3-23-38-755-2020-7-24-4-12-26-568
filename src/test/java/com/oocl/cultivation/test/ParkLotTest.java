package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
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
        Car car1 = new Car();
        parkLot.park(car1);
        CarTicket carTicket2 = new CarTicket();
        //when
        Car fetchCar = parkLot.fetch(carTicket2);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_car_when_fetch_given_no_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        parkLot.park(new Car());
        //when
        Car fetchCar = parkLot.fetch(null);
        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_car_when_fetch_given_used_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        Car car1 = new Car();
        CarTicket carTicket1 = parkLot.park(car1);
        parkLot.fetch(carTicket1);
        //when
        Car fetchCar = parkLot.fetch(carTicket1);
        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_ticket_when_park_given_no_capacity() {
        //given
        ParkLot parkLot = new ParkLot(10);
        List<Car> carList = new ArrayList<>();
        List<CarTicket> carTicketList = new ArrayList<>();
        for (int i = 0; i < parkLot.getCapacity() + 1; i++) {
            carList.add(new Car());
        }

        //when
        for (Car car: carList) {
            carTicketList.add(parkLot.park(car));
        }
        CarTicket carTicket = carTicketList.get(carTicketList.size() - 1);
        //then
        assertNull(carTicket);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_query_error_message_given_no_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        Car car = new Car();
        //when
        String actualMessage = parkLot.queryMessage(null);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_query_error_message_given_used_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        Car car = new Car();
        CarTicket usedCarTicket = parkLot.park(car);
        parkLot.fetch(usedCarTicket);
        //when
        String actualMessage = parkLot.queryMessage(usedCarTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }
}
