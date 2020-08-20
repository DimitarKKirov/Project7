Feature: I want to pay from My Wallet

  Scenario: I`m a registered user and I want to pay from My Wallet
    Given I`m in the basket
    When I click on buy
    And I receive a message "Do you want to pay from My Wallet"
    And I click "yes"
    Then the total price is subtracted from My Wallet and I buy my items
    But if I don`t have enough money I get the massage "Not enough minerals"


    Scenario: I`m a guest and I cant pay via My Wallet
      Given I`m in the basket
      When I click on buy
      Then I`m asked of choose a payment method