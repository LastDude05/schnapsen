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
}
