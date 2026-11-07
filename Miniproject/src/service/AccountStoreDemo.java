
package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import model.Account;
import model.CurrentAccount;
import model.FixedDepositAccount;
import model.SavingsAccount;

/** Demonstrates Practical 12 collection operations in MiniBank. */
public class AccountStoreDemo {

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("       PRACTICAL 12: JAVA COLLECTIONS");
        System.out.println("===============================================");

        AccountStore store = new AccountStore();

        // Add three accounts with the practical's expected balances.
        Account account1 = new SavingsAccount("Vishva", 5000);
        Account account2 = new CurrentAccount("Dhruvi", 2000);
        Account account3 = new FixedDepositAccount("Madhav", 9000);

        store.add(account1);
        store.add(account2);
        store.add(account3);

        // Store transaction descriptions in an ArrayList.
        store.addTransaction("DEPOSIT " + account1.getAccountNumber() + " 500");
        store.addTransaction("WITHDRAW " + account2.getAccountNumber() + " 200");
        store.addTransaction("DEPOSIT " + account3.getAccountNumber() + " 1000");

        // Demonstrate HashMap lookup by account number.
        System.out.println("\n===== ACCOUNT LOOKUP USING HASHMAP =====");

        Account foundAccount = store.get("AC0002");

        if (foundAccount != null) {
            System.out.println("Account found:");
            System.out.println(foundAccount);
        } else {
            System.out.println("Account AC0002 was not found.");
        }

        // Demonstrate Comparator-based sorting by balance.
        System.out.println("\n===== ACCOUNTS SORTED BY BALANCE (DESCENDING) =====");

        for (Account account : store.sortedByBalance()) {
            System.out.println(account);
        }

        // Demonstrate Comparable<Account> by account number.
        System.out.println("\n===== ACCOUNTS SORTED BY ACCOUNT NUMBER (COMPARABLE) =====");

        ArrayList<Account> accountNumberOrder = store.getAll();
        Collections.sort(accountNumberOrder);

        for (Account account : accountNumberOrder) {
            System.out.println(account.getAccountNumber() + " - "
                    + account.getOwnerName());
        }

        // Demonstrate supplementary balance filtering.
        System.out.println("\n===== ACCOUNTS WITH BALANCE ABOVE RS. 3000 =====");

        for (Account account : store.getAccountsAboveBalance(3000)) {
            System.out.println(account);
        }

        // Demonstrate supplementary TreeMap key ordering.
        System.out.println("\n===== ACCOUNTS IN TREEMAP KEY ORDER =====");

        for (Map.Entry<String, Account> entry
                : store.getAccountsInSortedKeyOrder().entrySet()) {

            System.out.println(entry.getKey() + " - "
                    + entry.getValue().getOwnerName());
        }

        // Display the ArrayList transaction history.
        store.displayTransactionHistory();

        // Demonstrate ConcurrentHashMap for shared account access.
        System.out.println("\n===== THREAD-SAFE SHARED ACCOUNT REGISTRY =====");

        TransactionProcessor processor = new TransactionProcessor();

        for (Account account : store.getAll()) {
            processor.registerAccount(account);
        }

        Account sharedAccount = processor.getAccount("AC0002");

        System.out.println("Accounts registered: "
                + processor.getSharedAccountCount());

        System.out.println("ConcurrentHashMap lookup for AC0002:");
        System.out.println(sharedAccount);

        // No tasks are submitted in this collections demonstration.
        processor.stop();

        System.out.println("\nPractical 12 Part B collection demonstration completed.");
    }
}
