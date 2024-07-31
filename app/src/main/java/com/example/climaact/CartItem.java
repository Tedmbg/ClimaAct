package com.example.climaact;

public class CartItem {
    private Plant plant;
    private int quantity;

    public CartItem(Plant plant, int quantity) {
        this.plant = plant;
        this.quantity = quantity;
    }

    // Getters
    public Plant getPlant() { return plant; }
    public int getQuantity() { return quantity; }

    // Setters
    public void setPlant(Plant plant) { this.plant = plant; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
