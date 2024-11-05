package org.example;

import java.util.HashMap;
import java.util.List;

public class LiveEvent {
    private static int id;
    private String name;
    private String date;
    private double ticketPrice;
    private int ticketAvailability;
    //private List<Seats> seatsAvailable;
    private HashMap<Integer,SeatAvailability> seatsAvailable;


    public LiveEvent(String name, String date, double ticketPrice, int ticketAvailability){
        id ++;
        this.name = name;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.ticketAvailability = ticketAvailability;
        this.seatsAvailable = new HashMap<>();
        for(int i = 0; i<ticketAvailability; i++) {
            this.seatsAvailable.put(i, SeatAvailability.AVAILABLE);
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketAvailability() {
        int ticketsAvailable = 0;
        for (int i = 0; i<this.seatsAvailable.size(); i++){
            if(this.seatsAvailable.get(i) == SeatAvailability.AVAILABLE){
                ticketsAvailable++;
            }
        }
        return ticketsAvailable ;
    }

    public void setTicketAvailability(int ticketAvailability) {
        this.ticketAvailability = ticketAvailability;
    }


}
