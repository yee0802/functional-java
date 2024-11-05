package org.example;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TicketBooking {
    private LiveEvent event;
    private int numberOfTickets;
    Consumer<TicketBooking> uptadeTickets = this :: updateTickets;

    //TO BE UPDATED:
    // handle the cases when ticket availability is insufficient
    public void updateTickets(TicketBooking booking){
        int availability = event.getTicketAvailability() - booking.numberOfTickets;
        event.setTicketAvailability(availability);

    }
    public double getTotalPrice(){
        return numberOfTickets* event.getTicketPrice();
    }
}
