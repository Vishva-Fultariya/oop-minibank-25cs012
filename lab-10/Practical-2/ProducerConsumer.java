
import java.util.ArrayDeque;
import java.util.Queue;

class SharedBuffer {

    private final Queue<Integer> buffer =
            new ArrayDeque<>();

    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Producer inserts an item into the buffer
    public synchronized void produce(int item)
            throws InterruptedException {

        // Wait while the buffer is full
        while (buffer.size() == capacity) {

            System.out.println(
                    "Buffer full. Producer is waiting."
            );

            wait();
        }

        buffer.add(item);

        System.out.println(
                "Produced: " + item +
                " | Buffer: " + buffer
        );

        // Notify waiting consumer
        notifyAll();
    }

    // Consumer removes an item from the buffer
    public synchronized int consume()
            throws InterruptedException {

        // Wait while the buffer is empty
        while (buffer.isEmpty()) {

            System.out.println(
                    "Buffer empty. Consumer is waiting."
            );

            wait();
        }

        int item = buffer.remove();

        System.out.println(
                "Consumed: " + item +
                " | Buffer: " + buffer
        );

        // Notify waiting producer
        notifyAll();

        return item;
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        System.out.println("===== PRODUCER CONSUMER =====");

        // Create a shared buffer of capacity 3
        SharedBuffer sharedBuffer =
                new SharedBuffer(3);

        // Producer thread
        Thread producer = new Thread(() -> {

            try {

                for (int i = 1; i <= 10; i++) {

                    sharedBuffer.produce(i);

                    Thread.sleep(200);
                }

                System.out.println(
                        "Producer finished."
                );

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "Producer interrupted."
                );
            }

        }, "Producer");

        // Consumer thread
        Thread consumer = new Thread(() -> {

            try {

                for (int i = 1; i <= 10; i++) {

                    sharedBuffer.consume();

                    Thread.sleep(400);
                }

                System.out.println(
                        "Consumer finished."
                );

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "Consumer interrupted."
                );
            }

        }, "Consumer");

        // Start both threads
        producer.start();
        consumer.start();

        try {

            // Wait for both threads to finish
            producer.join();
            consumer.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Main thread interrupted."
            );
        }

        System.out.println(
                "\nProducer-Consumer execution completed."
        );
    }
}
