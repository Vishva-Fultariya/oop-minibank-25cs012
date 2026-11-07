
package model;

import java.io.Serializable;

public class SavingsAccount extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

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
