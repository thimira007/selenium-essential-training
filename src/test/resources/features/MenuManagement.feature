Feature: Menu Management

  Background: Setup a menu item
    Given I have a menu item with name "Chicken Salad" and price 20
    When I add that menu item
    Then Menu Item with name "Chicken Salad" should be added

  @SmokeTest
  Scenario: Add a menu item
    Given I have a menu item with name "Cucumber Sandwich" and price 20
    When I add that menu item
    Then Menu Item with name "Cucumber Sandwich" should be added

  @RegularTest
  Scenario: Add a menu item2
    Given I have a menu item with name "Cucumber Salad" and price 15
    When I add that menu item
    Then Menu Item with name "Cucumber Salad" should be added

  @NightlyBuildTest @RegularTest
  Scenario: Add a menu item3
    Given I have a menu item with name "Chicken Salad" and price 15
    When I add that menu item
    Then Menu Item with name "Chicken Salad" should be added