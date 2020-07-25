package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTicketSystemTest {
    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_not_provide_ticket_by_boy() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        //when
        CarTicket carTicket = new CarTicket();
        String actualMessage = carTicketSystem.checkTicket(carTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }
}
