Feature: Creating data for Items table


  Background: Connecting to DB
    * user is connected to database TheShop

  @Items
  Scenario: Adding one Item to the table
    When user enter "Cougar Keyboard" for name
    And 149.99 for item price
    And 30 for item quantity
    Then user added the item to the table

  @Items
  Scenario Outline: Adding multiple items to the table
    When user enters <ItemName>, <ItemPrice> and <ItemQuantity>
    Then the items are added to the table
    Examples:
      | ItemName                 | ItemPrice | ItemQuantity |
      | LG Monitor               | 299.99    | 10           |
      | Game Pad Cougar-10cm     | 19.99     | 15           |
      | Game Pad Cougar-15cm     | 29.99     | 10           |
      | Logitech Keyboard        | 120       | 5            |
      | EarPlugs                 | 25.99     | 8            |
      | Headphones (China)       | 34.99     | 12           |
      | Logitech G903            | 299.99    | 3            |
      | PC Alienware             | 9899.99   | 2            |
      | Gaming Monitor Alienware | 699.99    | 3            |