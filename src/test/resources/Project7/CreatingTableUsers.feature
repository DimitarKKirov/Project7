Feature: I want to create account for The Shop
  Background: User table
    Given A database The Shop exists
    When User register's an account
    Then his/her data is enter in table Users
    And fills in the columns "User ID","User E-mail","User First Name","User Last Name","User City","User Password"


  Scenario Outline: I click on register button
    Given I`m on The Shop Homepage
    When I click on create account
    And I will be able to enter My <E-mail>,<User First Name>,<User Last Name>,<Password>
    And I click on register
    Then I will receive a confirmation message for successful registration
    And I will receive welcome message
    Examples:
      | E-mail | User First Name | User Last Name | Password |