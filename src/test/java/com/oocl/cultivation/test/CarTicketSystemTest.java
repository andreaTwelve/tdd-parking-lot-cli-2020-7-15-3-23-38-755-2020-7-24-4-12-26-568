package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTicketSystemTest {
    @Test
    void should_get_ticket_when_add_ticket_given_car() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        //when
        CarTicket carTicket = carTicketSystem.addTicket();
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_not_provide_ticket_by_boy() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        CarTicket carTicket = new CarTicket();
        carTicketSystem.addTicket();
        //when
        String actualMessage = carTicketSystem.checkTicket(carTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_check_ticket_given_used_ticket() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();
        CarTicket carTicket = carTicketSystem.addTicket();
        carTicketSystem.deleteTicket(carTicket);

        //when
        String actualMessage = carTicketSystem.checkTicket(carTicket);
        //then
        assertEquals("Unrecognized parking ticket", actualMessage);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_check_ticket_given_no_ticket() {
        //given
        CarTicketSystem carTicketSystem = new CarTicketSystem();

        //when
        String actualMessage = carTicketSystem.checkTicket(null);
        //then
        assertEquals("please provide your parking ticket", actualMessage);
    }
}
