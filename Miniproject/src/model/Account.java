package model;

import exception.AccountNotFoundException;
import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.Objects;
import model.annotation.Id;
import model.annotation.MaxLength;
import model.annotation.Positive;

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

    /*
     * synchronized ensures that only one thread can update
     * this account's balance through deposit() at a time.
     */
    @Override
    public synchronized void deposit(long amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance += amount;
    }

    /*
     * synchronized protects the balance check and deduction
     * as one indivisible operation.
     */
    @Override
    public synchronized boolean withdraw(long amount)
            throws InsufficientFundsException, InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (!active) {
            return false;
        }

        if (amount > balance) {
            long shortfall = amount - balance;

            throw new InsufficientFundsException(
                    "Insufficient balance in account " + accountNumber,
                    shortfall
            );
        }

        balance -= amount;

        return true;
    }

    public void transfer(Account to, long amount) throws BankException {
        try {
            if (to == null) {
                throw new AccountNotFoundException(
                        "Destination account not found."
                );
            }

            if (this == to || this.equals(to)) {
                throw new BankException(
                        "Cannot transfer money to the same account."
                );
            }

            if (!this.isActive()) {
                throw new BankException("Source account is inactive.");
            }

            if (!to.isActive()) {
                throw new BankException("Destination account is inactive.");
            }

            boolean withdrawn = withdraw(amount);

            if (!withdrawn) {
                throw new BankException("Withdrawal could not be completed.");
            }

            try {
                to.deposit(amount);
            } catch (BankException transferError) {
                // Restore the sender's money if the receiver deposit fails.
                try {
                    this.deposit(amount);
                } catch (BankException rollbackError) {
                    transferError.addSuppressed(rollbackError);
                }

                throw transferError;
            }

            System.out.println("Transfer successful: Rs. " + amount);

        } catch (BankException e) {
            System.out.println("Transfer failed: " + e.getMessage());
            throw e;

        } finally {
            System.out.println("Transfer operation completed.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /*
     * synchronized ensures that a thread reading the balance
     * sees a properly synchronized value.
     */
    @Override
    public synchronized double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber
                + ", Owner: " + ownerName
                + ", Balance: " + getBalance();
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