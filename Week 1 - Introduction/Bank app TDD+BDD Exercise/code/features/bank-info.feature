Feature: Allowing the user access to information about their account
    Scenario: A registered user wants to see their account number
        Given a registered user with an account number of 1
        When the user wants to access their account number
        Then the console should print 1

    Scenario: A registered user wants to see their account balance
        Given a registered user with an account balance of 2000
        When the user wants to access their account balance
        Then the console should print 2000

    Scenario: A registered user wants to see their account username
        Given a registered user "john"
        When the user wants to access their account username
        Then the console should print "john"

    Scenario: An unregistered user wants to see their account number
        Given an unregistered user
        When the user wants to access their account number
        Then the program should throw an error

    Scenario: An unregistered user wants to see their account balance
        Given an unregistered user
        When the user wants to access their account balance
        Then the program should throw an error

    Scenario: An unregistered user wants to see their account username
        Given an unregistered user
        When the user wants to access their account username
        Then the program should throw an error

    Scenario: A registered user with zero balance checks their balance
        Given a registered user with an account balance of 0
        When the user wants to access their account balance
        Then the console should print 0

    Scenario: Multiple registered users check their information
        Given a registered user "alice"
        And a registered user "bob"
        When the user wants to access their account username
        Then the console should print "bob"