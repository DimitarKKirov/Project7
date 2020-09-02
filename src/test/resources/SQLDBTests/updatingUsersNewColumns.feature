Feature: Inserting missing data into the new columns

  @UpdatingUsersColumnData
  Scenario Outline: Updating data in table Users
    Given user is connected to database TheShop
    Then we updated the Postal Code for users living in the USA with input for "<Column>", "<ZipCode>" and user "<Email>"
    Examples:
      | Column  | Email | ZipCode |
      | ZipCode | @DK   | K23498  |
      | ZipCode | @DD   | D32478  |
      | ZipCode | @MB   | M99870  |

  @UpdatingUsersColumnData
  Scenario Outline: Updating data in table Users
    Given user is connected to database TheShop
    Then we updated the Postal Code for users living in BG with input for "<Column>", "<PostalCode>" and user "<Email>"
    Examples:
      | Column     | Email | PostalCode |
      | PostalCode | @AR   | 1367       |
      | PostalCode | @GV   | 1456       |
