package com.linkedin.learning.stepdefinitions;

import com.linkedin.learning.cucumber.RestaurantMenu;
import com.linkedin.learning.cucumber.RestaurantMenuItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MenuManagementSteps {
    public MenuManagementSteps(){
        System.out.println("Constructor: Step Definition:MenuManagementSteps");
    }
    RestaurantMenuItem newMenuItem;
    RestaurantMenu restaurantMenu = new RestaurantMenu();

    @Given("I have a menu item with name {string} and price {int}")
    public void iHaveAMenuItemWithNameAndPrice(String itemName, int price) {
        this.newMenuItem = new RestaurantMenuItem(itemName, "", price);
        System.out.println("Step 1: Name: " + itemName + ", price: " + price);
    }

    @When("I add that menu item")
    public void iAddThatMenuItem() {
        this.restaurantMenu.addMenuItem(newMenuItem);
        System.out.println("Step 2: add item to menu");
    }

    @Then("Menu Item with name {string} should be added")
    public void menuItemWithNameShouldBeAdded(String menuItemName) {
        boolean exists = this.restaurantMenu.itemExists(menuItemName);
        Assert.assertTrue(exists);
        System.out.println("Step 3: item added: " + menuItemName);
    }
}
