package service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionProcessor {

    private final ExecutorService executor;

    // Stores the number of tasks executed by each worker thread.
    private final Map<String, AtomicInteger> taskCounts =
            new ConcurrentHashMap<>();

    public TransactionProcessor() {

        // Create a fixed thread pool containing four threads.
        executor = Executors.newFixedThreadPool(4);
    }

    // Submit a transaction to the thread pool.
    public void submit(Runnable task) {

        executor.execute(() -> {

            String threadName =
                    Thread.currentThread().getName();

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

            if (!executor.awaitTermination(
                    60, TimeUnit.SECONDS)) {

                System.out.println(
                        "Some transactions are taking too long."
                );

                executor.shutdownNow();

            } else {

                System.out.println(
                        "\nAll submitted transactions completed."
                );
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();

            Thread.currentThread().interrupt();

            System.out.println(
                    "Transaction processor was interrupted."
            );
        }

        displayTaskCounts();
    }

    // Display the number of tasks executed by each pool thread.
    private void displayTaskCounts() {

        System.out.println(
                "\n===== THREAD POOL TASK STATISTICS ====="
        );

        if (taskCounts.isEmpty()) {

            System.out.println("No tasks were executed.");

            return;
        }

        taskCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {

                    System.out.println(
                            entry.getKey()
                            + " executed "
                            + entry.getValue().get()
                            + " task(s)."
                    );
                });
    }
}