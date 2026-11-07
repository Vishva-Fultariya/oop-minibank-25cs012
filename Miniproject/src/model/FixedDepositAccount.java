
package model;

import java.io.Serializable;

public class FixedDepositAccount extends Account implements Premium, Serializable {

    private static final long serialVersionUID = 1L;

    private static final double INTEREST_RATE = 0.07;

    public FixedDepositAccount(String ownerName, long openingBalance) {
        super(ownerName, openingBalance);
    }

    public FixedDepositAccount(String ownerName) {
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
