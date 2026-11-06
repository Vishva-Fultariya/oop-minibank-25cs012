
import java.util.HashMap;
import java.util.Map;

// Custom checked exception for insufficient stock
class OutOfStockException extends Exception {

    private int shortfall;

    public OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

// Custom checked exception for invalid quantity
class InvalidQuantityException extends Exception {

    public InvalidQuantityException(String message) {
        super(message);
    }
}

// Warehouse class
class Warehouse {

    private Map<String, Integer> stock;

    public Warehouse() {

        stock = new HashMap<>();

        stock.put("Laptop", 10);
        stock.put("Mouse", 5);
        stock.put("Keyboard", 8);
    }

    // Issue stock from warehouse
    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero."
            );
        }

        int available = stock.getOrDefault(item, 0);

        if (qty > available) {

            int shortfall = qty - available;

            throw new OutOfStockException(
                "Insufficient stock for " + item,
                shortfall
            );
        }

        stock.put(item, available - qty);

        System.out.println(
            "Successfully issued " + qty + " " + item + "(s)."
        );
    }

    // Display remaining stock
    public void displayStock() {

        System.out.println("\n===== REMAINING WAREHOUSE STOCK =====");

        for (String item : stock.keySet()) {

            System.out.println(
                item + ": " + stock.get(item)
            );
        }
    }
}

// Main class
public class StockIssue {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        // List of stock requests
        String[][] requests = {
            {"Laptop", "3"},
            {"Mouse", "8"},
            {"Keyboard", "0"},
            {"Keyboard", "4"}
        };

        System.out.println("===== WAREHOUSE STOCK ISSUE =====");

        for (int i = 0; i < requests.length; i++) {

            String item = requests[i][0];
            int qty = Integer.parseInt(requests[i][1]);

            System.out.println(
                "\nProcessing Request " + (i + 1) + ": "
                + item + ", Quantity: " + qty
            );

            try {

                warehouse.issue(item, qty);

            } catch (OutOfStockException e) {

                System.out.println("Error: " + e.getMessage());

                System.out.println(
                    "Shortfall: " + e.getShortfall()
                );

            } catch (InvalidQuantityException e) {

                System.out.println("Error: " + e.getMessage());

            }
        }

        warehouse.displayStock();

        System.out.println("\nAll requests processed.");
    }
}
