Feature: I click buy but no items in the basket

  Scenario: I have empty basket and I click buy
    Given I have opened the basket
    When I click buy
    But the basket is empty
    Then I get a message "Basket is empty"