
import java.util.Random;
import java.util.Scanner;

// Enum representing the five possible moves
enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
}

public class RPSLS {

    // Method to decide the winner
    // Returns 1 if player A wins
    // Returns -1 if player B wins
    // Returns 0 for a tie
    public static int winner(Move a, Move b) {

        // Check for a tie
        if (a == b) {
            return 0;
        }

        // Switch expression to determine the winner
        return switch (a) {

            // Rock crushes Scissors and Lizard
            case ROCK ->
                (b == Move.SCISSORS || b == Move.LIZARD) ? 1 : -1;

            // Paper covers Rock and disproves Spock
            case PAPER ->
                (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;

            // Scissors cut Paper and decapitate Lizard
            case SCISSORS ->
                (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;

            // Lizard poisons Spock and eats Paper
            case LIZARD ->
                (b == Move.SPOCK || b == Move.PAPER) ? 1 : -1;

            // Spock smashes Scissors and vaporizes Rock
            case SPOCK ->
                (b == Move.SCISSORS || b == Move.ROCK) ? 1 : -1;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Array containing all possible moves
        Move[] moves = Move.values();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("===== ROCK PAPER SCISSORS LIZARD SPOCK =====");

        // Play exactly five rounds
        for (int round = 1; round <= 5; round++) {

            System.out.println("\n----- Round " + round + " -----");

            Move playerMove = null;

            // Read a valid player move
            while (playerMove == null) {

                System.out.print("Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");

                String input = sc.next().trim().toUpperCase();

                try {
                    playerMove = Move.valueOf(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid move! Please try again.");
                }
            }

            // Generate a random computer move
            Move computerMove = moves[random.nextInt(moves.length)];

            System.out.println("Your move: " + playerMove);
            System.out.println("Computer move: " + computerMove);

            // Decide the round winner
            int result = winner(playerMove, computerMove);

            if (result == 1) {

                System.out.println("You win this round!");
                playerScore++;

            } else if (result == -1) {

                System.out.println("Computer wins this round!");
                computerScore++;

            } else {

                System.out.println("This round is a tie!");
            }

            System.out.println("Score: You " + playerScore
                    + " - " + computerScore + " Computer");
        }

        // Display final result
        System.out.println("\n===== FINAL RESULT =====");

        if (playerScore > computerScore) {

            System.out.println("You win " + playerScore
                    + " - " + computerScore);

        } else if (computerScore > playerScore) {

            System.out.println("Computer wins "
                    + computerScore + " - " + playerScore);

        } else {

            System.out.println("Match tied " + playerScore
                    + " - " + computerScore);
        }

        sc.close();
    }
}
