Feature: create table My Wallet for every user

  Scenario Outline: I`m a user of the shop and I want to have shop wallet
    * Database shop exist
    * I`m a registered <User>
    * I have a digital <User Wallet>


    Examples:
      | User |User Wallet|



