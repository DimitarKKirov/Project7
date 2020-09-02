Feature: adding new columns to User Table


  @UpdateUsersColumn
  Scenario: adding new columns to existing table Users
    Given user is connected to database TheShop
    Then user adds this columns with this value types:
      | ColumnName | ValueType   |
      | ZipCode    | varchar(10) |
      | PostalCode | varchar(10) |