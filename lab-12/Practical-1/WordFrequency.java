
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

    public static void main(String[] args) {

        String paragraph = "Java is fun. Java is powerful. "
                + "Java is popular. Programming in Java is fun, "
                + "and programming is useful.";

        // Step 1: Convert paragraph to lowercase
        // and split it into individual words.
        String[] words = paragraph.toLowerCase()
                .split("[^a-z0-9]+");

        // Step 2: Create a HashMap to store word frequencies.
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        // Step 3: Count the frequency of each word.
        for (String word : words) {

            if (!word.isEmpty()) {
                frequencyMap.put(
                        word,
                        frequencyMap.getOrDefault(word, 0) + 1
                );
            }
        }

        // Step 4: Copy HashMap entries into an ArrayList.
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());

        // Step 5: Sort by frequency in descending order.
        // If frequencies are equal, sort alphabetically.
        entries.sort((first, second) -> {

            int frequencyComparison =
                    Integer.compare(
                            second.getValue(),
                            first.getValue()
                    );

            if (frequencyComparison != 0) {
                return frequencyComparison;
            }

            return first.getKey().compareTo(second.getKey());
        });

        // Step 6: Display the sorted word frequencies.
        System.out.println("===== WORD FREQUENCY ANALYZER =====");

        System.out.println("\nOriginal Paragraph:");
        System.out.println(paragraph);

        System.out.println("\nWord Frequencies (Highest First):");

        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }

        System.out.println("\nTotal Unique Words: "
                + frequencyMap.size());
    }
}
