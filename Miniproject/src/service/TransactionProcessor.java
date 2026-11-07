
package service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import model.Account;

/**
 * Processes bank tasks using a fixed thread pool and thread-safe collections.
 */
public class TransactionProcessor {

    private final ExecutorService executor;

    // Thread-safe shared account registry, indexed by account number.
    private final ConcurrentHashMap<String, Account> sharedAccounts =
            new ConcurrentHashMap<>();

    // Stores the number of tasks executed by each worker thread.
    private final Map<String, AtomicInteger> taskCounts =
            new ConcurrentHashMap<>();

    public TransactionProcessor() {
        // Create a fixed thread pool containing four threads.
        executor = Executors.newFixedThreadPool(4);
    }

    /** Registers an account in the shared, thread-safe account registry. */
    public void registerAccount(Account account) {
        Objects.requireNonNull(account, "Account cannot be null.");

        Account existing = sharedAccounts.putIfAbsent(
                account.getAccountNumber(), account);

        if (existing != null && existing != account) {
            throw new IllegalArgumentException(
                    "An account with this account number is already registered: "
                    + account.getAccountNumber());
        }
    }

    /** Retrieves a registered account by account number. */
    public Account getAccount(String accountNumber) {
        return sharedAccounts.get(accountNumber);
    }

    /** Returns a snapshot of the currently registered accounts. */
    public ArrayList<Account> getSharedAccounts() {
        return new ArrayList<>(sharedAccounts.values());
    }

    /** Returns the number of accounts in the shared registry. */
    public int getSharedAccountCount() {
        return sharedAccounts.size();
    }

    // Submit a transaction/task to the thread pool.
    public void submit(Runnable task) {
        Objects.requireNonNull(task, "Task cannot be null.");

        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();

            taskCounts.computeIfAbsent(
                    threadName,
                    name -> new AtomicInteger(0)
            ).incrementAndGet();

            task.run();
        });
    }

    // Stop accepting tasks and wait for submitted tasks.
    public void stop() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Some transactions are taking too long.");
                executor.shutdownNow();
            } else {
                System.out.println("\nAll submitted transactions completed.");
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();

            System.out.println("Transaction processor was interrupted.");
        }

        displayTaskCounts();
    }

    // Display the number of tasks executed by each pool thread.
    private void displayTaskCounts() {
        System.out.println("\n===== THREAD POOL TASK STATISTICS =====");

        if (taskCounts.isEmpty()) {
            System.out.println("No tasks were executed.");
            return;
        }

        taskCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(
                        entry.getKey() + " executed "
                        + entry.getValue().get() + " task(s)."));
    }
}
