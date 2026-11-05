
import java.util.Objects;

public abstract class Account {

    // Private instance variables
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    // Static counter for generating account numbers
    private static int accountCounter = 1;

    // Parameterized constructor
    protected Account(String ownerName, long openingBalance) {

        this.accountNumber =
                String.format("AC%04d", accountCounter++);

        this.ownerName = ownerName;
        this.balance = openingBalance;
        this.active = true;
    }

    // Constructor chaining
    protected Account(String ownerName) {
        this(ownerName, 0);
    }

    // Abstract method for calculating interest
    public abstract double calculateInterest();

    // Deposit method
    public void deposit(long amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        balance += amount;

        System.out.println("Deposit successful: " + amount);
    }

    // Withdraw method
    public boolean withdraw(long amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;

        return true;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for owner name
    public String getOwnerName() {
        return ownerName;
    }

    // Getter for balance
    public long getBalance() {
        return balance;
    }

    // Getter for active status
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
