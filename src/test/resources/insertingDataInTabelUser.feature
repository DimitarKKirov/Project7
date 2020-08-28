Feature: Inserting data in table User

  @Users
  Scenario Outline: Registering a user
    Given user is connected to database TheShop
    When user gives input for <FirsName>, <LastName>, <City>, <Address> and <E-mail>
    Then the user is registered as such in the database
    Examples:
      | FirsName | LastName | City    | Address                          | E-mail |
      | Dimita   | Kirov    | Sofia   | Address1,one hour away of office | @DK    |
      | Delqn    | Delev    | Sofia   | Address2,one hour away of office | @DD    |
      | Anton    | Rusanov  | Sofia   | Address3,one hour away of office | @AR    |
      | Georgi   | Vlaykov  | Sofia   | Address4,two hour away of office | @GV    |
      | Mafdet   | Barsen   | Unknown | In some server                   | @MB    |