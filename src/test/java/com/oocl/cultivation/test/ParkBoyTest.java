package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkBoy;
import com.oocl.cultivation.ParkLot;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Car fetchCar = parkBoy.fetch(carTicket);
        //then
        assertNotNull(fetchCar);
    }

    @Test
    void should_return_ticket_when_park_given_more_car() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car [] cars = new Car[] {car1, car2, car3};
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);

        //when
        List<CarTicket> carTicketList = new ArrayList<>();
        for (Car car: cars) {
            carTicketList.add(parkBoy.park(car));
        }

        //then
        assertEquals(3, carTicketList.size());
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_query_error_message_given_not_provide_ticket_by_boy() {
        //given
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();
        parkBoy.park(car);
        //when
        String actualMessage = parkBoy.queryMessage(null);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_query_error_message_given_used_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();

        CarTicket usedCarTicket = parkBoy.park(car);
        parkBoy.fetch(usedCarTicket);
        //when
        String actualMessage = parkLot.queryMessage(usedCarTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_query_error_message_given_no_ticket() {
        //given
        ParkLot parkLot = new ParkLot();
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();
        parkBoy.park(car);
        parkBoy.fetch(null);
        //when
        String actualMessage = parkBoy.queryMessage(null);
        //then
        assertEquals("Please provide your parking ticket", actualMessage);
    }
}
