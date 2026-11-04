
public class Customer implements Cloneable {

    // Private instance variables
    private String name;
    private String email;
    private String mobile;

    // Unique customer ID
    private final String customerId;

    // Address object
    private Address address;

    // Static counter for generating customer IDs
    private static long customerCounter = 101;

    // Public static nested class
    public static class Address {

        private String line;
        private String city;
        private String pincode;

        // Constructor
        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        // Getters
        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }

        @Override
        public String toString() {
            return line + ", " + city + " - " + pincode;
        }
    }

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

    // Setter for address
    public void setAddress(Address address) {
        this.address = address;
    }

    // Getter for address
    public Address getAddress() {
        return address;
    }

    // Clone method
    @Override
    public Customer clone() {
        try {
            Customer copy = (Customer) super.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
