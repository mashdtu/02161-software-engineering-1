package dtu.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankSteps {
    Bank bank = new Bank();
    private String accountNumber;
    private Exception thrownException;
    private String userName;
    private int initialMoney;
    private String consoleOutput;
    private Map<Integer, String> userAccounts = new HashMap<>();
    private int ledgerSize;

    @Given("a registered user with an account balance of {int}")
    public void aRegisteredUserWithAnAccountBalanceOf(Integer initialBalance) {
        accountNumber = bank.register("John Doe", initialBalance);
    }

    @When("the user withdraws {int}")
    public void theUserWithdraws(Integer amount) {
        try {
            bank.withdraw(accountNumber, amount);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("the account balance should be {int}")
    public void theAccountBalanceShouldBe(Integer expected) {
        assertEquals(expected, bank.getBalance(accountNumber));
    }

    @Given("a user {string} with {int} money")
    public void aUserWithMoney(String name, Integer money) {
        userName = name;
        initialMoney = money;
    }

    @When("{string} registers an account")
    public void userRegistersAnAccount(String name) {
        try {
            accountNumber = bank.register(userName, initialMoney);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("the account username should be {string}")
    public void theAccountUsernameShouldBe(String expectedName) {
        assertEquals(expectedName, bank.getUserName(accountNumber));
    }

    @Then("the program should throw an error")
    public void theProgramShouldThrowAnError() {
        if (thrownException == null) {
            throw new AssertionError("Expected an exception to be thrown, but none was thrown");
        }
    }

    @Given("an unregistered user {string}")
    public void anUnregisteredUser(String name) {
        userName = name;
    }

    @When("{string} registers an account with {int} initial balance")
    public void userRegistersAnAccountWithInitialBalance(String name, Integer balance) {
        try {
            accountNumber = bank.register(userName, balance);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @When("the user deposits {int}")
    public void theUserDeposits(Integer amount) {
        try {
            bank.deposit(accountNumber, amount);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Given("a registered user with an account number of {int}")
    public void aRegisteredUserWithAnAccountNumberOf(Integer accNum) {
        accountNumber = bank.register("User", 0);
    }

    @When("the user wants to access their account number")
    public void theUserWantsToAccessTheirAccountNumber() {
        try {
            consoleOutput = bank.getAccountNumber(accountNumber);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("the console should print {int}")
    public void theConsoleShouldPrint(Integer expected) {
        assertEquals(String.valueOf(expected), consoleOutput);
    }

    @When("the user wants to access their account balance")
    public void theUserWantsToAccessTheirAccountBalance() {
        try {
            consoleOutput = String.valueOf(bank.getBalance(accountNumber));
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Given("a registered user {string}")
    public void aRegisteredUser(String name) {
        accountNumber = bank.register(name, 0);
    }

    @When("the user wants to access their account username")
    public void theUserWantsToAccessTheirAccountUsername() {
        try {
            consoleOutput = bank.getUserName(accountNumber);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("the console should print {string}")
    public void theConsoleShouldPrintString(String expected) {
        assertEquals(expected, consoleOutput);
    }

    @Given("an unregistered user")
    public void anUnregisteredUser() {
        accountNumber = null;
    }

    @Given("a registered user with an account balance of {int} and an account number of {int}")
    public void aRegisteredUserWithBalanceAndAccountNumber(Integer balance, Integer userNum) {
        String accNum = bank.register("User" + userNum, balance);
        userAccounts.put(userNum, accNum);
    }

    @When("user {int} transfers {int} to user {int}")
    public void userTransfersToUser(Integer fromUser, Integer amount, Integer toUser) {
        try {
            bank.transfer(userAccounts.get(fromUser), userAccounts.get(toUser), amount);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("the account balance of user {int} should be {int}")
    public void theAccountBalanceOfUserShouldBe(Integer userNum, Integer expected) {
        assertEquals(expected, bank.getBalance(userAccounts.get(userNum)));
    }

    @Given("an unregistered user with an account number of {int}")
    public void anUnregisteredUserWithAccountNumber(Integer userNum) {
        userAccounts.put(userNum, null);
    }

    @When("the user views their transaction ledger")
    public void theUserViewsTheirTransactionLedger() {
        try {
            ledgerSize = bank.getLedgerSize(accountNumber);
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("the ledger should be empty")
    public void theLedgerShouldBeEmpty() {
        assertEquals(0, ledgerSize);
    }

    @Then("the ledger should contain {int} transactions")
    public void theLedgerShouldContainTransactions(Integer expected) {
        assertEquals(expected, ledgerSize);
    }

    @When("user {int} views their transaction ledger")
    public void userViewsTheirTransactionLedger(Integer userNum) {
        try {
            ledgerSize = bank.getLedgerSize(userAccounts.get(userNum));
            thrownException = null;
        } catch (Exception e) {
            thrownException = e;
        }
    }
}
