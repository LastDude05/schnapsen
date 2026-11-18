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

        while (!game.isOver()) {
            System.out.println();
            playTrick(scanner, game);
            System.out.println("Punktestand: Du " + game.playerPoints
                    + " – Computer " + game.computerPoints);
        }

        System.out.println();
        System.out.println("Spielende!");
        if (game.playerPoints < Game.WINNING_POINTS && game.computerPoints < Game.WINNING_POINTS) {
            System.out.println("Niemand hat 66 Punkte erreicht, deshalb gewinnt, wer den letzten Stich gemacht hat.");
        }
        if (game.playerWinsGame()) {
            System.out.println("Du gewinnst das Spiel mit " + game.playerPoints + " Punkten.");
        } else {
            System.out.println("Der Computer gewinnt das Spiel mit " + game.computerPoints + " Punkten.");
        }
    }

    // Ein Stich: Wer am Ausspielen ist, legt zuerst, der andere antwortet.
    static void playTrick(Scanner scanner, Game game) {
        Card playerCard;
        Card computerCard;
        boolean playerWon;

        if (game.playerLeads) {
            printHand(game);
            int choice = readCardNumber(scanner, game.playerHandSize);
            playerCard = game.playPlayerCard(choice - 1);
            computerCard = game.playComputerCard();
            System.out.println("Du spielst: " + playerCard.label());
            System.out.println("Computer spielt: " + computerCard.label());
            playerWon = !game.responseWins(playerCard, computerCard);
        } else {
            computerCard = game.playComputerCard();
            System.out.println("Computer spielt aus: " + computerCard.label());
            printHand(game);
            int choice = readCardNumber(scanner, game.playerHandSize);
            playerCard = game.playPlayerCard(choice - 1);
            System.out.println("Du spielst: " + playerCard.label());
            playerWon = game.responseWins(computerCard, playerCard);
        }

        int trickPoints = playerCard.points() + computerCard.points();
        if (playerWon) {
            System.out.println("Du gewinnst den Stich (" + trickPoints + " Punkte).");
        } else {
            System.out.println("Der Computer gewinnt den Stich (" + trickPoints + " Punkte).");
        }
        game.scoreTrick(playerWon, playerCard, computerCard);
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
