@Orders
Feature: Users are buying items from the shop

  Background: user is connected to the shop
    Given user is connected to database TheShop

  Scenario: one user makes one order
    When user with E-mail "@DK" orders "LG Monitor" from the shop
    Then user created order in the Order table

  Scenario Outline: many user makes one order
    When this "<users>" make orders for an "<items>"
    Then the bought item is subtracted from the item quantity and Orders are created
    Examples:
      | users | items                    |
      | @DK   | Headphones (China)       |
      | @DD   | PC Alienware             |
      | @AR   | Gaming Monitor Alienware |