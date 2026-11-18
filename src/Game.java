import java.util.Random;

class Game {

    static final int HAND_SIZE = 5;
    static final int WINNING_POINTS = 66;

    Deck talon = new Deck();
    Card[] playerHand = new Card[HAND_SIZE];
    int playerHandSize = 0;
    Card[] computerHand = new Card[HAND_SIZE];
    int computerHandSize = 0;
    Card trumpCard;
    int playerPoints = 0;
    int computerPoints = 0;
    boolean playerLeads = true;

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

    // Stichauswertung: Die ausgespielte Karte gewinnt, außer die Antwortkarte
    // hat dieselbe Farbe und einen höheren Rang, oder sie ist Trumpf und die ausgespielte Karte nicht.
    boolean responseWins(Card lead, Card response) {
        String trumpSuit = trumpCard.suit();
        if (response.suit().equals(lead.suit())) {
            return rankValue(response) > rankValue(lead);
        }
        if (response.suit().equals(trumpSuit)) {
            return true;
        }
        return false;
    }

    // Die Punkte einer Karte entsprechen ihrer Rangfolge (Ass 11 > Zehn 10 > König 4 > Ober 3 > Unter 2).
    int rankValue(Card card) {
        return card.points();
    }

    // Der Stichgewinner bekommt die Punkte beider Karten und spielt als Nächstes aus.
    void scoreTrick(boolean playerWon, Card first, Card second) {
        int trickPoints = first.points() + second.points();
        if (playerWon) {
            playerPoints += trickPoints;
        } else {
            computerPoints += trickPoints;
        }
        playerLeads = playerWon;
    }

    // Das Spiel endet, sobald eine Seite 66 Punkte hat oder keine Karten mehr auf der Hand sind.
    boolean isOver() {
        return playerPoints >= WINNING_POINTS
                || computerPoints >= WINNING_POINTS
                || playerHandSize == 0;
    }

    // Hat niemand 66 Punkte, gewinnt die Seite mit dem letzten Stich.
    // Der letzte Stichgewinner ist der, der jetzt am Ausspielen wäre.
    boolean playerWinsGame() {
        if (playerPoints >= WINNING_POINTS) {
            return true;
        }
        if (computerPoints >= WINNING_POINTS) {
            return false;
        }
        return playerLeads;
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
