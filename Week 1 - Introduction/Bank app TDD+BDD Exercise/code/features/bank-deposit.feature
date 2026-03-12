Feature: Managing Deposits to the Bank
    Scenario: User sucessfully deposits money
        Given a registered user with an account balance of 1000
        When the user deposits 200
        Then the account balance should be 1200

    Scenario: User deposits negative money
        Given a registered user with an account balance of 1000
        When the user deposits -500
        Then the program should throw an error
        
    Scenario: Unregistered user attempts to deposit
        Given an unregistered user
        When the user deposits 700
        Then the program should throw an error

    Scenario: User deposits zero amount
        Given a registered user with an account balance of 1000
        When the user deposits 0
        Then the program should throw an error

    Scenario: User deposits a large amount
        Given a registered user with an account balance of 500
        When the user deposits 10000
        Then the account balance should be 10500