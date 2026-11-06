
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

class Cinema {

    private int seatsLeft;

    Cinema(int seats) {
        seatsLeft = seats;
    }

    // Intentionally unsafe booking operation.
    boolean bookWithoutSynchronization(CyclicBarrier barrier) {

        if (seatsLeft > 0) {

            try {
                // Make every customer check before anyone books.
                barrier.await();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);

            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            seatsLeft--;
            return true;
        }

        return false;
    }

    // Thread-safe booking operation.
    synchronized boolean book() {

        if (seatsLeft > 0) {
            seatsLeft--;
            return true;
        }

        return false;
    }

    int getSeatsLeft() {
        return seatsLeft;
    }
}

public class SeatBookingRace {

    private static final int TOTAL_SEATS = 5;
    private static final int CUSTOMER_COUNT = 10;

    private static void runWithoutSynchronization()
            throws InterruptedException {

        Cinema cinema = new Cinema(TOTAL_SEATS);

        AtomicInteger successfulBookings = new AtomicInteger(0);

        CyclicBarrier barrier = new CyclicBarrier(CUSTOMER_COUNT);

        Thread[] customers = new Thread[CUSTOMER_COUNT];

        System.out.println("\n--- Without Synchronization ---");

        for (int i = 0; i < CUSTOMER_COUNT; i++) {

            customers[i] = new Thread(() -> {

                boolean booked =
                        cinema.bookWithoutSynchronization(barrier);

                if (booked) {
                    successfulBookings.incrementAndGet();

                    System.out.println(
                            Thread.currentThread().getName()
                            + " booked a seat."
                    );

                } else {
                    System.out.println(
                            Thread.currentThread().getName()
                            + " could not book a seat."
                    );
                }

            }, "Customer-" + (i + 1));

            customers[i].start();
        }

        for (Thread customer : customers) {
            customer.join();
        }

        System.out.println("Successful bookings: "
                + successfulBookings.get());

        System.out.println("Seats remaining: "
                + cinema.getSeatsLeft());

        System.out.println("Oversold seats: "
                + Math.max(0, successfulBookings.get() - TOTAL_SEATS));
    }

    private static void runWithSynchronization()
            throws InterruptedException {

        Cinema cinema = new Cinema(TOTAL_SEATS);

        AtomicInteger successfulBookings = new AtomicInteger(0);

        Thread[] customers = new Thread[CUSTOMER_COUNT];

        System.out.println("\n--- With Synchronization ---");

        for (int i = 0; i < CUSTOMER_COUNT; i++) {

            customers[i] = new Thread(() -> {

                boolean booked = cinema.book();

                if (booked) {
                    successfulBookings.incrementAndGet();

                    System.out.println(
                            Thread.currentThread().getName()
                            + " booked a seat."
                    );

                } else {
                    System.out.println(
                            Thread.currentThread().getName()
                            + " could not book a seat."
                    );
                }

            }, "Customer-" + (i + 1));

            customers[i].start();
        }

        for (Thread customer : customers) {
            customer.join();
        }

        System.out.println("Successful bookings: "
                + successfulBookings.get());

        System.out.println("Seats remaining: "
                + cinema.getSeatsLeft());
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("===== CINEMA SEAT BOOKING =====");

        System.out.println("Available seats: " + TOTAL_SEATS);
        System.out.println("Total customers: " + CUSTOMER_COUNT);

        runWithoutSynchronization();
        runWithSynchronization();

        System.out.println("\n===== RESULT =====");
        System.out.println(
                "Synchronization prevents seat overselling."
        );
    }
}
