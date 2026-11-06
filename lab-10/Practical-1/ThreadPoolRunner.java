
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {

    public static void main(String[] args) {

        System.out.println("===== THREAD POOL RUNNER =====");

        // Create a fixed thread pool with 3 worker threads
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // Submit 10 tasks to the thread pool
        for (int i = 1; i <= 10; i++) {

            final int taskId = i;

            executor.execute(() -> {

                String threadName =
                        Thread.currentThread().getName();

                System.out.println(
                        "Task " + taskId +
                        " is executing on " + threadName
                );

                try {

                    // Simulate task execution
                    Thread.sleep(500);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                    System.out.println(
                            "Task " + taskId + " was interrupted."
                    );
                }

                System.out.println(
                        "Task " + taskId +
                        " completed by " + threadName
                );
            });
        }

        // Stop accepting new tasks
        executor.shutdown();

        try {

            // Wait until all submitted tasks finish
            if (executor.awaitTermination(
                    30, TimeUnit.SECONDS)) {

                System.out.println(
                        "\nAll tasks completed successfully."
                );

            } else {

                System.out.println(
                        "\nSome tasks did not finish in time."
                );

                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();

            Thread.currentThread().interrupt();

            System.out.println(
                    "Main thread was interrupted."
            );
        }

        System.out.println("Thread pool execution finished.");
    }
}
