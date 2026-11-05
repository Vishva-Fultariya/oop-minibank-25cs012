package service;

import java.util.Scanner;

import model.Account;
import model.Customer;
import model.SavingsAccount;
import model.CurrentAccount;
import model.FixedDepositAccount;
import model.InterestBearing;
import model.Premium;

import util.BankInfo;
import util.MenuOption;
import util.Command;
import util.TransactionType;

import static util.Validator.*;

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

        // Create different account types
        Account[] accounts = {
            new SavingsAccount("Vishva", 5000),
            new CurrentAccount("Dhruvi", 2000),
            new FixedDepositAccount("Madhav", 0)
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

        // Demonstrate runtime polymorphism
        System.out.println("\n===== RUNTIME POLYMORPHISM =====");

        for (Account account : accounts) {

            System.out.println("Account Holder: "
                    + account.getOwnerName());

            System.out.printf("Balance: Rs. %.2f%n",
                        account.getBalance());

            System.out.printf("Interest: Rs. %.2f%n",
                    account.calculateInterest());

            System.out.println("----------------------------");
        }

        // Demonstrate InterestBearing default methods
        System.out.println("\n===== INTEREST BEARING INTERFACE =====");

        for (Account account : accounts) {

            if (account instanceof InterestBearing interestAccount) {

                System.out.println("Account Holder: "
                        + account.getOwnerName());

                System.out.printf("Yearly Interest: Rs. %.2f%n",
                        interestAccount.yearlyInterest());

                System.out.printf("Monthly Interest: Rs. %.2f%n",
                        interestAccount.monthlyInterest());
            }
        }

        // Demonstrate Premium marker interface
        System.out.println("\n===== PREMIUM MARKER INTERFACE =====");

        for (Account account : accounts) {

            if (account instanceof Premium) {
                System.out.println(account.getOwnerName()
                        + " has a Premium Account.");
            } else {
                System.out.println(account.getOwnerName()
                        + " does not have a Premium Account.");
            }
        }

        // Demonstrate pattern matching with instanceof
        System.out.println("\n===== INSTANCEOF PATTERN MATCHING =====");

        for (Account account : accounts) {

            if (account instanceof SavingsAccount savings) {
                System.out.println(savings.getOwnerName()
                        + " has a Savings Account.");

            } else if (account instanceof CurrentAccount current) {
                System.out.println(current.getOwnerName()
                        + " has a Current Account.");

            } else if (account instanceof FixedDepositAccount fixed) {
                System.out.println(fixed.getOwnerName()
                        + " has a Fixed Deposit Account.");
            }
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

        // Validator demonstration using static import
        System.out.println("\n===== VALIDATOR TESTING =====");

        System.out.println("Valid Mobile: "
                + isValidMobile("9876543210"));

        System.out.println("Invalid Mobile: "
                + isValidMobile("12345"));

        System.out.println("Valid Email: "
                + isValidEmail("vishva@example.com"));

        System.out.println("Invalid Email: "
                + isValidEmail("vishvaexample.com"));

        System.out.println("Valid PAN: "
                + isValidPan("ABCDE1234F"));

        System.out.println("Invalid PAN: "
                + isValidPan("ABC123"));

        System.out.println("Valid IFSC: "
                + isValidIfsc("SBIN0001234"));

        System.out.println("Invalid IFSC: "
                + isValidIfsc("SBI123"));

        // Command Parser demonstration
        System.out.println("\n===== COMMAND PARSER TESTING =====");

        String commandLine = "DEPOSIT AC0001 500";

        Command command = CommandParser.parse(commandLine);

        System.out.println("Original Command: " + commandLine);
        System.out.println("Transaction Type: " + command.type());
        System.out.println("Account Number: " + command.accountNumber());
        System.out.println("Amount: " + command.amount());

        // Statement Formatter demonstration
        System.out.println("\n===== ACCOUNT STATEMENT =====");

        String statement =
                StatementFormatter.buildStatement(accounts[0]);

        System.out.println(statement);

        // WithdrawRule demonstration using anonymous class
        System.out.println("\n===== WITHDRAW RULE: ANONYMOUS CLASS =====");

        WithdrawRule anonymousRule = new WithdrawRule() {

            @Override
            public boolean allow(Account account, long amount) {

                return account.isActive()
                        && amount > 0
                        && amount <= account.getBalance();
            }
        };

        System.out.println("Allow withdrawal of Rs. 1000: "
                + anonymousRule.allow(accounts[0], 1000));

        System.out.println("Allow withdrawal of Rs. 100000: "
                + anonymousRule.allow(accounts[0], 100000));

        // WithdrawRule demonstration using lambda
        System.out.println("\n===== WITHDRAW RULE: LAMBDA EXPRESSION =====");

        WithdrawRule lambdaRule = (account, amount) ->
                account.isActive()
                && amount > 0
                && amount <= account.getBalance();

        System.out.println("Allow withdrawal of Rs. 1000: "
                + lambdaRule.allow(accounts[0], 1000));

        System.out.println("Allow withdrawal of Rs. 100000: "
                + lambdaRule.allow(accounts[0], 100000));

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