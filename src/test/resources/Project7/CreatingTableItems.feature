Feature: Database table Items creation

  Scenario: Create table Items
    Given Database Shop exists
    When table Items is created
    And contains columns "Item ID","Item Name","Item Price","Item quantity"
    Then the table is with empty rows