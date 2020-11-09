package com.example.partymakerreedited.presenter;

import com.example.partymakerreedited.dataHolder.EventHolder;
import com.example.partymakerreedited.activities.MainActivity;
import com.example.partymakerreedited.R;
import com.example.partymakerreedited.interfaces.GuestView;
import com.example.partymakerreedited.jsonParser.JsonParser;
import com.example.partymakerreedited.models.Event;

import java.io.InputStream;

public class EventPagePresenter {

    private final GuestView GuestView;

    public EventPagePresenter(GuestView gv){
        GuestView=gv;
    }

    public void initPage() {
        InputStream inputStream = ((MainActivity)GuestView).getResources().openRawResource(R.raw.event);
        Event event = JsonParser.parseEvent(inputStream);
        EventHolder.getInstance().setEvent(event);

        GuestView.buildMain(event);
        GuestView.buildList(event);
    }

    public void refreshPage(String userId) {
        Event newEvent = EventHolder.getInstance().getEvent();
        newEvent.swap(userId);
        EventHolder.getInstance().setEvent(newEvent);
        GuestView.buildList(newEvent);
    }
}
