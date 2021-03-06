package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_car() throws Exception {
        //given
        Car car = new Car();
        ParkLot parkLot1 = new ParkLot(1);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkLots);
        //when
        CarTicket carTicket = smartParkingBoy.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkLot parkLot = new ParkLot(1);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkLots);
        CarTicket carTicket = smartParkingBoy.park(car);
        //when
        Car fetchCar = smartParkingBoy.fetch(carTicket);
        //then
        assertEquals(car, fetchCar);
    }

//    @Test
//    void should_return_please_provide__your_parking_ticket_when_fetch_given_no_ticket_by_customer() throws Exception {
//        //given
//        Car car = new Car();
//        ParkLot parkLot = new ParkLot(1);
//        List<ParkLot> parkLots = new ArrayList<>();
//        parkLots.add(parkLot);
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkLots);
//        smartParkingBoy.park(car);
//        //when
//        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
//            smartParkingBoy.fetch(null);
//        });
//        //then
//        assertEquals("Please provide your parking ticket.", errorMessageException.getMessage());
//    }

    @Test
    void should_return_message_when_park_given_parking_two_cars_lot1_is_1_and_parking_lot2_is_2() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkLot parkLot1 = new ParkLot(1);
        ParkLot parkLot2 = new ParkLot(3);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        parkLots.add(parkLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkLots);

        //when
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);

        //then
        assertEquals(1, parkLot1.getRestCapacity());
        assertEquals(1, parkLot2.getRestCapacity());
    }
}
