
package model;

import java.util.Objects;

import model.annotation.Id;
import model.annotation.Positive;
import model.annotation.MaxLength;

public abstract class Account implements Transactable, InterestBearing {

    @Id
    private final String accountNumber;

    @MaxLength(10)
    private String ownerName;

    @Positive
    private long balance;

    private boolean active;

    private static int accountCounter = 1;

    protected Account(String ownerName, long openingBalance) {

        this.accountNumber =
                String.format("AC%04d", accountCounter++);

        this.ownerName = ownerName;
        this.balance = openingBalance;
        this.active = true;
    }

    protected Account(String ownerName) {
        this(ownerName, 0);
    }

    public abstract double calculateInterest();

    @Override
    public void deposit(long amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        balance += amount;

        System.out.println("Deposit successful: " + amount);
    }

    @Override
    public boolean withdraw(long amount) {

        if (amount <= 0 || amount > balance || !active) {
            return false;
        }

        balance -= amount;

        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Owner: " + ownerName +
                ", Balance: " + balance;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Account other = (Account) obj;

        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
