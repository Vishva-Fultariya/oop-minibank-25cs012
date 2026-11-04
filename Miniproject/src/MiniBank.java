
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

        // Create three Account objects inside an array
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

        // Display all account balances
        System.out.println("\n===== ACCOUNT DETAILS =====");

        for (Account account : accounts) {

            System.out.println("Account Number: "
                    + account.getAccountNumber());

            System.out.println("Owner: "
                    + account.getOwnerName());

            System.out.println("Balance: "
                    + account.getBalance());

            System.out.println("Active: "
                    + account.isActive());

            System.out.println("-------------------------");
        }

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
