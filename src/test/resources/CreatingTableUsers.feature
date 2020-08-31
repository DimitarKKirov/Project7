Feature: Creating table users

  @CreateUsers
  Scenario: Crating table Users for Shop
    Given user is connected to database TheShop
    Then he crates table Users


  @UpdateUsersColumn
  Scenario: adding new columns to existing table Users
    Given user is connected to database TheShop
    Then user adds this columns with this value types:
      | ColumnName | ValueType   |
      | ZipCode    | varchar(10) |
      | PostalCode | varchar(10) |

