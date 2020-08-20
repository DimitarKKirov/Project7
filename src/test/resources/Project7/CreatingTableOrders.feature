Feature: Create table Orders

  Scenario: DB table Orders

    Given Database Shop exists
    When table Order is created
    And contains columns "Order ID","Account ID", "User Name", "Basket","Item Price","Item quantity" and "Total Price"
    Then table Orders is with empty rows