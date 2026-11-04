
import java.util.Scanner;

// Record representing vehicle details
record Vehicle(String number, String type) {

}

public class TollBooth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Variables for total toll and vehicle counters
        int totalToll = 0;

        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        System.out.println("===== TOLL BOOTH SYSTEM =====");

        while (true) {

            System.out.print("\nEnter vehicle number (or done to stop): ");
            String number = sc.next().trim();

            // Stop when user enters done
            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.next().trim().toLowerCase();

            // Create Vehicle record
            Vehicle vehicle = new Vehicle(number, type);

            // Calculate toll using switch expression
            int toll = switch (vehicle.type()) {

                case "bike" -> {
                    bikeCount++;
                    yield 20;
                }

                case "car" -> {
                    carCount++;
                    yield 50;
                }

                case "truck" -> {
                    truckCount++;
                    yield 150;
                }

                default -> 0;
            };

            if (toll == 0) {
                System.out.println("Invalid vehicle type! Please try again.");
                continue;
            }

            totalToll += toll;

            System.out.println("Vehicle Number: " + vehicle.number());
            System.out.println("Vehicle Type: " + vehicle.type());
            System.out.println("Toll Amount: " + toll);
            System.out.println("Total Toll: " + totalToll);
        }

        // Find the highest vehicle count
        int highestCount = Math.max(
            bikeCount,
            Math.max(carCount, truckCount)
        );

        String mostFrequent = "None";

        if (highestCount > 0) {

            int typesWithHighestCount = 0;

            if (bikeCount == highestCount) {
                mostFrequent = "bike";
                typesWithHighestCount++;
            }

            if (carCount == highestCount) {
                mostFrequent = "car";
                typesWithHighestCount++;
            }

            if (truckCount == highestCount) {
                mostFrequent = "truck";
                typesWithHighestCount++;
            }

            if (typesWithHighestCount > 1) {
                mostFrequent = "Tie";
            }
        }

        // Display final results
        System.out.println("\n===== FINAL REPORT =====");
        System.out.println("Total toll: " + totalToll);
        System.out.println("Bike count: " + bikeCount);
        System.out.println("Car count: " + carCount);
        System.out.println("Truck count: " + truckCount);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}
