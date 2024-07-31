package com.example.climaact;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private static Cart instance;

    private Cart() {
        items = new ArrayList<>();
    }

    public static synchronized Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public List<CartItem> getItems() {
        return items;
    }

//    public void addItem(Plant plant) {
//        items.add(new CartItem(plant, quantity));
//    }

    public void clearCart() {
        items.clear();
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPlant().getPrice() * item.getQuantity();
        }
        return total;
    }
}
