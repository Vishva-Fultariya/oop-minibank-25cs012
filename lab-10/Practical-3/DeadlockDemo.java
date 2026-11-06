
import java.util.concurrent.CountDownLatch;

public class DeadlockDemo {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    // Both threads signal after acquiring their first lock
    private static final CountDownLatch ready =
            new CountDownLatch(2);

    // Demonstrates deadlock using opposite lock orders
    private static void demonstrateDeadlock() {

        System.out.println("\n===== DEADLOCK DEMO =====");

        Thread thread1 = new Thread(() -> {

            synchronized (lockA) {

                System.out.println(
                        "Thread 1 acquired Lock A."
                );

                ready.countDown();

                try {
                    ready.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println(
                        "Thread 1 waiting for Lock B..."
                );

                synchronized (lockB) {

                    System.out.println(
                            "Thread 1 acquired Lock B."
                    );
                }
            }

        }, "Thread-1");

        Thread thread2 = new Thread(() -> {

            synchronized (lockB) {

                System.out.println(
                        "Thread 2 acquired Lock B."
                );

                ready.countDown();

                try {
                    ready.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println(
                        "Thread 2 waiting for Lock A..."
                );

                synchronized (lockA) {

                    System.out.println(
                            "Thread 2 acquired Lock A."
                    );
                }
            }

        }, "Thread-2");

        // Daemon threads prevent the demonstration
        // deadlock from keeping the JVM alive.
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

            System.out.println(
                    "Deadlock detected: both threads are blocked."
            );

        } else {

            System.out.println(
                    "Deadlock was not reproduced."
            );
        }
    }

    // Acquires both locks in a consistent order
    private static void demonstrateDeadlockFix() {

        System.out.println(
                "\n===== DEADLOCK FIX ====="
        );

        Object firstLock = new Object();
        Object secondLock = new Object();

        Thread thread1 = new Thread(() -> {

            synchronized (firstLock) {

                System.out.println(
                        "Thread 1 acquired first lock."
                );

                synchronized (secondLock) {

                    System.out.println(
                            "Thread 1 acquired second lock."
                    );
                }
            }

            System.out.println(
                    "Thread 1 completed successfully."
            );

        }, "Fixed-Thread-1");

        Thread thread2 = new Thread(() -> {

            synchronized (firstLock) {

                System.out.println(
                        "Thread 2 acquired first lock."
                );

                synchronized (secondLock) {

                    System.out.println(
                            "Thread 2 acquired second lock."
                    );
                }
            }

            System.out.println(
                    "Thread 2 completed successfully."
            );

        }, "Fixed-Thread-2");

        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println(
                "Deadlock successfully prevented."
        );
    }

    public static void main(String[] args) {

        demonstrateDeadlock();

        demonstrateDeadlockFix();
    }
}
