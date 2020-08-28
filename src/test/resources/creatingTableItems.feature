Feature: Creating table Items

  @CreateItems
  Scenario: Crating table for Shop, Items
    Given we are connected to database TheShop
    Then we crate Table item in database TheShop