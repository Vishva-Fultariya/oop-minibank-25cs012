
@FunctionalInterface
interface Notifier {

    void send(String message);
}

// Marker interface to identify urgent senders
interface Urgent {
}

// Wrapper class that marks a Notifier as urgent
class UrgentNotifier implements Notifier, Urgent {

    private final Notifier notifier;

    public UrgentNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

public class NotificationSenders {

    public static void main(String[] args) {

        System.out.println("===== NOTIFICATION SENDER SYSTEM =====");

        // Email sender implemented using a lambda expression
        Notifier emailSender = message ->
                System.out.println("EMAIL SENT: " + message);

        // SMS sender implemented using a lambda expression
        Notifier smsSender = message ->
                System.out.println("SMS SENT: " + message);

        // Mark the email sender as urgent
        Notifier urgentEmailSender =
                new UrgentNotifier(emailSender);

        // Store all notification senders in an array
        Notifier[] senders = {
            urgentEmailSender,
            smsSender
        };

        // Message to be broadcast
        String message = "Your account has been updated successfully.";

        System.out.println("\nBroadcasting notification:");
        System.out.println("Message: " + message);

        // Broadcast the message to all senders
        for (Notifier sender : senders) {

            sender.send(message);

            // Send an additional copy to urgent senders
            if (sender instanceof Urgent) {

                System.out.println("Urgent sender detected!");
                System.out.println("Sending an additional notification:");

                sender.send(message);
            }
        }

        System.out.println("\nNotification broadcasting completed.");
    }
}
