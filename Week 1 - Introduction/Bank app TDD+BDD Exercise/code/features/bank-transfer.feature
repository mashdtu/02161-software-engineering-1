Feature: Allowing users to transfer money between accounts
    Scenario: A registered user transfers money to another user
        Given a registered user with an account balance of 2000 and an account number of 1
        And a registered user with an account balance of 800 and an account number of 2
        When user 1 transfers 250 to user 2
        Then the account balance of user 1 should be 1750
        And the account balance of user 2 should be 1050

    Scenario: A user transfers with insufficient balance
        Given a registered user with an account balance of 100 and an account number of 1
        And a registered user with an account balance of 500 and an account number of 2
        When user 1 transfers 200 to user 2
        Then the program should throw an error

    Scenario: A user transfers a negative amount
        Given a registered user with an account balance of 1000 and an account number of 1
        And a registered user with an account balance of 500 and an account number of 2
        When user 1 transfers -100 to user 2
        Then the program should throw an error

    Scenario: A user transfers zero amount
        Given a registered user with an account balance of 1000 and an account number of 1
        And a registered user with an account balance of 500 and an account number of 2
        When user 1 transfers 0 to user 2
        Then the program should throw an error

    Scenario: A user transfers their entire balance
        Given a registered user with an account balance of 1000 and an account number of 1
        And a registered user with an account balance of 500 and an account number of 2
        When user 1 transfers 1000 to user 2
        Then the account balance of user 1 should be 0
        And the account balance of user 2 should be 1500

    Scenario: An unregistered user tries to transfer money
        Given an unregistered user with an account number of 1
        And a registered user with an account balance of 500 and an account number of 2
        When user 1 transfers 100 to user 2
        Then the program should throw an error

    Scenario: A user tries to transfer to an unregistered user
        Given a registered user with an account balance of 1000 and an account number of 1
        And an unregistered user with an account number of 2
        When user 1 transfers 100 to user 2
        Then the program should throw an error

    Scenario: Both users are unregistered
        Given an unregistered user with an account number of 1
        And an unregistered user with an account number of 2
        When user 1 transfers 100 to user 2
        Then the program should throw an error