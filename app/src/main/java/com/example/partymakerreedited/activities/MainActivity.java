package com.example.partymakerreedited.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.partymakerreedited.R;
import com.example.partymakerreedited.adapters.GuestRecyclerViewAdapter;
import com.example.partymakerreedited.imageWorker.ImageLoader;
import com.example.partymakerreedited.models.Event;
import com.example.partymakerreedited.presenter.EventPagePresenter;
import com.example.partymakerreedited.presenter.GuestView;

public class MainActivity extends AppCompatActivity implements
GuestRecyclerViewAdapter.onGuestClickListner, GuestView {

    private ImageView eventPreviewImageView, inviterAvatar;
    private RecyclerView guestsRecyclerView;
    private EventPagePresenter eventPagePresenter;
    private TextView eventName, inviterName, comeWith;
    private Event event;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guestsRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewGuestList);
        eventPreviewImageView = (ImageView)findViewById(R.id.imageViewEventPreview);
        inviterAvatar = (ImageView)findViewById(R.id.imageViewInviterAvatar);
        eventName = (TextView)findViewById(R.id.textViewEventName);
        inviterName = (TextView)findViewById(R.id.textViewInviterName);
        comeWith = (TextView)findViewById(R.id.textViewComeWithYou);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eventPagePresenter = new EventPagePresenter(this);

        eventPagePresenter.initPage();
    }

    public void onGuestClick(String userId) {
        eventPagePresenter.refreshPage(event, userId);
    }

    @Override
    public void buildList(Event event) {

        StringBuilder sb = new StringBuilder();
        String space = " ";
        String comeWithString = sb.append(getResources().getText(R.string.with)).
                append(space).append(event.getInvitedPerson().getName()).
                append(space).append(getResources().getText(R.string.come)).toString();
        comeWith.setText(comeWithString);

        GuestRecyclerViewAdapter grva = new GuestRecyclerViewAdapter(this, event.getGuests(), this);
        guestsRecyclerView.setAdapter(grva);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        guestsRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void buildMain(Event event) {

        this.event = event;
        ImageLoader.loadImg(eventPreviewImageView,event.getEventPreviewImage(),this);
        ImageLoader.loadRoundedImg(inviterAvatar,event.getInviter().getAvatarUrl(), this);

        StringBuilder sb = new StringBuilder();
        String space = " ";
        String invitedBy = sb.append(getResources().getText(R.string.invited_by)).append(" ").
                append(event.getInviter().getName()).toString();
        eventName.setText(event.getEventName());
        inviterName.setText(invitedBy);
    }
}