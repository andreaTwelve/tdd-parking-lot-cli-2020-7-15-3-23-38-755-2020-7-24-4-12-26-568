package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkLotTest {
    @Test
    //todo
    void should_return_no_car_when_fetch_given_provide_no_ticket_by_boy() throws Exception {
        //given
        ParkLot parkLot = new ParkLot(1);
        parkLot.park(new Car());
        //when
        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
            parkLot.fetch(null);
        });
        //then
        assertEquals("Unrecognized parking ticket.", errorMessageException.getMessage());
    }

    @Test
    //todo
    void should_return_no_car_when_fetch_given_used_ticket() throws Exception {
        //given
        ParkLot parkLot = new ParkLot(1);
        Car car1 = new Car();
        CarTicket carTicket1 = parkLot.park(car1);
        parkLot.fetch(carTicket1);
        //when
        //Car fetchCar = parkLot.fetch(carTicket1);
        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
            parkLot.fetch(carTicket1);
        });
        //then
        assertEquals("Unrecognized parking ticket.", errorMessageException.getMessage());
    }

    @Test
    void should_return_no_ticket_when_park_given_no_capacity() throws Exception {
        //given
        ParkLot parkLot = new ParkLot(10);
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
    void should_return_not_enough_position_when_is_contains_position_given_no_capacity() throws Exception {
        //given
        //CarTicketSystem carTicketSystem = new CarTicketSystem();
        ParkLot parkLot = new ParkLot(10);
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
