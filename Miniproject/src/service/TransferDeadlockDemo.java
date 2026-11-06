package service;

import exception.BankException;
import java.util.concurrent.CountDownLatch;
import model.Account;
import model.SavingsAccount;

public class TransferDeadlockDemo {

    /*
     * This method is reached only after both account locks
     * have been acquired. It represents the actual debit/credit
     * operations of the intentionally deadlocking transfers.
     */
    private static void transferWhileLocked(
            Account source,
            Account destination,
            long amount) {

        try {

            if (source.withdraw(amount)) {
                destination.deposit(amount);
            }

        } catch (BankException e) {

            System.out.println(
                    Thread.currentThread().getName()
                    + " | Transfer failed: "
                    + e.getMessage()
            );
        }
    }

    // Demonstrate deadlock using opposite account lock orders.
    private static void demonstrateDeadlock() {

        System.out.println(
                "\n================ DEADLOCK DEMONSTRATION ================"
        );

        Account accountA =
                new SavingsAccount("Deadlock Customer A", 5000);

        Account accountB =
                new SavingsAccount("Deadlock Customer B", 5000);

        CountDownLatch firstLocksAcquired =
                new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {

            synchronized (accountA) {

                System.out.println(
                        "Transfer A -> B: locked Account A."
                );

                firstLocksAcquired.countDown();

                try {
                    firstLocksAcquired.await();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println(
                        "Transfer A -> B: waiting for Account B..."
                );

                synchronized (accountB) {
                    transferWhileLocked(accountA, accountB, 500);
                }
            }

        }, "Deadlock-Thread-1");

        Thread thread2 = new Thread(() -> {

            synchronized (accountB) {

                System.out.println(
                        "Transfer B -> A: locked Account B."
                );

                firstLocksAcquired.countDown();

                try {
                    firstLocksAcquired.await();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println(
                        "Transfer B -> A: waiting for Account A..."
                );

                synchronized (accountA) {
                    transferWhileLocked(accountB, accountA, 300);
                }
            }

        }, "Deadlock-Thread-2");

        // Daemon threads keep the demonstration from blocking JVM exit.
        thread1.setDaemon(true);
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

        try {
            thread1.join(1000);
            thread2.join(1000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (thread1.isAlive() && thread2.isAlive()) {

            System.out.println("\n[CONFIRMED] Deadlock detected.");
            System.out.println(
                    "Thread 1 holds Account A and waits for Account B."
            );
            System.out.println(
                    "Thread 2 holds Account B and waits for Account A."
            );

        } else {

            System.out.println(
                    "[NOTICE] The deadlock was not reproduced."
            );
        }
    }

    // Demonstrate deadlock prevention through consistent lock ordering.
    private static void demonstrateDeadlockPrevention() {

        System.out.println(
                "\n============= DEADLOCK PREVENTION ============="
        );

        Account accountA =
                new SavingsAccount("Safe Customer A", 5000);

        Account accountB =
                new SavingsAccount("Safe Customer B", 5000);

        System.out.println(
                "Account A: " + accountA.getAccountNumber()
        );

        System.out.println(
                "Account B: " + accountB.getAccountNumber()
        );

        System.out.println(
                "Lock policy: acquire the lower account number first."
        );

        Thread thread1 = new Thread(() -> {

            try {
                accountA.transfer(accountB, 500);

                System.out.println(
                        "Transfer A -> B completed."
                );

            } catch (BankException e) {
                System.out.println(
                        "Transfer A -> B failed: " + e.getMessage()
                );
            }

        }, "Safe-Transfer-Thread-1");

        Thread thread2 = new Thread(() -> {

            try {
                accountB.transfer(accountA, 300);

                System.out.println(
                        "Transfer B -> A completed."
                );

            } catch (BankException e) {
                System.out.println(
                        "Transfer B -> A failed: " + e.getMessage()
                );
            }

        }, "Safe-Transfer-Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
            return;
        }

        System.out.println("\nBalances after safe transfers:");
        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println(
                "[SUCCESS] Both transfers completed without deadlock."
        );
    }

    public static void runDemonstration() {
        demonstrateDeadlock();
        demonstrateDeadlockPrevention();
    }
}
