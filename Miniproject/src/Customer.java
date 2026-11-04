
public class Customer {

    // Private instance variables
    private String name;
    private String email;
    private String mobile;

    // Unique customer ID
    private final String customerId;

    // Static counter for generating customer IDs
    private static long customerCounter = 101;

    // Private static method to generate customer ID
    private static String generateCustomerId() {

        return "CUST" + customerCounter++;
    }

    // Constructor
    public Customer(String name, String email, String mobile) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;

        this.customerId = generateCustomerId();
    }

    // Getter for customer ID
    public String getCustomerId() {
        return customerId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Getter for mobile
    public String getMobile() {
        return mobile;
    }
}
