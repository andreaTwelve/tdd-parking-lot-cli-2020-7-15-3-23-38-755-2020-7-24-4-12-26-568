package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkLot;
import org.junit.jupiter.api.Test;

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
}
