
import java.util.Scanner;

// Enum representing the accepted coins
enum Coin {
    ONE, TWO, FIVE, TEN
}

public class VendingMachine {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Set snack price and initial total
        int snackPrice = 15;
        int total = 0;

        System.out.println("===== VENDING MACHINE =====");
        System.out.println("Snack Price: " + snackPrice);

        // Continue until the required amount is collected
        while (total < snackPrice) {

            System.out.print("Insert coin (ONE, TWO, FIVE, TEN): ");

            String input = sc.next().trim().toUpperCase();

            try {

                // Convert user input into Coin enum
                Coin coin = Coin.valueOf(input);

                // Switch expression to determine coin value
                int coinValue = switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };

                // Add coin value to the running total
                total = total + coinValue;

                System.out.println("Current Total: " + total);

            } catch (IllegalArgumentException e) {

                System.out.println("Invalid coin! Please try again.");
            }
        }

        // Calculate change
        int change = total - snackPrice;

        System.out.println("Paid. Change: " + change);

        sc.close();
    }
}
