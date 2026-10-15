import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle(new Random());

        System.out.println("Gemischtes Deck:");
        for (int i = 0; i < deck.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, deck.getCard(i).label());
        }
    }
}
