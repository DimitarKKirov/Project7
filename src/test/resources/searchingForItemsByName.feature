Feature: We can search the DB for items by there name

  @Items
  Scenario: Finding item in the DB by its name
    Given user is connected to database TheShop
    When User enters the name of the item in the search method like "Logitech Keyboard"
    Then the item is found
    And printed in the console