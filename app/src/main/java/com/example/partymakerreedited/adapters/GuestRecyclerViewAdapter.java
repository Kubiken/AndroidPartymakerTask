package com.example.partymakerreedited.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.partymakerreedited.imageWorker.ImageLoader;
import com.example.partymakerreedited.R;
import com.example.partymakerreedited.models.User;

import java.util.ArrayList;

/**
 * Adapter for recyclerview with list of guests
 */

public class GuestRecyclerViewAdapter extends RecyclerView.Adapter<GuestRecyclerViewAdapter.guestRecyclerViewHolder>
 {

    Context context;
    ArrayList<User> users;
    private GuestRecyclerViewAdapter.onGuestClickListner onGuestClickListner;

    public GuestRecyclerViewAdapter(Context context, ArrayList<User> users, GuestRecyclerViewAdapter.onGuestClickListner onGuestClickListner)
    {
        this.context = context;
        this.users = users;
        this.onGuestClickListner=onGuestClickListner;
    }

    @NonNull
    @Override
    public guestRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.guest_list_element, parent, false);
        return new guestRecyclerViewHolder(view, onGuestClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull guestRecyclerViewHolder holder, int position) {
        User currentUser = users.get(position);
        holder.tv.setText(currentUser.getName());

        ImageLoader.loadRoundedImg(holder.iv,currentUser.getAvatarUrl(),context);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class guestRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView iv;
        TextView tv;
        GuestRecyclerViewAdapter.onGuestClickListner onGuestClickListner;

        public guestRecyclerViewHolder(@NonNull View itemView, GuestRecyclerViewAdapter.onGuestClickListner onGuestClickListner) {
            super(itemView);
        iv = itemView.findViewById(R.id.guestAvatar);
        tv = itemView.findViewById(R.id.guestName);
        this.onGuestClickListner=onGuestClickListner;
        itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onGuestClickListner.onGuestClick(users.get(getAdapterPosition()).getId());
        }
    }

    public interface onGuestClickListner
     {
         public void onGuestClick(String userId);
     }
}
