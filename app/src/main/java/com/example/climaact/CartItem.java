package com.example.climaact;

public class CartItem {
    private String itemName;
    private double itemPrice;

    public CartItem(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}
