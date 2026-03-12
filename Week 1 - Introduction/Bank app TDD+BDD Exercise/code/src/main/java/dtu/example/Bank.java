package dtu.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private class Account {
        private String userName;
        private int balance;
        private ArrayList<String> history;

        public ArrayList<String> getHistory() {
            return history;
        }
        
        public void addHistory(String s) {
            history.add(s);
        }

        public Account (String userName, int initialBalance) {
            this.userName = userName;
            this.balance = initialBalance;
            this.history = new ArrayList<>();
        }
    }

    private Map<String, Account> accounts = new HashMap<>();
    public String register(String userName, int initialBalance) {
        if (initialBalance < 0) {
            throw new RuntimeException("Initial balance cannot be negative.");
        }
        String accountNumber = String.valueOf(accounts.size() + 1);
        accounts.put(accountNumber, new Account(userName, initialBalance));
        return accountNumber;
    }

    public void withdraw(String accountId, int amount) {
        Account account = accounts.get(accountId);
        if (amount <= 0) {
            throw new RuntimeException("Withdrawal amount cannot be negative.");
        }
        if (account.balance < amount) {
            throw new RuntimeException("Insufficient balance.");
        }

        account.addHistory("Withdrew amount: " + amount + ".");
        account.balance -= amount;
        accounts.put(accountId, account);
    }

    public int getBalance(String accountId) {
        if (!accounts.containsKey(accountId)) {
            throw new RuntimeException("Account is not registered.");
        }
        System.out.println(accounts.get(accountId).balance);
        return accounts.get(accountId).balance;
    }

    public String getUserName(String accountId) {
        if (!accounts.containsKey(accountId)) {
            throw new RuntimeException("Account is not registered.");
        }
        System.out.println(accounts.get(accountId).userName);
        return accounts.get(accountId).userName;
    }

    // Kinda pointless but used for gherkin
    public String getAccountNumber(String accountId) {
        if (!accounts.containsKey(accountId)) {
            throw new RuntimeException("Account is not registered.");
        }
        System.out.println(accountId);
        return accountId;
    }

    public void deposit(String accountId, int amount) {
        Account account = accounts.get(accountId);
        if (amount <= 0) {
            throw new RuntimeException("Deposit amount cannot be negative.");
        }

        account.addHistory("Deposited amount: " + amount + ".");
        account.balance += amount;
        accounts.put(accountId, account);
    }

    public void transfer(String fromAccountId, String toAccountId, int amount) {
        if (!accounts.containsKey(fromAccountId)) {
            throw new RuntimeException("Source account is not registered.");
        }
        if (!accounts.containsKey(toAccountId)) {
            throw new RuntimeException("Destination account is not registered.");
        }
        if (amount <= 0) {
            throw new RuntimeException("Transfer amount cannot be negative.");
        }

        Account fromAccount = accounts.get(fromAccountId);
        if (fromAccount.balance < amount) {
            throw new RuntimeException("Insufficient balance for transfer.");
        }

        fromAccount.balance -= amount;
        fromAccount.addHistory("Transfered amount: " + amount + " to account number " + toAccountId + ".");
        accounts.put(fromAccountId, fromAccount);

        Account toAccount = accounts.get(toAccountId);
        toAccount.balance += amount;
        toAccount.addHistory("Recieved amount: " + amount + " from account number " + fromAccountId + ".");
        accounts.put(toAccountId, toAccount);
    }

    public int getLedgerSize(String accountId) {
        if (!accounts.containsKey(accountId)) {
            throw new RuntimeException("Account is not registered.");
        }
        Account account = accounts.get(accountId);
        return account.getHistory().size();
    }
}
