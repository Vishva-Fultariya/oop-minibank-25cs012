
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;

public class SharedArraySum {

    private static final int ARRAY_SIZE = 1_000_000;
    private static final int THREAD_COUNT = 4;

    private static final Object lock = new Object();

    private static long sharedTotal = 0;

    private static void waitAtBarrier(CyclicBarrier barrier) {

        try {
            barrier.await();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);

        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private static long calculateRange(
            int[] numbers, int start, int end) {

        long localSum = 0;

        for (int i = start; i < end; i++) {
            localSum += numbers[i];
        }

        return localSum;
    }

    private static void joinThreads(Thread[] threads)
            throws InterruptedException {

        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static long runWithoutSynchronization(int[] numbers)
            throws InterruptedException {

        sharedTotal = 0;

        CyclicBarrier readBarrier = new CyclicBarrier(THREAD_COUNT);
        CyclicBarrier writeBarrier = new CyclicBarrier(THREAD_COUNT);

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            final int start = i * (ARRAY_SIZE / THREAD_COUNT);
            final int end = start + (ARRAY_SIZE / THREAD_COUNT);

            threads[i] = new Thread(() -> {

                long localSum = calculateRange(numbers, start, end);

                long oldTotal = sharedTotal;

                waitAtBarrier(readBarrier);

                // Unsafe shared update.
                sharedTotal = oldTotal + localSum;

                waitAtBarrier(writeBarrier);

            }, "Unsafe-Sum-" + (i + 1));

            threads[i].start();
        }

        joinThreads(threads);

        return sharedTotal;
    }

    private static long runWithSynchronization(int[] numbers)
            throws InterruptedException {

        sharedTotal = 0;

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            final int start = i * (ARRAY_SIZE / THREAD_COUNT);
            final int end = start + (ARRAY_SIZE / THREAD_COUNT);

            threads[i] = new Thread(() -> {

                long localSum = calculateRange(numbers, start, end);

                synchronized (lock) {
                    sharedTotal += localSum;
                }

            }, "Synchronized-Sum-" + (i + 1));

            threads[i].start();
        }

        joinThreads(threads);

        return sharedTotal;
    }

    private static long runWithAtomicLong(int[] numbers)
            throws InterruptedException {

        AtomicLong atomicTotal = new AtomicLong(0);

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            final int start = i * (ARRAY_SIZE / THREAD_COUNT);
            final int end = start + (ARRAY_SIZE / THREAD_COUNT);

            threads[i] = new Thread(() -> {

                long localSum = calculateRange(numbers, start, end);

                atomicTotal.addAndGet(localSum);

            }, "Atomic-Sum-" + (i + 1));

            threads[i].start();
        }

        joinThreads(threads);

        return atomicTotal.get();
    }

    private static long measureTime(
            int[] numbers, String method)
            throws InterruptedException {

        long startTime = System.nanoTime();

        long result;

        switch (method) {

            case "UNSAFE":
                result = runWithoutSynchronization(numbers);
                break;

            case "SYNCHRONIZED":
                result = runWithSynchronization(numbers);
                break;

            case "ATOMIC":
                result = runWithAtomicLong(numbers);
                break;

            default:
                throw new IllegalArgumentException("Invalid method.");
        }

        long endTime = System.nanoTime();

        System.out.println(method + " result: " + result);

        System.out.printf(
                "%s execution time: %.3f ms%n",
                method,
                (endTime - startTime) / 1_000_000.0
        );

        return result;
    }

    public static void main(String[] args)
            throws InterruptedException {

        int[] numbers = new int[ARRAY_SIZE];

        long expectedTotal = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = (i % 100) + 1;
            expectedTotal += numbers[i];
        }

        System.out.println("===== SHARED ARRAY SUM =====");

        System.out.println("Array size: " + ARRAY_SIZE);
        System.out.println("Number of threads: " + THREAD_COUNT);
        System.out.println("Expected total: " + expectedTotal);

        System.out.println("\n--- Without Synchronization ---");

        long unsafeResult = measureTime(numbers, "UNSAFE");

        System.out.println("\n--- With Synchronized Block ---");

        long synchronizedResult =
                measureTime(numbers, "SYNCHRONIZED");

        System.out.println("\n--- With AtomicLong ---");

        long atomicResult = measureTime(numbers, "ATOMIC");

        System.out.println("\n===== COMPARISON =====");

        System.out.println("Expected total: " + expectedTotal);
        System.out.println("Unsafe total: " + unsafeResult);
        System.out.println("Synchronized total: " + synchronizedResult);
        System.out.println("AtomicLong total: " + atomicResult);

        if (synchronizedResult == expectedTotal
                && atomicResult == expectedTotal) {

            System.out.println(
                    "\nBoth thread-safe approaches produced the correct total."
            );

        } else {
            System.out.println(
                    "\nUnexpected result. Check the implementation."
            );
        }
    }
}
