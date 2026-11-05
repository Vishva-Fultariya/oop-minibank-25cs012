
public class CurrentAccount extends Account {

    private static final double INTEREST_RATE = 0.0;

    // Constructor
    public CurrentAccount(String ownerName, long openingBalance) {
        super(ownerName, openingBalance);
    }

    // Calculate interest
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}
