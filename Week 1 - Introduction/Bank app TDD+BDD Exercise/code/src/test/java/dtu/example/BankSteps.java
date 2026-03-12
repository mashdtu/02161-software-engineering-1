package dtu.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankSteps {
    Bank bank = new Bank();
    private String accountNumber;

    @Given("a registered user with an account balance of {int}")
    public void aRegisteredUserWithAnAccountBalanceOf(Integer initialBalance) {
        accountNumber = bank.register("John Doe", initialBalance);
    }

    @When("the user withdraws {int}")
    public void theUserWithdraws(Integer amount) {

        bank.withdraw(accountNumber, amount);
    }

    @Then("the account balance should be {int}")
    public void theAccountBalanceShouldBe(Integer expected) {
        assertEquals(expected, bank.getBalance(accountNumber));
    }
}

