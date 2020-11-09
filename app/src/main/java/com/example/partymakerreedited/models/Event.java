package com.example.partymakerreedited.models;

import java.util.ArrayList;
import java.util.Iterator;

public class Event {

    private User inviter;
    private String eventName;
    private ArrayList<User> guests;
    private String eventPreviewImage;
    private User invitedPerson;

    public Event() {
        guests = new ArrayList<User>();
    }

    public User getInvitedPerson() {
        return invitedPerson;
    }

    public void setInvitedPerson(User invitedPerson) {
        this.invitedPerson = invitedPerson;
    }

    public String getEventPreviewImage() {
        return eventPreviewImage;
    }

    public void setEventPreviewImage(String eventPreviewImage) {
        this.eventPreviewImage = eventPreviewImage;
    }

    public User getInviter() {
        return inviter;
    }

    public void setInviter(User inviter) {
        this.inviter = inviter;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public ArrayList<User> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<User> guests) {
        this.guests = guests;
    }

    public User findById(String id) {
        for(User u: guests)
        {
            if(u.getId().equals(id))return u;
        }return new User();
    }

    public void deleteById(String id) {
        Iterator<User> iterator = guests.iterator();
        while(iterator.hasNext())
        {
            if(iterator.next().getId().equals(id))
                iterator.remove();
        }
    }

    public void swap(String callerId) {
        guests.add(invitedPerson);
        invitedPerson = findById(callerId);
        deleteById(callerId);
    }
}
