import java.util.Random;

class Game {

    static final int HAND_SIZE = 5;

    Deck talon = new Deck();
    Card[] playerHand = new Card[HAND_SIZE];
    int playerHandSize = 0;
    Card[] computerHand = new Card[HAND_SIZE];
    int computerHandSize = 0;
    Card trumpCard;

    void deal(Random random) {
        talon.shuffle(random);
        for (int i = 0; i < HAND_SIZE; i++) {
            playerHand[playerHandSize] = talon.drawCard();
            playerHandSize++;
            computerHand[computerHandSize] = talon.drawCard();
            computerHandSize++;
        }
        trumpCard = talon.revealTrump();
    }

    // Karte an der Stelle index aus der Hand nehmen.
    // Alle Karten dahinter rücken eine Stelle nach vorne, damit keine Lücke entsteht.
    Card playPlayerCard(int index) {
        Card card = playerHand[index];
        for (int i = index; i < playerHandSize - 1; i++) {
            playerHand[i] = playerHand[i + 1];
        }
        playerHandSize--;
        playerHand[playerHandSize] = null;
        return card;
    }

    // Vorerst spielt der Computer immer seine erste Karte.
    Card playComputerCard() {
        Card card = computerHand[0];
        for (int i = 0; i < computerHandSize - 1; i++) {
            computerHand[i] = computerHand[i + 1];
        }
        computerHandSize--;
        computerHand[computerHandSize] = null;
        return card;
    }
}
