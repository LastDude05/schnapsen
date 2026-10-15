import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.deal(new Random());

        System.out.println("Deine Hand:");
        for (int i = 0; i < game.playerHandSize; i++) {
            System.out.printf("%d. %s%n", i + 1, game.playerHand[i].label());
        }
        System.out.println("Trumpf: " + game.trumpCard.label());
        System.out.println("Talon: " + game.talon.size() + " Karten (inklusive Trumpfkarte)");
        System.out.println("Computer: " + game.computerHandSize + " Karten (verdeckt)");
    }
}
