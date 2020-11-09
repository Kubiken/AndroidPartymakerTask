package com.example.partymakerreedited.presenter;

import com.example.partymakerreedited.activities.MainActivity;
import com.example.partymakerreedited.R;
import com.example.partymakerreedited.jsonParser.JsonParser;
import com.example.partymakerreedited.models.Event;

import java.io.InputStream;

public class EventPagePresenter {

    private final GuestView iGuestView;

    public EventPagePresenter(GuestView gv){
        iGuestView=gv;
    }

    public void initPage()
    {
        InputStream inputStream = ((MainActivity)iGuestView).getResources().openRawResource(R.raw.event);
        Event event = JsonParser.parseEvent(inputStream);

        iGuestView.buildMain(event);
        iGuestView.buildList(event);
    }

    public void refreshPage(Event event, String userId)
    {
        event.swap(userId);
        iGuestView.buildList(event);
    }
}
