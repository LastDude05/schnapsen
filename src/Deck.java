import java.util.Random;

class Deck {

    static final String[] SUITS = {"Herz", "Schelle", "Eichel", "Laub"};
    static final String[] RANKS = {"Ass", "Zehn", "König", "Ober", "Unter"};
    static final int[] POINTS = {11, 10, 4, 3, 2};

    Card[] cards = new Card[20];
    int size;

    Deck() {
        size = 0;
        for (int s = 0; s < SUITS.length; s++) {
            for (int r = 0; r < RANKS.length; r++) {
                cards[size] = new Card(SUITS[s], RANKS[r], POINTS[r]);
                size++;
            }
        }
    }

    // Fisher-Yates: von hinten nach vorne jede Karte mit einer zufälligen
    // Karte an Position 0..i tauschen (auch mit sich selbst möglich).
    void shuffle(Random random) {
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    int size() {
        return size;
    }

    Card getCard(int index) {
        return cards[index];
    }
}
