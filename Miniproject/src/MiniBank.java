
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

        // Create bank information
        BankInfo bank = new BankInfo("MiniBank", "Main Branch");

        System.out.println("=================================");
        System.out.println("       " + bank.name());
        System.out.println("       " + bank.branch());
        System.out.println("=================================");

        int choice;

        // Display menu until the user selects EXIT
        while (true) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.println("===============================");

            System.out.print("Enter your choice: ");

            // Handle non-numeric input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            // Convert the selected number into MenuOption
            MenuOption option = switch (choice) {
                case 1 -> MenuOption.OPEN_ACCOUNT;
                case 2 -> MenuOption.DEPOSIT;
                case 3 -> MenuOption.WITHDRAW;
                case 4 -> MenuOption.TRANSFER;
                case 5 -> MenuOption.EXIT;
                default -> null;
            };

            if (option == null) {
                System.out.println("Invalid choice! Please select 1 to 5.");
                continue;
            }

            // Execute the selected menu option
            if (option == MenuOption.EXIT) {
                System.out.println("Thank you for using MiniBank!");
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
