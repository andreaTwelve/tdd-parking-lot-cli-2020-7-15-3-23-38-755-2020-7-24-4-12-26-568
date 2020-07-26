package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkBoyTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem,1);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();
        //when
        CarTicket carTicket = (CarTicket)parkBoy.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_ticket() {
        //given
        Car car = new Car();
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem,1);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        CarTicket carTicket = (CarTicket)(parkBoy.park(car));
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
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem,3);
        ParkBoy parkBoy = new ParkBoy(parkLot);

        //when
        List<CarTicket> carTicketList = new ArrayList<>();
        for (Car car: cars) {
            CarTicket carTicket = (CarTicket)(parkBoy.park(car));
            carTicketList.add(carTicket);
        }

        //then
        assertEquals(3, carTicketList.size());
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_not_provide_ticket_by_boy() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem, 10);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();
        parkBoy.park(car);
        CarTicket carTicket = new CarTicket();
        //when
        String actualMessage = parkBoy.checkTicket(carTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_used_ticket() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem, 10);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();

        CarTicket usedCarTicket = (CarTicket)parkBoy.park(car);
        parkBoy.fetch(usedCarTicket);
        //when
        String actualMessage = parkBoy.checkTicket(usedCarTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_check_ticket_given_no_ticket() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem, 10);
        ParkBoy parkBoy = new ParkBoy(parkLot);
        Car car = new Car();
        parkBoy.park(car);
        parkBoy.fetch(null);
        //when
        String actualMessage = parkBoy.checkTicket(null);
        //then
        assertEquals("Please provide your parking ticket", actualMessage);
    }

    @Test
    void should_return_message_when_park_given_parking_two_cars_lot1_is_1_and_parking_lot2_is_2() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkLot parkLot1 = new ParkLot(carTicketSystem, 1);
        ParkLot parkLot2 = new ParkLot(carTicketSystem, 2);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        parkLots.add(parkLot2);
        ParkBoy parkBoy = new ParkBoy(parkLots);

        //when
        String message1 = (String)(parkBoy.park(car1));
        String message2 = (String)(parkBoy.park(car2));

        //then
        assertEquals("the car is parked in the parkingLot 1 and has 0 rest capacity", message1);
        assertEquals("the car is parked in the parkingLot 2 and has 1 rest capacity", message2);
    }

    @Test
    void should_return_message_when_park_given_parking_two_cars_lot1_is_2_and_parking_lot2_is_1() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkLot parkLot1 = new ParkLot(carTicketSystem, 2);
        ParkLot parkLot2 = new ParkLot(carTicketSystem, 1);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        parkLots.add(parkLot2);
        ParkBoy parkBoy = new ParkBoy(parkLots);

        //when
        String message1 = (String)(parkBoy.park(car1));
        String message2 = (String)(parkBoy.park(car2));

        //then
        assertEquals("the car is parked in the parkingLot 1 and has 1 rest capacity", message1);
        assertEquals("the car is parked in the parkingLot 1 and has 0 rest capacity", message2);
    }
}
