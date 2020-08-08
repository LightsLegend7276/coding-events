package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.HashMap;
import java.util.Map;

public class EventData {

    private static final Map<Integer, Event> events = new HashMap<>();

    public static Map<Integer, Event> getAllEvents() {
        return events;
    }

    public static Event getEventById(int id) {
        return events.get(id);
    }

    public static void addEvent(Event event) {
        events.put(event.getId(), event);
    }

    public static void deleteEvent(int id) {
        events.remove(id);
    }

}
