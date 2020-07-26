package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class CarTicketSystem {
    private Map<CarTicket, Boolean> carTicketMessage = new HashMap<>();
    public String checkTicket(CarTicket carTicket) {
        String message;
        if (carTicket != null && (!carTicketMessage.containsKey(carTicket) || carTicketMessage.get(carTicket))) {
            message = "Unrecognized parking ticket";
        } else {
            message = "Please provide your parking ticket";
        }
        return message;
    }

    public void updateTicketMessage(CarTicket carTicket) {
        if (carTicket != null && carTicketMessage.containsKey(carTicket)) {
            carTicketMessage.put(carTicket, true);
        }
    }

    public CarTicket generateTicket() {
        CarTicket carTicket = new CarTicket();
        carTicketMessage.put(carTicket, false);
        return carTicket;
    }

}
