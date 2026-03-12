Feature: Managing Withdrawals in Bank Application
  As a bank user,
  I want to withdraw money from my account,
  So that my account balance is reduced accordingly.

  Scenario: User withdraws money successfully
    Given a registered user with an account balance of 1000
    When the user withdraws 200
    Then the account balance should be 800
