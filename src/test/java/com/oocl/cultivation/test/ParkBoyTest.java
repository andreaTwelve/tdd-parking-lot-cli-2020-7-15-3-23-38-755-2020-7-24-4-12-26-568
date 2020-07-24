package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkBoy;
import com.oocl.cultivation.ParkLot;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkBoyTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();
        //when
        CarTicket carTicket = parkBoy.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_ticket() {
        //given
        Car car = new Car();
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        CarTicket carTicket = parkBoy.park(car);
        //when
        Car fetchCar = parkLot.fetch(carTicket);
        //then
        assertNotNull(fetchCar);
    }


}
