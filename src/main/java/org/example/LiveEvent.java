package org.example;

public class LiveEvent {
    private String id;
    private String name;
    private String date;
    private double ticketPrice;
    private int ticketAvailability;

    public LiveEvent(String id, String name, String date, double ticketPrice, int ticketAvailability){
        this.id = id;
        this.name = name;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.ticketAvailability = ticketAvailability;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return ticketAvailability;
    }

    public void setTicketAvailability(int ticketAvailability) {
        this.ticketAvailability = ticketAvailability;
    }


}
