Feature: Entering price as search criteria returns the corresponding item to that price

  Background:
    Given user is connected to database TheShop

  @Items
  Scenario: User search by price
    When user enters 299.99 for price criteria
    Then user finds corresponding item

  @Items
  Scenario Outline:User search by entering price range
    When user enters minimal price <price> and maximum range of price <maxRange>
    Then user can find all the items in this range of prices
    Examples:
      | price  | maxRange |
      | 10.99  | 10000    |
      | 299.99 | 9899.99  |
      | 19.99  | 299.99   |
      | 25.99  | 699.99   |