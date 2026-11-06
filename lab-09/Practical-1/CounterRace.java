
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class SharedCounter {

    int count = 0;

    // Intentionally not synchronized.
    void increment() {
        count++;
    }

    // Thread-safe increment.
    synchronized void synchronizedIncrement() {
        count++;
    }
}

public class CounterRace {

    private static final int THREAD_COUNT = 10;
    private static final int INCREMENTS_PER_THREAD = 1000;

    private static void waitAtBarrier(CyclicBarrier barrier) {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted.", e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException("Barrier broken.", e);
        }
    }

    private static int runWithoutSynchronization()
            throws InterruptedException {

        SharedCounter counter = new SharedCounter();

        CyclicBarrier readBarrier = new CyclicBarrier(THREAD_COUNT);
        CyclicBarrier writeBarrier = new CyclicBarrier(THREAD_COUNT);

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            threads[i] = new Thread(() -> {

                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {

                    // All threads read the same value first.
                    int currentValue = counter.count;

                    waitAtBarrier(readBarrier);

                    // Multiple threads overwrite one another.
                    counter.count = currentValue + 1;

                    waitAtBarrier(writeBarrier);
                }

            }, "Counter-Thread-" + (i + 1));

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return counter.count;
    }

    private static int runWithSynchronization()
            throws InterruptedException {

        SharedCounter counter = new SharedCounter();

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            threads[i] = new Thread(() -> {

                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    counter.synchronizedIncrement();
                }

            }, "Safe-Counter-Thread-" + (i + 1));

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return counter.count;
    }

    public static void main(String[] args)
            throws InterruptedException {

        int expected = THREAD_COUNT * INCREMENTS_PER_THREAD;

        System.out.println("===== COUNTER RACE CONDITION =====");

        System.out.println("Number of threads: " + THREAD_COUNT);
        System.out.println("Increments per thread: "
                + INCREMENTS_PER_THREAD);
        System.out.println("Expected counter value: " + expected);

        System.out.println("\n--- Without Synchronization ---");

        int unsafeResult = runWithoutSynchronization();

        System.out.println("Actual counter value: " + unsafeResult);
        System.out.println("Lost increments: "
                + (expected - unsafeResult));

        System.out.println("\n--- With Synchronization ---");

        int safeResult = runWithSynchronization();

        System.out.println("Actual counter value: " + safeResult);

        System.out.println("\n===== RESULT =====");

        if (safeResult == expected) {
            System.out.println(
                    "Synchronization successfully prevented race conditions."
            );
        } else {
            System.out.println("Unexpected result.");
        }
    }
}
