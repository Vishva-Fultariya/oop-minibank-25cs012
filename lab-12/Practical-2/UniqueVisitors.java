
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueVisitors {

    public static void main(String[] args) {

        // Login names containing repeated visitors.
        String[] loginNames = {
            "Riya",
            "Aarav",
            "Meera",
            "Riya",
            "Kabir",
            "Aarav",
            "Diya",
            "Meera",
            "Vishva",
            "Kabir"
        };

        // Step 1: Use HashSet to store unique visitors.
        Set<String> uniqueUsers =
                new HashSet<>(Arrays.asList(loginNames));

        // Step 2: Use LinkedHashSet to preserve
        // the order in which visitors first appeared.
        Set<String> firstSeenOrder = new LinkedHashSet<>();

        for (String name : loginNames) {
            firstSeenOrder.add(name);
        }

        // Step 3: Display the original login names.
        System.out.println("===== UNIQUE VISITOR TRACKER =====");

        System.out.println("\nAll Login Names:");

        System.out.println(Arrays.toString(loginNames));

        // Step 4: Display the number of unique visitors.
        System.out.println("\nTotal Unique Visitors: "
                + uniqueUsers.size());

        // Step 5: Display the first three distinct visitors.
        System.out.println("\nFirst Three Distinct Visitors:");

        int count = 0;

        for (String name : firstSeenOrder) {

            if (count == 3) {
                break;
            }

            System.out.println((count + 1) + ". " + name);

            count++;
        }
    }
}
