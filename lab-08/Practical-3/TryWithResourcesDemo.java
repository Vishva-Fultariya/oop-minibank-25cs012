
class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Resource opened.");
    }

    public void performTask() {
        System.out.println("Performing task...");

        // Simulate an error inside the try block
        throw new IllegalArgumentException(
            "Original error: Something went wrong during the task."
        );
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource...");

        // Simulate another error while closing
        throw new Exception(
            "Secondary error: Resource could not close normally."
        );
    }
}

public class TryWithResourcesDemo {

    public static void main(String[] args) {

        System.out.println("===== TRY-WITH-RESOURCES DEMO =====");

        try (MyResource resource = new MyResource()) {

            resource.performTask();

        } catch (Exception e) {

            System.out.println("\nException caught:");
            System.out.println("Type: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());

            // Display exceptions that occurred during resource closing
            System.out.println("\nSuppressed Exceptions:");

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println(suppressed.getMessage());
            }

        } finally {

            System.out.println("\nFinally block executed.");
        }

        System.out.println("\nProgram completed successfully.");
    }
}
