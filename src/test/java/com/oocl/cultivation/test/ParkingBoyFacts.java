package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
