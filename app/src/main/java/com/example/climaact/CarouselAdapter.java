package com.example.climaact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {

    // Images to display in the carousel
    private final int[] images = {
            R.drawable.donate,
            R.drawable.karura,
            R.drawable.ngong
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the carousel item layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the image for the current position
        int image = images[position];
        // Set the image resource
        holder.imageView.setImageResource(image);

        // Optionally adjust scaleType programmatically if needed
        holder.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // or FIT_XY
    }

    @Override
    public int getItemCount() {
        // Return the total count of items in the carousel
        return images.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // Define the ImageView for the item
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            // Initialize the ImageView
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
