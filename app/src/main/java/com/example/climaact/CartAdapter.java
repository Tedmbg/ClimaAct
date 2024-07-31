package com.example.climaact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<CartItem> cartItems;
    private OnCartItemChangeListener listener;

    public CartAdapter(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public CartAdapter(List<CartItem> cartItems, OnCartItemChangeListener listener) {
        this.cartItems = (ArrayList<CartItem>) cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem currentItem = cartItems.get(position);
        holder.textViewItemName.setText(currentItem.getPlant().getName());
        holder.textViewItemPrice.setText(String.format("$%.2f", currentItem.getPlant().getPrice()));
        holder.textViewQuantity.setText(String.valueOf(currentItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public interface OnCartItemChangeListener {
        void onQuantityChanged();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItemName;
        public TextView textViewItemPrice;
        public TextView textViewQuantity;

        public CartViewHolder(View itemView) {
            super(itemView);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            textViewItemPrice = itemView.findViewById(R.id.textViewItemPrice);
//            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
        }
    }
}
