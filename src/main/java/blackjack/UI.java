package src.main.java.blackjack;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        ChipController chipController = new ChipController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to play BlackJack? 'Yes' or 'No'?");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("Yes")) {
                if (chipController.getCredit() == 0) {
                    System.out.println("No credit. Bye.");
                    break;
                }
                Deck deck = new Deck();
                Hand player = new Hand();
                Hand dealer = new Hand();
                Game game = new Game(deck, player, dealer, chipController, scanner);
                game.play();
                System.out.println("You have credit: " + chipController.getCredit());
            } else if (action.equalsIgnoreCase("No")) {
                System.out.println("You have " + chipController.getCredit() + " credit left.");
                System.out.println("See you soon. Bye!");
                break;
            } else {
                System.out.println("Invalid action. Please type 'Yes' or 'No'.");
            }
        }
    }
}