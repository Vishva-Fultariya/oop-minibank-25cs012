
package app;

import discount.DiscountRule;
import java.util.ArrayList;
import java.util.Scanner;

public class DiscountEngine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Store product prices
        ArrayList<Double> prices = new ArrayList<>();

        prices.add(1000.0);
        prices.add(2000.0);
        prices.add(500.0);
        prices.add(1500.0);

        System.out.println("===== DISCOUNT ENGINE =====");

        System.out.println("\nAvailable Product Prices:");

        for (int i = 0; i < prices.size(); i++) {
            System.out.printf("Product %d: Rs. %.2f%n",
                    i + 1, prices.get(i));
        }

        // Display discount rules
        System.out.println("\nSelect a Discount Rule:");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Flat Rs. 100 Discount");
        System.out.println("4. No Discount");

        System.out.print("\nEnter your choice (1-4): ");
        int choice = scanner.nextInt();

        // Select a discount rule using a lambda expression
        DiscountRule selectedRule;

        switch (choice) {

            case 1:
                selectedRule = price -> price * 0.90;
                break;

            case 2:
                selectedRule = price -> price * 0.80;
                break;

            case 3:
                selectedRule = price -> Math.max(0, price - 100);
                break;

            case 4:
                selectedRule = price -> price;
                break;

            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        // Apply selected discount to all product prices
        System.out.println("\n===== DISCOUNTED PRICES =====");

        double originalTotal = 0;
        double discountedTotal = 0;

        for (int i = 0; i < prices.size(); i++) {

            double originalPrice = prices.get(i);

            double finalPrice =
                    selectedRule.applyDiscount(originalPrice);

            originalTotal += originalPrice;
            discountedTotal += finalPrice;

            System.out.printf(
                    "Product %d: Rs. %.2f -> Rs. %.2f%n",
                    i + 1, originalPrice, finalPrice
            );
        }

        System.out.println("--------------------------------");

        System.out.printf("Original Total: Rs. %.2f%n",
                originalTotal);

        System.out.printf("Discounted Total: Rs. %.2f%n",
                discountedTotal);

        System.out.printf("Total Savings: Rs. %.2f%n",
                originalTotal - discountedTotal);

        System.out.println("\nDiscount applied successfully!");

        scanner.close();
    }
}
