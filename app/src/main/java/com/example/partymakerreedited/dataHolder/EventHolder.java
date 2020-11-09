package com.example.partymakerreedited.dataHolder;

import com.example.partymakerreedited.models.Event;

public class EventHolder {
    private static EventHolder instance;
    private Event event;

    private EventHolder() {
    }

    public static EventHolder getInstance() {
        if (instance == null) {
            synchronized (EventHolder.class) {
                if (instance == null) {
                    instance = new EventHolder();
                }
            }
        }
        return instance;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event e){
        this.event=event;
    }
}
