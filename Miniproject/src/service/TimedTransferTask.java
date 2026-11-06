package service;

import exception.BankException;
import model.Account;

public class TimedTransferTask implements Runnable {

    private final Account source;
    private final Account destination;
    private final long amount;

    // Warning threshold for this demonstration.
    private static final long WARNING_THRESHOLD_MS = 100;

    public TimedTransferTask(
            Account source,
            Account destination,
            long amount) {

        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        String threadName =
                Thread.currentThread().getName();

        try {

            /*
             * Simulate a slightly delayed transfer so that
             * the supplementary warning can be demonstrated.
             */
            Thread.sleep(150);

            source.transfer(destination, amount);

        } catch (BankException e) {

            System.out.println(
                    threadName
                    + " | Transfer error: "
                    + e.getMessage()
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    threadName + " | Transfer interrupted."
            );

        } finally {

            long duration =
                    System.currentTimeMillis() - startTime;

            System.out.println(
                    threadName
                    + " | Transfer execution time: "
                    + duration
                    + " ms"
            );

            if (duration > WARNING_THRESHOLD_MS) {

                System.out.println(
                        "WARNING: Long-running transfer detected!"
                );
            }
        }
    }
}