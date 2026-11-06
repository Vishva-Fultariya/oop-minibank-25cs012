package service;

import exception.BankException;
import model.Account;

public class BankTransaction implements Runnable {

    public enum Operation {
        DEPOSIT,
        WITHDRAW
    }

    private final Account account;
    private final long amount;
    private final Operation operation;

    public BankTransaction(
            Account account,
            long amount,
            Operation operation) {

        this.account = account;
        this.amount = amount;
        this.operation = operation;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        String operationName = operation == null
                ? "UNKNOWN"
                : operation.name();

        try {

            // Simulate brief processing time to make worker reuse observable.
            Thread.sleep(30);

            if (operation == Operation.DEPOSIT) {

                account.deposit(amount);

                System.out.printf(
                        "%-16s | %-8s | SUCCESS | Amount: Rs. %,d.00 | Account: %s%n",
                        threadName,
                        operationName,
                        amount,
                        account.getAccountNumber()
                );

            } else if (operation == Operation.WITHDRAW) {

                boolean success = account.withdraw(amount);

                if (success) {

                    System.out.printf(
                            "%-16s | %-8s | SUCCESS | Amount: Rs. %,d.00 | Account: %s%n",
                            threadName,
                            operationName,
                            amount,
                            account.getAccountNumber()
                    );

                } else {

                    System.out.printf(
                            "%-16s | %-8s | REJECTED | Account is inactive: %s%n",
                            threadName,
                            operationName,
                            account.getAccountNumber()
                    );
                }

            } else {

                System.out.printf(
                        "%-16s | %-8s | REJECTED | Invalid transaction operation.%n",
                        threadName,
                        operationName
                );
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.printf(
                    "%-16s | %-8s | INTERRUPTED | Transaction was interrupted.%n",
                    threadName,
                    operationName
            );

        } catch (BankException e) {

            System.out.printf(
                    "%-16s | %-8s | FAILED   | %s%n",
                    threadName,
                    operationName,
                    e.getMessage()
            );
        }
    }
}
