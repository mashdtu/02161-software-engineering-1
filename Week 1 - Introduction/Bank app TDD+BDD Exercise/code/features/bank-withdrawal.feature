Feature: Managing Withdrawals in Bank Application
  As a bank user,
  I want to withdraw money from my account,
  So that my account balance is reduced accordingly.

  Scenario: User withdraws money successfully
    Given a registered user with an account balance of 1000
    When the user withdraws 200
    Then the account balance should be 800

  Scenario: User withdraws negative amount
    Given a registered user with an account balance of 500
    When the user withdraws -200
    Then the program should throw an error

  Scenario: User withdraw exceeds balance
    Given a registered user with an account balance of 100
    When the user withdraws 300
    Then the program should throw an error

  Scenario: Unregistered user attempts to withdraw
    Given an unregistered user
    When the user withdraws 800
    Then the program should throw an error

  Scenario: User withdraws zero amount
    Given a registered user with an account balance of 500
    When the user withdraws 0
    Then the program should throw an error

  Scenario: User withdraws their entire balance
    Given a registered user with an account balance of 1000
    When the user withdraws 1000
    Then the account balance should be 0