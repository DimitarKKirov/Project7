Feature: Creating table Orders

  @CreateOrders
  Scenario: Crating table Users for Shop
    Given user is connected to database TheShop
    Then user is creating Table Orders in database TheShop

      