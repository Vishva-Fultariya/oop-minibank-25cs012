package service;

import java.util.concurrent.CyclicBarrier;

/**
 * Demonstrates lost updates using an intentionally unsafe balance.
 * This class is only for demonstrating the race condition.
 */
public class UnsafeDepositDemo {

    private long balance;

    public long demonstrate(int threadCount, int times, long amount) {

        balance = 0;

        CyclicBarrier readBarrier = new CyclicBarrier(threadCount);
        CyclicBarrier writeBarrier = new CyclicBarrier(threadCount);

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {

            threads[i] = new Thread(() -> {

                try {
                    for (int j = 0; j < times; j++) {

                        // All threads read the shared balance.
                        long oldBalance = balance;

                        // Wait until every thread has read it.
                        readBarrier.await();

                        // All threads write based on the same old value.
                        balance = oldBalance + amount;

                        // Ensure all writes finish before the next round.
                        writeBarrier.await();
                    }

                } catch (Exception e) {
                    System.err.println(
                            Thread.currentThread().getName()
                            + " encountered an error: " + e.getMessage()
                    );
                }

            }, "Unsafe-Thread-" + (i + 1));

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(
                        "Main thread interrupted while waiting.",
                        e
                );
            }
        }

        return balance;
    }
}