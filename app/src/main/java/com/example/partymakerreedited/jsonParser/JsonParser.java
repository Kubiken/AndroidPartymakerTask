package com.example.partymakerreedited.jsonParser;

import com.example.partymakerreedited.models.Event;
import com.example.partymakerreedited.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class JsonParser {

    private static JSONObject convertToJson(InputStream inputStream)
    {
        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        try {
            JSONObject reader = new JSONObject(result);
            return reader;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Event parseEvent(InputStream stream)
    {
        Event event = new Event();
        try {
            JSONObject data = convertToJson(stream).getJSONObject("Event");
            event.setEventName(data.getString("eventName"));
            event.setEventPreviewImage(data.getString("previewUrl"));
            User inviter = getUser(data.getJSONObject("inviter"));
            event.setInviter(inviter);
            User invitedPerson = getUser(data.getJSONObject("invitedPerson"));
            event.setInvitedPerson(invitedPerson);
            ArrayList<User> guests = getGuests(data.getJSONArray("guests"));
            event.setGuests(guests);
            return event;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static User getUser(JSONObject data)
    {
        try {
            User u = new User(data.getString("avatarUrl"), data.getString("name"),
                    data.getString("id"));
            return u;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ArrayList<User> getGuests(JSONArray data)
    {
        ArrayList<User> guests = new ArrayList<User>();

        for (int i = 0; i < data.length(); i++) {
            try {
                guests.add(getUser(data.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }

        }
        return guests;
    }
}
