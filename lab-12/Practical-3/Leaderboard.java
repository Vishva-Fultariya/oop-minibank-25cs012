
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    public static void main(String[] args) {

        // Step 1: Create a Map to store player names and scores.
        Map<String, Integer> playerScores = new HashMap<>();

        playerScores.put("Aarav", 950);
        playerScores.put("Diya", 1200);
        playerScores.put("Kabir", 950);
        playerScores.put("Meera", 1100);
        playerScores.put("Riya", 1200);
        playerScores.put("Vishva", 870);

        // Number of top players to display.
        int topN = 5;

        // Step 2: Copy Map entries into an ArrayList.
        List<Map.Entry<String, Integer>> leaderboard =
                new ArrayList<>(playerScores.entrySet());

        // Step 3: Sort by score in descending order.
        // If scores are equal, sort names alphabetically.
        leaderboard.sort((first, second) -> {

            int scoreComparison =
                    Integer.compare(
                            second.getValue(),
                            first.getValue()
                    );

            if (scoreComparison != 0) {
                return scoreComparison;
            }

            return first.getKey().compareToIgnoreCase(
                    second.getKey()
            );
        });

        // Step 4: Display the top N players.
        System.out.println("===== PLAYER LEADERBOARD =====");

        System.out.println("\nTop " + topN + " Players:");

        int rank = 1;

        for (Map.Entry<String, Integer> player : leaderboard) {

            if (rank > topN) {
                break;
            }

            System.out.println(
                    rank + ". "
                    + player.getKey()
                    + " - "
                    + player.getValue()
                    + " points"
            );

            rank++;
        }

        System.out.println("\nTotal Players: "
                + playerScores.size());
    }
}
