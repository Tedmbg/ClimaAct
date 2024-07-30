package com.example.climaact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private ArrayList<EventItem> eventItems;

    public EventAdapter(ArrayList<EventItem> eventItems) {
        this.eventItems = eventItems;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventItem currentItem = eventItems.get(position);
        holder.textViewEventName.setText(currentItem.getEventName());
        holder.textViewEventDetails.setText(currentItem.getEventDetails());
        holder.textViewEventDate.setText(currentItem.getEventDate());
    }

    @Override
    public int getItemCount() {
        return eventItems.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewEventName;
        public TextView textViewEventDetails;
        public TextView textViewEventDate;

        public EventViewHolder(View itemView) {
            super(itemView);
            textViewEventName = itemView.findViewById(R.id.textViewEventName);
            textViewEventDetails = itemView.findViewById(R.id.textViewEventDetails);
            textViewEventDate = itemView.findViewById(R.id.textViewEventDate);
        }
    }
}
