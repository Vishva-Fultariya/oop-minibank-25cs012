
package model;

import java.io.Serializable;

public class CurrentAccount extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final double INTEREST_RATE = 0.0;

    public CurrentAccount(String ownerName, long openingBalance) {
        super(ownerName, openingBalance);
    }

    public CurrentAccount(String ownerName) {
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
