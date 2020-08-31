Feature: Inserting data in table User

  @Users
  Scenario Outline: Registering a user
    Given user is connected to database TheShop
    When user gives input for "<FirsName>", "<LastName>", "<City>", "<Address>" and "<E-mail>"
    Then the user is registered as such in the database
    Examples:
      | FirsName | LastName | City         | Address                          | E-mail |
      | Dimitar  | Kirov    | Chicago      | Address1,one hour away of office | @DK    |
      | Delqn    | Delev    | Dallas       | Address2,one hour away of office | @DD    |
      | Anton    | Rusanov  | Sofia        | Address3,one hour away of office | @AR    |
      | Georgi   | Vlaykov  | Sofia        | Address4,two hour away of office | @GV    |
      | Mafdet   | Barsen   | Philadelphia | In some server                   | @MB    |

  @Users
  Scenario Outline: Updating data in table Users
    Given user is connected to database TheShop
    Then we updated the Postal Code for users living in the USA with input for "<Column>", "<ZipCode>" and user "<Email>"
    Examples:
      | Column  | Email | ZipCode |
      | ZipCode | @DK   | K23498  |
      | ZipCode | @DD   | D32478  |
      | ZipCode | @MB   | M99870  |

  @Users
  Scenario Outline: Updating data in table Users
    Given user is connected to database TheShop
    Then we updated the Postal Code for users living in BG with input for "<Column>", "<PostalCode>" and user "<Email>"
    Examples:
      | Column     | Email | PostalCode |
      | PostalCode | @AR   | 1367       |
      | PostalCode | @GV   | 1456       |

