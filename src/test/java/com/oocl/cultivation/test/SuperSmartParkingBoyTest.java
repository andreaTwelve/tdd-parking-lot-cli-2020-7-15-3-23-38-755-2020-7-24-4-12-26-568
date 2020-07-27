package com.oocl.cultivation.test;

import com.oocl.cultivation.exception.ErrorMessageException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperSmartParkingBoyTest {

    @Test
    void should_return_message_when_park_3_cars_given_lot1_is_2_and_lot2_is_4() throws Exception {
        //given
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

    @Test
    void should_return_message_when_park_3_cars_given_lot1_is_1_and_lot2_is_2() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkLot parkLot1 = new ParkLot(1);
        ParkLot parkLot2 = new ParkLot(1);
        List<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(parkLot1);
        parkLots.add(parkLot2);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkLots);

        //when
        superSmartParkingBoy.park(car1);
        superSmartParkingBoy.park(car2);
        ErrorMessageException errorMessageException = assertThrows(ErrorMessageException.class, () -> {
            superSmartParkingBoy.park(car3);
        });

        //then
        assertEquals(0, parkLot1.getRestCapacity());
        assertEquals(0, parkLot2.getRestCapacity());
        assertEquals("Not enough position.", errorMessageException.getMessage());
    }
}
