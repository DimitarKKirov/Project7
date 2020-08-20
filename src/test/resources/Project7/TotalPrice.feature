Feature: Calculating total price

  Scenario: Calculating total price of one item

    Given I have item in the basket
    And I open the basket
    Then I should see my total price

  Scenario Outline: Calculating total price of many items
    * I add <item> and <item1> in the basket
    * I open the basket
    * I see the total price of all items

    Examples:
      | item         | item1    |
      | banana       | socks    |
      | water        | meat     |
      | coffee       | fish     |
      | beer         | rum      |
      | toilet paper | soup     |
      | bread        | tomato's |
