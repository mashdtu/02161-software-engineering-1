Feature: Managing Registration of Users
    Scenario: New user is registered successfully
        Given an unregistered user "john"
        When "john" registers an account with 200 initial balance
        Then the account balance should be 200
        And the account username should be "john"

    Scenario: New user registers with negative balance
        Given an unregistered user "john"
        When "john" registers an account with -800 initial balance
        Then the program should throw an error

    Scenario: New user registers with zero balance
        Given an unregistered user "alice"
        When "alice" registers an account with 0 initial balance
        Then the account balance should be 0
        And the account username should be "alice"

    Scenario: Multiple users register with same name
        Given an unregistered user "bob"
        When "bob" registers an account with 500 initial balance
        And "bob" registers an account with 300 initial balance
        Then the account balance should be 300
        And the account username should be "bob"