Feature: updating prices and quantity of items

  Background: user is connected to database TheShop
    * user is connected to database TheShop

  @itemsUpdate
  Scenario Outline: Changing  prices of items
    When user enters <ItemName> of existing item in the table and <price>
    Then the price of the item corresponding to the name is changed
    Examples:
      | ItemName             | price  |
      | LG Monitor           | 289.99 |
      | Game Pad Cougar-10cm | 14.99  |
      | Game Pad Cougar-15cm | 24.99  |
      | Headphones (China)   | 29.99  |
      | Logitech G903        | 310    |

  @itemsUpdate
  Scenario: Changing  prices of one items
    When user enters "LG Monitor" of existing item in the table and 290
    Then the price of the item corresponding to the name is changed

  @itemsUpdate
  Scenario: Changing item quantity in stock
    Then user changes the quantity value of needed item
      | itemName              | QuantityValue |
      | Mouse Pad Cougar-10cm | 245           |
      | Mouse Pad Cougar-15cm | 200           |
      | Logitech Keyboard     | 140           |
      | EarPlugs              | 99            |
      | PC Alienware          | 15            |

