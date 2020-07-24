package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void write_your_first_test() {

    }

    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkLot parkLot = new ParkLot();
        Car car = new Car();
        //when
        CarTicket carTicket = parkLot.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_ticket_when_park_given_more_car() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car [] cars = new Car[] {car1, car2, car3};
        ParkLot parkLot = new ParkLot();

        //when
        List<CarTicket> carTicketList = new ArrayList<>();
        for (Car car: cars) {
            carTicketList.add(parkLot.park(car));
        }

        //then
        assertEquals(3, carTicketList.size());
    }


    @Test
    void should_return_car_when_fetch_given_ticket() {
        //given
        Car car = new Car();
        ParkLot parkLot = new ParkLot();
        CarTicket carTicket = parkLot.park(car);
        //when
        Car fetchCar = parkLot.fetch(carTicket);
        //then
        assertNotNull(fetchCar);
    }


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

}
