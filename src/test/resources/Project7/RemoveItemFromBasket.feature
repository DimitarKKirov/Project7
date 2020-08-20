Feature: Removing items from basket

  Scenario Outline: I remove one item from basket
    Given I have <item> and <item1> in my basket
    When I remove <item> from my basket
    Then I have only one item in my basket
    And my total price is reduced with the removed item price

    Examples:
      | item         | item1    |
      | banana       | socks    |
      | water        | meat     |
      | coffee       | fish     |
      | beer         | rum      |
      | toilet paper | soup     |
      | bread        | tomato's |


    Scenario: I remove all items form the basket
      Given I have <item> and <item1> in my basket
      When I remove all items from my basket
      Then my total price is 0