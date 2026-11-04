
public class CinemaShow {

    // Instance variables
    private String title;
    private int seatsAvailable;

    // Final variable for maximum capacity
    private final int capacity;

    // Static variable to track total successful bookings
    private static int totalBooked = 0;

    // Constructor with title and capacity
    public CinemaShow(String title, int capacity) {

        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor chaining
    public CinemaShow(String title) {
        this(title, 100);
    }

    // Method to book seats
    public boolean book(int n) {

        if (n > 0 && n <= seatsAvailable) {

            seatsAvailable = seatsAvailable - n;
            totalBooked += n;

            return true;

        } else {

            return false;
        }
    }

    // Method to cancel seats
    public void cancel(int n) {

        if (n > 0) {

            seatsAvailable = Math.min(capacity, seatsAvailable + n);
        }
    }

    // Getter for available seats
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    // Static getter for total booked seats
    public static int getTotalBooked() {
        return totalBooked;
    }

    // Main method
    public static void main(String[] args) {

        // Create a cinema show
        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("===== CINEMA SHOW SYSTEM =====");
        System.out.println("Movie: " + show.title);
        System.out.println("Total Capacity: " + show.capacity);

        // First booking
        System.out.println("\nBooking 10 seats:");

        boolean result = show.book(10);

        System.out.println("Booking Successful: " + result);
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        // Second booking
        System.out.println("\nBooking 45 seats:");

        result = show.book(45);

        System.out.println("Booking Successful: " + result);
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        // Third booking
        System.out.println("\nBooking 15 seats:");

        result = show.book(15);

        System.out.println("Booking Successful: " + result);
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        // Cancel seats
        System.out.println("\nCancelling 5 seats:");

        show.cancel(5);

        System.out.println("Available Seats: " + show.getSeatsAvailable());

        // Cancel more seats than the remaining capacity
        System.out.println("\nCancelling 100 seats:");

        show.cancel(100);

        System.out.println("Available Seats: " + show.getSeatsAvailable());

        // Display total successful bookings
        System.out.println("\nTotal Booked Seats: " + getTotalBooked());
    }
}
