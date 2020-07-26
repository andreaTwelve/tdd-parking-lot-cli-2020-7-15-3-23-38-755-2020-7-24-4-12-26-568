package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem, 10);
        List<Car> carList = new ArrayList<>();
        List<CarTicket> carTicketList = new ArrayList<>();
        for (int i = 0; i < parkLot.getCapacity() + 1; i++) {
            carList.add(new Car());
        }

        //when
        for (Car car: carList) {
            CarTicket carTicket = parkLot.park(car);
            carTicketList.add(carTicket);
        }
        CarTicket carTicket = carTicketList.get(carTicketList.size() - 1);
        //then
        assertNull(carTicket);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_not_provide_ticket_by_boy() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem, 1);
        CarTicket carTicket = new CarTicket();
        parkLot.park(new Car());
        //when
        String actualMessage = parkLot.checkTicket(carTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_used_ticket() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem, 20);
        Car car = new Car();
        CarTicket carTicket = parkLot.park(car);
        parkLot.fetch(carTicket);
        //when
        String actualMessage = parkLot.checkTicket(carTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_not_enough_position_when_is_contains_position_given_no_capacity() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(carTicketSystem, 10);
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < parkLot.getCapacity(); i++) {
            carList.add(new Car());
        }
        for (Car car: carList) {
            parkLot.park(car);
        }
        //when
        String actualMessage = parkLot.isContainsCapacity();
        //then
        assertEquals("Not enough position", actualMessage);
    }

}
