package model;

public interface InterestBearing {

    double interestRate();

    double getBalance();

    // Default method to calculate yearly interest
    default double yearlyInterest() {
        return getBalance() * interestRate();
    }

    // Additional default method to calculate monthly interest
    default double monthlyInterest() {
        return yearlyInterest() / 12;
    }
}