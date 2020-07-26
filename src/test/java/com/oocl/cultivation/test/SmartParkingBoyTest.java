package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_return_message_when_park_4_cars_given_2_parking_lots() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        ParkLot parkLot1 = new ParkLot(carTicketSystem, 2);
        ParkLot parkLot2 = new ParkLot(carTicketSystem, 3);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        parkLots.add(parkLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkLots);

        //when
        String message1 = (String)(smartParkingBoy.park(car1));
        String message2 = (String)(smartParkingBoy.park(car2));
        String message3 = (String)(smartParkingBoy.park(car3));
        String message4 = (String)(smartParkingBoy.park(car4));

        //then
        assertEquals("the car is parked in the parkingLot 2 and has 2 rest capacity", message1);
        assertEquals("the car is parked in the parkingLot 1 and has 1 rest capacity", message2);
        assertEquals("the car is parked in the parkingLot 2 and has 1 rest capacity", message3);
        assertEquals("the car is parked in the parkingLot 1 and has 0 rest capacity", message4);
    }
}
