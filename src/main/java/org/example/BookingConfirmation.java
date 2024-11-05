package org.example;

import java.util.List;
import java.util.function.Supplier;

public class BookingConfirmation {
    private List<TicketBooking> bookings;
    public BookingConfirmation(List<TicketBooking> bookings){
        this.bookings = bookings;
    }
    public double calculatePrice(){
        Supplier<Double> totalPrice = () ->
                this.bookings.stream()
                        .mapToDouble(TicketBooking::getTotalPrice)
                        .sum();
        return totalPrice.get();
    }

}
