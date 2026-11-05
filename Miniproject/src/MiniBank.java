
import java.util.Scanner;

// Record to store bank information
record BankInfo(String name, String branch) {
}

// Enum representing available banking operations
enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Bank information
        BankInfo bank = new BankInfo("MiniBank", "Main Branch");

        System.out.println("=================================");
        System.out.println("       " + bank.name());
        System.out.println("       " + bank.branch());
        System.out.println("=================================");

        // Create a Customer object
        Customer customer = new Customer(
                "Vishva",
                "vishva@example.com",
                "9876543210"
        );

        System.out.println("\n===== CUSTOMER DETAILS =====");
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Mobile: " + customer.getMobile());

        // Create three Account objects
        Account[] accounts = {
            new Account("Vishva", 5000),
            new Account("Dhruvi", 2000),
            new Account("Madhav")
        };

        // Perform deposits and withdrawals
        System.out.println("\n===== ACCOUNT OPERATIONS =====");

        accounts[0].deposit(2000);

        System.out.println("Withdrawal: "
                + accounts[0].withdraw(3000));

        System.out.println("Withdrawal: "
                + accounts[0].withdraw(10000));

        accounts[1].deposit(500);
        accounts[2].deposit(1000);

        // Demonstrate toString()
        System.out.println("\n===== ACCOUNT DETAILS (toString) =====");

        for (Account account : accounts) {
            System.out.println(account);
        }

        // Demonstrate equals()
        System.out.println("\n===== ACCOUNT EQUALITY =====");

        Account account1 = accounts[0];
        Account account2 = accounts[1];

        System.out.println("Account 1: " + account1.getAccountNumber());
        System.out.println("Account 2: " + account2.getAccountNumber());

        System.out.println("Are both accounts equal? "
                + account1.equals(account2));

        // Demonstrate instanceof
        System.out.println("\n===== INSTANCEOF DEMONSTRATION =====");

        Object obj = accounts[0];

        if (obj instanceof Account) {
            System.out.println("The object belongs to Account class.");
        }

        // Demonstrate static nested Address class
        System.out.println("\n===== CUSTOMER ADDRESS =====");

        Customer.Address address = new Customer.Address(
                "ABC Road",
                "Anand",
                "388001"
        );

        customer.setAddress(address);

        System.out.println("Address: " + customer.getAddress());

        // Demonstrate clone()
        System.out.println("\n===== CUSTOMER CLONING =====");

        Customer clonedCustomer = customer.clone();

        System.out.println("Original Customer ID: "
                + customer.getCustomerId());

        System.out.println("Cloned Customer ID: "
                + clonedCustomer.getCustomerId());

        System.out.println("Original Customer Name: "
                + customer.getName());

        System.out.println("Cloned Customer Name: "
                + clonedCustomer.getName());

        System.out.println("Are both customer objects same? "
                + (customer == clonedCustomer));

        System.out.println("Do both customers share the same address? "
                + (customer.getAddress() == clonedCustomer.getAddress()));

        // Practical 04: Validator demonstration
        System.out.println("\n===== VALIDATOR TESTING =====");

        System.out.println("Valid Mobile: "
                + Validator.isValidMobile("9876543210"));

        System.out.println("Invalid Mobile: "
                + Validator.isValidMobile("12345"));

        System.out.println("Valid Email: "
                + Validator.isValidEmail("vishva@example.com"));

        System.out.println("Invalid Email: "
                + Validator.isValidEmail("vishvaexample.com"));

        System.out.println("Valid PAN: "
                + Validator.isValidPan("ABCDE1234F"));

        System.out.println("Invalid PAN: "
                + Validator.isValidPan("ABC123"));

        System.out.println("Valid IFSC: "
                + Validator.isValidIfsc("SBIN0001234"));

        System.out.println("Invalid IFSC: "
                + Validator.isValidIfsc("SBI123"));

        // Practical 04: Command Parser demonstration
        System.out.println("\n===== COMMAND PARSER TESTING =====");

        String commandLine = "DEPOSIT AC0001 500";

        Command command = CommandParser.parse(commandLine);

        System.out.println("Original Command: " + commandLine);
        System.out.println("Transaction Type: " + command.type());
        System.out.println("Account Number: " + command.accountNumber());
        System.out.println("Amount: " + command.amount());

        // Practical 04: Statement Formatter demonstration
        System.out.println("\n===== ACCOUNT STATEMENT =====");

        String statement =
                StatementFormatter.buildStatement(accounts[0]);

        System.out.println(statement);

        // Existing MiniBank menu
        int choice;

        while (true) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.println("===============================");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println(
                        "Invalid input! Please enter a number.");

                sc.next();
                continue;
            }

            choice = sc.nextInt();

            MenuOption option = switch (choice) {

                case 1 -> MenuOption.OPEN_ACCOUNT;
                case 2 -> MenuOption.DEPOSIT;
                case 3 -> MenuOption.WITHDRAW;
                case 4 -> MenuOption.TRANSFER;
                case 5 -> MenuOption.EXIT;
                default -> null;
            };

            if (option == null) {
                System.out.println(
                        "Invalid choice! Please select 1 to 5.");

                continue;
            }

            if (option == MenuOption.EXIT) {
                System.out.println(
                        "Thank you for using MiniBank!");

                System.out.println("Goodbye!");

                break;
            }

            String message = switch (option) {

                case OPEN_ACCOUNT ->
                        "Open Account - to be implemented in a later lab";

                case DEPOSIT ->
                        "Deposit - to be implemented in a later lab";

                case WITHDRAW ->
                        "Withdraw - to be implemented in a later lab";

                case TRANSFER ->
                        "Transfer - to be implemented in a later lab";

                case EXIT -> "Goodbye!";
            };

            System.out.println(message);
        }

        sc.close();
    }
}
