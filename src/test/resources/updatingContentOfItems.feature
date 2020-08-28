Feature: updating prices and quantity of items

  Background: user is connected to database TheShop
    * user is connected to database TheShop

  @items
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

  @items
  Scenario: Changing  prices of one items
    When user enters "LG Monitor" of existing item in the table and 290
    Then the price of the item corresponding to the name is changed

  @items
  Scenario: Changing item quantity in stock
    When user search for item "LG Monitor" and then enter quantity of 25
    Then the item quantity that corresponds to the name is updated

