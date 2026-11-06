package service;

public class TransactionBuffer {

    private final Runnable[] buffer;

    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public TransactionBuffer(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Buffer capacity must be greater than zero."
            );
        }

        buffer = new Runnable[capacity];
    }

    // Producer waits while the bounded buffer is full.
    public synchronized void put(Runnable transaction)
            throws InterruptedException {

        if (transaction == null) {
            throw new IllegalArgumentException(
                    "Transaction cannot be null."
            );
        }

        while (count == buffer.length) {
            wait();
        }

        buffer[rear] = transaction;
        rear = (rear + 1) % buffer.length;
        count++;

        notifyAll();
    }

    // Consumer waits while the bounded buffer is empty.
    public synchronized Runnable take()
            throws InterruptedException {

        while (count == 0) {
            wait();
        }

        Runnable transaction = buffer[front];

        buffer[front] = null;
        front = (front + 1) % buffer.length;
        count--;

        notifyAll();

        return transaction;
    }
}
