package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkLotTest {
    @Test
    //todo
    void should_return_unrecognized_parking_ticket_when_fetch_given_provide_no_ticket_by_boy() throws Exception {
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
        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
            parkLot.fetch(carTicket1);
        });
        //then
        assertEquals("Unrecognized parking ticket.", errorMessageException.getMessage());
    }

    @Test
    void should_return_not_enough_position_when_park_11_cars_given_10_capacity() throws Exception {
        //given
        ParkLot parkLot = new ParkLot(10);
        List<Car> carList = new ArrayList<>();
        List<CarTicket> carTickets = new ArrayList<>();
        for (int i = 0; i < parkLot.getCapacity() + 1; i++) {
            carList.add(new Car());
        }

        //when
        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
            for (Car car: carList) {
                CarTicket carTicket = parkLot.park(car);
                carTickets.add(carTicket);
            }
        });

        //then
        assertEquals("Not enough position.", errorMessageException.getMessage());
    }

    @Test
        // TODO: 2020/7/27  
    void should_return_not_enough_position_when_park_given_no_capacity() throws Exception {
        //given
        ParkLot parkLot = new ParkLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        parkLot.park(car1);
        //when
        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
            parkLot.park(car2);
        });
        //then
        assertEquals("Not enough position.", errorMessageException.getMessage());
    }

}
