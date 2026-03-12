Feature: Allowing users to view their transaction history
    Scenario: A registered user with no transactions views their ledger
        Given a registered user with an account balance of 1000
        When the user views their transaction ledger
        Then the ledger should be empty

    Scenario: A registered user with deposits views their ledger
        Given a registered user with an account balance of 500
        When the user deposits 200
        And the user deposits 100
        And the user views their transaction ledger
        Then the ledger should contain 2 transactions

    Scenario: A registered user with withdrawals views their ledger
        Given a registered user with an account balance of 1000
        When the user withdraws 200
        And the user withdraws 150
        And the user views their transaction ledger
        Then the ledger should contain 2 transactions

    Scenario: A registered user with mixed transactions views their ledger
        Given a registered user with an account balance of 1000
        When the user deposits 500
        And the user withdraws 200
        And the user deposits 100
        And the user views their transaction ledger
        Then the ledger should contain 3 transactions

    Scenario: An unregistered user tries to view their ledger
        Given an unregistered user
        When the user views their transaction ledger
        Then the program should throw an error

    Scenario: A registered user views ledger after transfers
        Given a registered user with an account balance of 2000 and an account number of 1
        And a registered user with an account balance of 500 and an account number of 2
        When user 1 transfers 300 to user 2
        And user 1 views their transaction ledger
        Then the ledger should contain 1 transactions
