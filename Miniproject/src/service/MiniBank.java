package service;

import exception.AccountNotFoundException;
import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import model.Account;
import model.CurrentAccount;
import model.Customer;
import model.FixedDepositAccount;
import model.InterestBearing;
import model.Premium;
import model.SavingsAccount;
import util.BankInfo;
import util.Command;
import util.MenuOption;
import static util.Validator.*;

public class MiniBank {

    private static Account findAccount(Account[] accounts, String accountNumber)
            throws AccountNotFoundException {

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        throw new AccountNotFoundException(
                "Account not found: " + accountNumber
        );
    }

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

        demonstrateConcurrency();
        
        System.out.println("\n===== TRANSFER DEMONSTRATION =====");

        try {

            // Successful transfer
            accounts[0].transfer(accounts[1], 1000);

            System.out.println("\nBalances after transfer:");

            System.out.println(accounts[0]);
            System.out.println(accounts[1]);

        } catch (BankException e) {

            System.out.println("Bank Error: " + e.getMessage());

            if (e instanceof InsufficientFundsException insufficient) {
                System.out.println(
                        "Shortfall: Rs. " + insufficient.getShortfall()
                );
            }
        }

        System.out.println("\n===== ACCOUNT NOT FOUND TEST =====");

        try {
            Account foundAccount = findAccount(accounts, "AC0001");
            System.out.println("Account found: " + foundAccount.getAccountNumber());

            findAccount(accounts, "AC9999");

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== INSUFFICIENT FUNDS TEST =====");

        Account testAccount = new SavingsAccount("Test User", 1000);

        System.out.println("Initial Balance: Rs. " + testAccount.getBalance());

        try {
            testAccount.withdraw(5000);
            System.out.println("Withdrawal successful.");

        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Shortfall: Rs. " + e.getShortfall());

        } catch (InvalidAmountException e) {
            System.out.println("Invalid Amount: " + e.getMessage());

        } finally {
            System.out.println("Final Balance: Rs. " + testAccount.getBalance());
            System.out.println("Withdrawal test completed.");
        }

        System.out.println("\n===== TRY-WITH-RESOURCES TEST =====");

        try (BankSession session = new BankSession()) {

            System.out.println("Performing bank operation...");

            throw new BankException("Simulated bank operation error.");

        } catch (BankException e) {

            System.out.println("Exception handled: " + e.getMessage());

        } finally {

            System.out.println("Bank operation completed.");
        }

        System.out.println("\n===== INVALID AMOUNT TEST =====");

        try {
            testAccount.withdraw(0);

        } catch (InvalidAmountException e) {
            System.out.println("Invalid Amount Exception: " + e.getMessage());

        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient Funds Exception: " + e.getMessage());

        } finally {
            System.out.println("Balance after invalid withdrawal: Rs. "
                    + testAccount.getBalance());
        }

        System.out.println("\n===== INVALID DEPOSIT TEST =====");

        try {
            testAccount.deposit(0);

        } catch (InvalidAmountException e) {
            System.out.println("Invalid Amount Exception: " + e.getMessage());

        } finally {
            System.out.println("Balance after invalid deposit: Rs. "
                    + testAccount.getBalance());
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

        String statement
                = StatementFormatter.buildStatement(accounts[0]);

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

        WithdrawRule lambdaRule = (account, amount)
                -> account.isActive()
                && amount > 0
                && amount <= account.getBalance();

        System.out.println("Allow withdrawal of Rs. 1000: "
                + lambdaRule.allow(accounts[0], 1000));

        System.out.println("Allow withdrawal of Rs. 100000: "
                + lambdaRule.allow(accounts[0], 100000));

        // Custom Annotation and Reflection Validation
        System.out.println("\n===== CUSTOM ANNOTATION VALIDATION =====");

        // Test 1: Negative balance
        Account invalidAccount
                = new SavingsAccount("Test User", -100);

        System.out.println("\nTest 1: Negative Balance");

        String[] invalidErrors
                = AnnotationValidator.validate(invalidAccount);

        if (invalidErrors.length == 0) {
            System.out.println("Account is valid.");
        } else {
            for (String error : invalidErrors) {
                System.out.println("Validation Error: " + error);
            }
        }

        // Test 2: Valid account
        Account validAccount
                = new SavingsAccount("Vishva", 5000);

        System.out.println("\nTest 2: Valid Account");

        String[] validErrors
                = AnnotationValidator.validate(validAccount);

        if (validErrors.length == 0) {
            System.out.println("Account is valid.");
        } else {
            for (String error : validErrors) {
                System.out.println("Validation Error: " + error);
            }
        }

        // Test 3: Maximum length validation
        Account longNameAccount
                = new SavingsAccount("VeryLongStudentName", 5000);

        System.out.println("\nTest 3: Maximum Length Validation");

        String[] lengthErrors
                = AnnotationValidator.validate(longNameAccount);

        if (lengthErrors.length == 0) {
            System.out.println("Account is valid.");
        } else {
            for (String error : lengthErrors) {
                System.out.println("Validation Error: " + error);
            }
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

                case 1 ->
                    MenuOption.OPEN_ACCOUNT;
                case 2 ->
                    MenuOption.DEPOSIT;
                case 3 ->
                    MenuOption.WITHDRAW;
                case 4 ->
                    MenuOption.TRANSFER;
                case 5 ->
                    MenuOption.EXIT;
                default ->
                    null;
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

                case EXIT ->
                    "Goodbye!";
            };

            System.out.println(message);
        }

        sc.close();
    }

