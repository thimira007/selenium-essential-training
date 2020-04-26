package com.linkedin.learning.cucumber;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {
    List<RestaurantMenuItem> menuItemList;

    public RestaurantMenu() {
        this.menuItemList =  new ArrayList<>();
    }

    public void addMenuItem(RestaurantMenuItem menuItem) {
        if(itemExists(menuItem.getItemName())){
            throw  new IllegalArgumentException("Duplicate Item");
        }
        this.menuItemList.add(menuItem);
    }

    public boolean itemExists(String name) {
        boolean found = false;
        for (RestaurantMenuItem menuItem : menuItemList) {
            if (menuItem.getItemName().equals(name)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
