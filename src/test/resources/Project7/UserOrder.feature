Feature: Creating Order

Scenario Outline: User creates Order

Given I have chosen an <items>
When I put them in the Basked and click By
Then I have created an order
  And the order is present in Database table Orders
  Examples:
    | items        |
    | banana       |
    | water        |
    | coffee       |
    | beer         |
    | toilet paper |
    | bread        |