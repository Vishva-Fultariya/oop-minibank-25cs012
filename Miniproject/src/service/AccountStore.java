
package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

import model.Account;

/**
 * Stores bank accounts and transaction history using Java collections.
 */
public class AccountStore {

    // HashMap provides account lookup using account number as the key.
    private final HashMap<String, Account> accounts;

    // ArrayList maintains the order in which transactions are recorded.
    private final ArrayList<String> transactionHistory;

    public AccountStore() {
        accounts = new HashMap<>();
        transactionHistory = new ArrayList<>();
    }

    /** Adds an account to the store. */
    public void add(Account account) {
        Objects.requireNonNull(account, "Account cannot be null.");
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account added successfully: "
                + account.getAccountNumber());
    }

    /** Retrieves an account using its account number. */
    public Account get(String accountNumber) {
        return accounts.get(accountNumber);
    }

    /** Returns all accounts as a new ArrayList. */
    public ArrayList<Account> getAll() {
        return new ArrayList<>(accounts.values());
    }

    /** Adds a transaction description to the history. */
    public void addTransaction(String transaction) {
        Objects.requireNonNull(transaction, "Transaction cannot be null.");
        transactionHistory.add(transaction);
    }

    /** Returns a copy of the transaction history. */
    public ArrayList<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    /** Returns accounts sorted by balance, highest balance first. */
    public ArrayList<Account> sortedByBalance() {
        ArrayList<Account> sortedAccounts = getAll();

        sortedAccounts.sort(
                Comparator.comparingDouble(Account::getBalance)
                        .reversed()
                        .thenComparing(Account::getAccountNumber)
        );

        return sortedAccounts;
    }

    /** Supplementary: returns accounts whose balance exceeds the given value. */
    public ArrayList<Account> getAccountsAboveBalance(double minimumBalance) {
        ArrayList<Account> result = new ArrayList<>();

        for (Account account : accounts.values()) {
            if (account.getBalance() > minimumBalance) {
                result.add(account);
            }
        }

        result.sort(
                Comparator.comparingDouble(Account::getBalance).reversed()
        );

        return result;
    }

    /** Supplementary: returns accounts in account-number order using TreeMap. */
    public TreeMap<String, Account> getAccountsInSortedKeyOrder() {
        TreeMap<String, Account> sortedAccounts = new TreeMap<>();
        sortedAccounts.putAll(accounts);
        return sortedAccounts;
    }

    public void displayAll() {
        for (Account account : getAll()) {
            System.out.println(account);
        }
    }

    public void displayTransactionHistory() {
        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions recorded.");
            return;
        }

        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public int size() {
        return accounts.size();
    }
}
