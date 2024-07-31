package com.example.climaact;

public class Plant {
    private String name;
    private String type;
    private double price;
    private int imageResourceId;

    public Plant(String name, String type, double price, int imageResourceId) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getName() { return name; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public int getImageResourceId() { return imageResourceId; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setPrice(double price) { this.price = price; }
    public void setImageResourceId(int imageResourceId) { this.imageResourceId = imageResourceId; }
}
