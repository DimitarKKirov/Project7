Feature: Remove all data from table users

  @DeleteUsers
  Scenario: Removing the data and resetting the ID counter

    Given user is connected to database TheShop
    Then the user clears table users