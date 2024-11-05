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
        if(event.getTicketAvailability()>=booking.numberOfTickets) {
            int availability = event.getTicketAvailability() - booking.numberOfTickets;
            event.setTicketAvailability(availability);
        }else{
            // done
            System.out.println(STR."There are only \{event.getTicketAvailability()} tickets available");
        }
    }
    public double getTotalPrice(){
        return numberOfTickets* event.getTicketPrice();
    }
}
// Extend the system to allow for booking specific seats at each event.
// hashMaps can be used kind of seat number (int) as K and availability (boolean) as V