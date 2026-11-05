
public class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04;

    // Constructor
    public SavingsAccount(String ownerName, long openingBalance) {
        super(ownerName, openingBalance);
    }

    // Calculate interest
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}
