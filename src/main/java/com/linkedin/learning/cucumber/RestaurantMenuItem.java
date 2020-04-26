package com.linkedin.learning.cucumber;

public class RestaurantMenuItem {
    final private String itemName;
    private String description;
    private int price;

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RestaurantMenuItem(String itemName, String description, int price) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
    }

}