    private static void demonstrateConcurrency() {

        final int THREAD_COUNT = 10;
        final int DEPOSIT_COUNT = 1000;
        final long DEPOSIT_AMOUNT = 1;

        System.out.println("\n===== PRACTICAL 09: MULTITHREADING =====");

        // -------------------------------------------------
        // 1. Demonstrate an incorrect balance without sync
        // -------------------------------------------------
        System.out.println("\n--- UNSYNCHRONIZED DEPOSIT DEMONSTRATION ---");

        UnsafeDepositDemo unsafeDemo = new UnsafeDepositDemo();

        long unsafeBalance = unsafeDemo.demonstrate(
                THREAD_COUNT,
                DEPOSIT_COUNT,
                DEPOSIT_AMOUNT
        );

        long expectedBalance
                = (long) THREAD_COUNT * DEPOSIT_COUNT * DEPOSIT_AMOUNT;

        System.out.println("Number of threads: " + THREAD_COUNT);
        System.out.println("Deposits per thread: " + DEPOSIT_COUNT);
        System.out.println("Expected balance: Rs. " + expectedBalance);
        System.out.println("Actual unsynchronized balance: Rs. "
                + unsafeBalance);

        // -------------------------------------------------
        // 2. Demonstrate synchronized deposits
        // -------------------------------------------------
        System.out.println("\n--- SYNCHRONIZED DEPOSIT DEMONSTRATION ---");

        Account sharedAccount = new SavingsAccount(
                "Concurrent Customer",
                0
        );

        Thread[] depositThreads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            AccountWorker worker = new AccountWorker(
                    sharedAccount,
                    DEPOSIT_COUNT,
                    DEPOSIT_AMOUNT
            );

            depositThreads[i] = new Thread(
                    worker,
                    "Deposit-Thread-" + (i + 1)
            );

            depositThreads[i].start();
        }

        // Wait for all deposit threads to finish.
        for (Thread thread : depositThreads) {

            try {
                thread.join();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                System.out.println(
                        "Main thread interrupted while waiting for deposits."
                );

                return;
            }
        }

        System.out.println("\nExpected synchronized balance: Rs. "
                + expectedBalance);

        System.out.println("Actual synchronized balance: Rs. "
                + sharedAccount.getBalance());

        System.out.println("All deposit threads completed.");

        // -------------------------------------------------
        // 3. Demonstrate concurrent withdrawals
        // -------------------------------------------------
        System.out.println("\n--- CONCURRENT WITHDRAWAL DEMONSTRATION ---");

        final int WITHDRAWAL_THREADS = 10;
        final long WITHDRAWAL_AMOUNT = 1000;

        Account withdrawalAccount = new SavingsAccount(
                "Withdrawal Customer",
                5000
        );

        AtomicInteger successfulWithdrawals = new AtomicInteger(0);

        System.out.println("Initial balance: Rs. "
                + withdrawalAccount.getBalance());

        Thread[] withdrawalThreads
                = new Thread[WITHDRAWAL_THREADS];

        for (int i = 0; i < WITHDRAWAL_THREADS; i++) {

            withdrawalThreads[i] = new Thread(() -> {

                String threadName = Thread.currentThread().getName();

                try {
                    boolean success
                            = withdrawalAccount.withdraw(WITHDRAWAL_AMOUNT);

                    if (success) {
                        successfulWithdrawals.incrementAndGet();

                        System.out.println(
                                threadName + ": Withdrawal successful."
                        );
                    }

                } catch (InsufficientFundsException e) {

                    System.out.println(
                            threadName + ": Withdrawal rejected - "
                            + e.getMessage()
                    );

                } catch (InvalidAmountException e) {

                    System.out.println(
                            threadName + ": Invalid amount - "
                            + e.getMessage()
                    );
                }

            }, "Withdraw-Thread-" + (i + 1));

            withdrawalThreads[i].start();
        }

        for (Thread thread : withdrawalThreads) {

            try {
                thread.join();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                System.out.println(
                        "Main thread interrupted while waiting for withdrawals."
                );

                return;
            }
        }

        System.out.println("\nSuccessful withdrawals: "
                + successfulWithdrawals.get());

        System.out.println("Expected successful withdrawals: 5");

        System.out.println("Final withdrawal account balance: Rs. "
                + withdrawalAccount.getBalance());

        System.out.println("Expected final balance: Rs. 0");

        System.out.println("\n===== CONCURRENCY DEMONSTRATION COMPLETED =====");
    }

    private static class BankSession implements AutoCloseable {

        public BankSession() {
            System.out.println("Bank session opened.");
        }

        @Override
        public void close() {
            System.out.println("Bank session closed automatically.");
        }
    }

}
