import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.deal(new Random());

        System.out.println("Trumpf: " + game.trumpCard.label());
        System.out.println("Talon: " + game.talon.size() + " Karten (inklusive Trumpfkarte)");
        System.out.println("Computer: " + game.computerHandSize + " Karten (verdeckt)");
        System.out.println();
        printHand(game);

        int choice = readCardNumber(scanner, game.playerHandSize);
        Card playerCard = game.playPlayerCard(choice - 1);
        Card computerCard = game.playComputerCard();

        System.out.println("Du spielst: " + playerCard.label());
        System.out.println("Computer spielt: " + computerCard.label());
        System.out.println();
        printHand(game);
    }

    static void printHand(Game game) {
        System.out.println("Deine Hand:");
        for (int i = 0; i < game.playerHandSize; i++) {
            System.out.printf("%d. %s%n", i + 1, game.playerHand[i].label());
        }
    }

    // Fragt so lange nach, bis eine Zahl zwischen 1 und max eingegeben wird.
    static int readCardNumber(Scanner scanner, int max) {
        while (true) {
            System.out.print("Welche Karte spielst du? (1-" + max + "): ");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
                continue;
            }
            int number = scanner.nextInt();
            scanner.nextLine();
            if (number < 1 || number > max) {
                System.out.println("Ungültige Zahl. Bitte eine Zahl von 1 bis " + max + " eingeben.");
                continue;
            }
            return number;
        }
    }
}
