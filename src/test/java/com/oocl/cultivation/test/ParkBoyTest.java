package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkBoyTest {
    @Test
    //// TODO: 7/27/2020
    void should_return_ticket_when_park_given_car() throws Exception {
        //given
        ParkLot parkLot = new ParkLot(1);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();
        //when
        CarTicket carTicket = parkBoy.park(car);
        //then
        assertNotNull(carTicket);
    }


    @Test
    //// TODO: 7/27/2020
    void should_return_car_when_fetch_given_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkLot parkLot = new ParkLot(1);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        CarTicket carTicket = parkBoy.park(car);
        //when
        Car fetchCar = parkBoy.fetch(carTicket);
        //then
        assertNotNull(fetchCar);
        assertEquals(car, fetchCar);
    }

    @Test
    void should_return_ticket_when_park_given_more_car() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car [] cars = new Car[] {car1, car2, car3};
        ParkLot parkLot = new ParkLot(3);
        ParkBoy parkBoy = new ParkBoy(parkLot);

        //when
        List<CarTicket> carTicketList = new ArrayList<>();
        for (Car car: cars) {
            CarTicket carTicket = parkBoy.park(car);
            carTicketList.add(carTicket);
        }

        //then
        assertEquals(3, carTicketList.size());
    }

    @Test
    //// TODO: 7/27/2020  
    void should_return_no_car_when_fetch_given_no_ticket_by_customer() throws Exception {
        //given
        ParkLot parkLot = new ParkLot(1);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        parkBoy.park(new Car());
        //when
        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
            parkBoy.fetch(null);
        });
        //then
        assertEquals("Please provide your parking ticket.", errorMessageException.getMessage());
    }

    @Test
    void should_return_message_when_park_given_parking_two_cars_lot1_is_1_and_parking_lot2_is_2() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkLot parkLot1 = new ParkLot(1);
        ParkLot parkLot2 = new ParkLot(2);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        parkLots.add(parkLot2);
        ParkBoy parkBoy = new ParkBoy(parkLots);

        //when
        parkBoy.park(car1);
        parkBoy.park(car2);


        //then
        assertEquals(0, parkLot1.getRestCapacity());
        assertEquals(1, parkLot2.getRestCapacity());
    }

//    @Test
//    void should_return_message_when_park_given_parking_two_cars_lot1_is_2_and_parking_lot2_is_1() {
//        //given
//        CarTicketSystem carTicketSystem = new CarTicketSystem();
//        Car car1 = new Car();
//        Car car2 = new Car();
//        ParkLot parkLot1 = new ParkLot(carTicketSystem, 2);
//        ParkLot parkLot2 = new ParkLot(carTicketSystem, 1);
//        List<ParkLot> parkLots = new ArrayList<>();
//        parkLots.add(parkLot1);
//        parkLots.add(parkLot2);
//        ParkBoy parkBoy = new ParkBoy(parkLots);
//
//        //when
//        String message1 = (String)(parkBoy.park(car1));
//        String message2 = (String)(parkBoy.park(car2));
//
//        //then
//        assertEquals("the car is parked in the parkingLot 1 and has 1 rest capacity", message1);
//        assertEquals("the car is parked in the parkingLot 1 and has 0 rest capacity", message2);
//    }
}
