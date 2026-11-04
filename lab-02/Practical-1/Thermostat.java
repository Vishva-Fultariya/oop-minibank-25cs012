
public class Thermostat {

    // Instance variables
    private String location;
    private int temperature;

    // Constants for temperature limits
    private static final int MIN = 16;
    private static final int MAX = 30;

    // Static variable to count thermostat objects
    private static int activeCount = 0;

    // Constructor with location and starting temperature
    public Thermostat(String location, int startTemp) {

        this.location = location;

        // Set temperature within the allowed range
        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }

        activeCount++;
    }

    // Constructor chaining using this()
    public Thermostat(String location) {
        this(location, 22);
    }

    // Method to increase temperature
    public void raise() {

        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (" + MAX + ")");
        }
    }

    // Method to decrease temperature
    public void lower() {

        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (" + MIN + ")");
        }
    }

    // Getter method for temperature
    public int getTemperature() {
        return temperature;
    }

    // Static getter method for active count
    public static int getActiveCount() {
        return activeCount;
    }

    // Main method
    public static void main(String[] args) {

        // Create two thermostat objects
        Thermostat t1 = new Thermostat("Living Room", 25);
        Thermostat t2 = new Thermostat("Bedroom");

        System.out.println("===== SMART THERMOSTAT =====");

        // Raise temperature 10 times
        System.out.println("\nRaising temperature:");

        for (int i = 1; i <= 10; i++) {

            t1.raise();

            System.out.println("Temperature: " + t1.getTemperature());
        }

        // Lower temperature 20 times
        System.out.println("\nLowering temperature:");

        for (int i = 1; i <= 20; i++) {

            t1.lower();

            System.out.println("Temperature: " + t1.getTemperature());
        }

        // Display active thermostat count
        System.out.println("\nActive Thermostats: " + getActiveCount());
    }
}
