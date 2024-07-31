package com.example.climaact;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder> {
    private List<Plant> plants;
    private OnPlantClickListener listener;

    public PlantAdapter(List<Plant> plants, OnPlantClickListener listener) {
        this.plants = plants;
        this.listener = listener;
    }

    @Override
    public PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new PlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlantViewHolder holder, int position) {
        Plant plant = plants.get(position);
        holder.bind(plant, listener);
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    static class PlantViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView priceTextView;
        Button addButton;

        PlantViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.plantImageView);
            nameTextView = itemView.findViewById(R.id.plantNameTextView);
            priceTextView = itemView.findViewById(R.id.plantPriceTextView);
            addButton = itemView.findViewById(R.id.addToCartButton);
        }

        void bind(final Plant plant, final OnPlantClickListener listener) {
            imageView.setImageResource(plant.getImageResourceId());
            nameTextView.setText(plant.getName());
            priceTextView.setText(String.format("$%.2f", plant.getPrice()));
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlantClick(plant);
                }
            });
        }
    }

    public interface OnPlantClickListener {
        void onPlantClick(Plant plant);
    }
}
