
public class FixedDepositAccount extends Account {

    private static final double INTEREST_RATE = 0.07;

    // Constructor
    public FixedDepositAccount(String ownerName, long openingBalance) {
        super(ownerName, openingBalance);
    }

    // Calculate interest
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}
