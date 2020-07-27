package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_return_message_when_park_3_cars_given_lot1_is_2_and_lot2_is_4() throws Exception {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkLot parkLot1 = new ParkLot(2);
        ParkLot parkLot2 = new ParkLot(4);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        parkLots.add(parkLot2);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkLots);

        //when
        superSmartParkingBoy.park(car1);
        superSmartParkingBoy.park(car2);
        superSmartParkingBoy.park(car3);

        //then
        assertEquals(1, parkLot1.getRestCapacity());
        assertEquals(2, parkLot2.getRestCapacity());
    }

//    @Test
//    void should_return_message_when_park_3_cars_given_lot1_is_1_and_lot2_is_2() {
//        //given
//        CarTicketSystem carTicketSystem = new CarTicketSystem();
//        Car car1 = new Car();
//        Car car2 = new Car();
//        Car car3 = new Car();
//        ParkLot parkLot1 = new ParkLot(carTicketSystem, 1);
//        ParkLot parkLot2 = new ParkLot(carTicketSystem, 1);
//        List<ParkLot> parkLots = new ArrayList<>();
//        parkLots.add(parkLot1);
//        parkLots.add(parkLot2);
//
//        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkLots);
//
//        //when
//        String message1 = (String)(superSmartParkingBoy.park(car1));
//        String message2 = (String)(superSmartParkingBoy.park(car2));
//        String message3 = (String)(superSmartParkingBoy.park(car3));
//
//        //then
//        assertEquals("the car is parked in the parkingLot 1 and position rate is 0/1", message1);
//        assertEquals("the car is parked in the parkingLot 2 and position rate is 0/1", message2);
//        assertEquals("Not enough position", message3);
//    }
}
