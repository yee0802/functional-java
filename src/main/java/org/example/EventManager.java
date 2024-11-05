package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventManager {
    private List<LiveEvent> events = new ArrayList<>();

    // add event
    public void addEvent(LiveEvent event){
        this.events.add(event);
    }
    // update ticket availability
    public void updateTicketAvailability(String eventId, int newAvailabity){
        for (LiveEvent event : events){
            if(Objects.equals(event.getId(), eventId)){
                event.setTicketAvailability(newAvailabity);
            }
        }
    }
    // retrieve event information

    public LiveEvent retrieveInformation(String eventId){
        return (LiveEvent) events.stream().filter(event -> Objects.equals(event.getId(), eventId));
    }

}
