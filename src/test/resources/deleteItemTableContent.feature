Feature: Remove all data from table Items

  @DeleteItems
  Scenario: Removing the data and resetting the ID counter

    Given user is connected to database TheShop
    Then the user clears item table