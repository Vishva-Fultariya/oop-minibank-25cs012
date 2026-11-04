
public class ParkingLot {

    // Instance variables for vehicle counts
    private int twoWheelers;
    private int fourWheelers;

    // Maximum parking capacity
    private final int twoCap;
    private final int fourCap;

    // Static variable to track total revenue
    private static long revenue = 0;

    // Constructor
    public ParkingLot(int twoCap, int fourCap) {

        this.twoCap = twoCap;
        this.fourCap = fourCap;

        twoWheelers = 0;
        fourWheelers = 0;
    }

    // Method to park a vehicle
    public void park(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers < twoCap) {

                twoWheelers++;
                revenue += 20;

                System.out.println("Two-wheeler parked successfully.");
            } else {

                System.out.println("Full");
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers < fourCap) {

                fourWheelers++;
                revenue += 40;

                System.out.println("Four-wheeler parked successfully.");
            } else {

                System.out.println("Full");
            }

        } else {

            System.out.println("Invalid vehicle type!");
        }
    }

    // Method to remove a vehicle
    public void leave(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left successfully.");
            } else {
                System.out.println("No two-wheelers to leave.");
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left successfully.");
            } else {
                System.out.println("No four-wheelers to leave.");
            }

        } else {

            System.out.println("Invalid vehicle type!");
        }
    }

    // Main method
    public static void main(String[] args) {

        // Create parking lot with capacities
        ParkingLot lot = new ParkingLot(2, 1);

        System.out.println("===== PARKING LOT SYSTEM =====");

        // Park two-wheelers
        System.out.println("\nParking two-wheelers:");

        lot.park("two");
        lot.park("two");
        lot.park("two"); // Parking full

        // Park four-wheelers
        System.out.println("\nParking four-wheelers:");

        lot.park("four");
        lot.park("four"); // Parking full

        // Remove a two-wheeler
        System.out.println("\nLeaving vehicles:");

        lot.leave("two");

        // Park another two-wheeler
        lot.park("two");

        // Attempt to remove vehicles when occupancy is zero
        System.out.println("\nTesting empty parking section:");

        lot.leave("four");
        lot.leave("four");

        // Display final occupancy and revenue
        System.out.println("\n===== FINAL REPORT =====");

        System.out.println("Two-wheelers: " + lot.twoWheelers);
        System.out.println("Four-wheelers: " + lot.fourWheelers);

        System.out.println("Total Revenue: Rs. " + revenue);
    }
}
