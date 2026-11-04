
public class Driver {

    public static void main(String[] args) {

        // Create an array of Card objects
        Card[] cards = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Clubs")
        };

        // Check for duplicate cards
        for (int i = 0; i < cards.length; i++) {

            for (int j = 0; j < i; j++) {

                if (cards[i].equals(cards[j])) {

                    System.out.println(
                        "Duplicate found: " + cards[i]
                    );

                    return;
                }
            }
        }

        System.out.println("No duplicate found.");
    }
}
