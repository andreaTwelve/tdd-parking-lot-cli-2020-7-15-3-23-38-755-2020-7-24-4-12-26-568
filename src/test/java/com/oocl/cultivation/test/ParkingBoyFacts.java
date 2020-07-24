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
        //when
        //CarTicket carTicket =
        ParkLot parkLot = new ParkLot();
        Car car = new Car();
        CarTicket carTicket = parkLot.park(car);
        //then
        assertNotNull(carTicket);
    }
}
