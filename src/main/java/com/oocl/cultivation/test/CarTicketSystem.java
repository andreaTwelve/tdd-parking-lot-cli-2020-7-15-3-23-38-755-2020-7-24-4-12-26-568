package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import sun.security.krb5.internal.Ticket;

import java.util.HashMap;
import java.util.Map;

public class CarTicketSystem {
    private Map<CarTicket, Boolean> carTicketBooleanMap = new HashMap<>();
    public String checkTicket(CarTicket carTicket) {
        String message;
        if (!carTicketBooleanMap.containsKey(carTicket) || carTicketBooleanMap.get(carTicket)) {
            message = "Unrecognized parking ticket";
        } else {
            message = null;
        }
        return message;
    }

    public void deleteTicket(CarTicket carTicket) {
        carTicketBooleanMap.put(carTicket, true);
    }

    public CarTicket addTicket() {
        CarTicket carTicket = new CarTicket();
        carTicketBooleanMap.put(carTicket, false);
        return carTicket;
    }
}
