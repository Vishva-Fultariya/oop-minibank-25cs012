package model;

public class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String ownerName, long openingBalance) {
        super(ownerName, openingBalance);
    }

    public SavingsAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public double interestRate() {
        return INTEREST_RATE;
    }

    @Override
    public double calculateInterest() {
        return yearlyInterest();
    }
}