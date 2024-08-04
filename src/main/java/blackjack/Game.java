package src.main.java.blackjack;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private Hand player;
    private Hand dealer;
    private ChipController chipController;
    private Scanner scanner;

    public Game(Deck deck, Hand player, Hand dealer, ChipController chipController, Scanner scanner) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
        this.chipController = chipController;
        this.scanner = scanner;
        dealInitialCards();
    }

    private void dealInitialCards() {
        player.addCard(deck.drawCard());
        deck = deck.removeCard();
        player.addCard(deck.drawCard());
        deck = deck.removeCard();
        player.sumPoints();
        System.out.println("Player's hand: ");
        player.showCards();

        dealer.addCard(deck.drawCard());
        deck = deck.removeCard();
        System.out.println("Dealer's  hand: ");
        dealer.showCards();
        dealer.addCard(deck.drawCard());
        deck = deck.removeCard();
        dealer.sumPoints();
    }

    private void dealerTurn() {
        while (!dealer.isDealerHandSeventeenOrMore() && !dealer.isBlackjack()) {
            dealer.addCard(deck.drawCard());
            deck = deck.removeCard();
            dealer.sumPoints();
        }
        System.out.println("Dealer's hand: ");
        dealer.showCards();
    }

    private void determineWinner() {
        double ratio;
        if (dealer.isBust()) {
            System.out.println("Player wins.");
            if (player.isBlackjack()) {
                ratio = 1.5;
            } else {
                ratio = 1.0;
            }
            chipController.getDividend(ratio);
        } else if (player.isBust()) {
            System.out.println("Player loses.");
            chipController.confiscate();
        } else if (player.sumPoints() > dealer.sumPoints()) {
            System.out.println("Player wins.");
            if (player.isBlackjack()) {
                ratio = 1.5;
            } else {
                ratio = 1.0;
            }
            chipController.getDividend(ratio);
        } else if (player.sumPoints() < dealer.sumPoints()) {
            System.out.println("Dealer wins. Player loses.");
            chipController.confiscate();
        } else {
            System.out.println("Player draws.");
            chipController.returnChip();
        } 
    }

    private void placeBet() {
        while (true) {
            System.out.println("You have " + chipController.getCredit() + " credit. How many chips would you like to bet?");
            int chip = scanner.nextInt();
            scanner.nextLine();
            try {
                int betChip = chipController.bet(chip);
                System.out.println("You have bet " + betChip + ". Remaining credit: " + chipController.getCredit());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid bet. Not enough chips.");
            }
        }
    }

    public void play() {
        placeBet();

        while (true) {
            System.out.println("Do you want to 'hit' or 'stand'?");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("hit")) {
                player.addCard(deck.drawCard());
                deck = deck.removeCard();
                player.sumPoints();
                System.out.println("Player's hand: ");
                player.showCards();
                if (player.isBust()) {
                    System.out.println("Player busts! Dealer wins");
                    chipController.confiscate();
                    break;
                }
            } else if (action.equalsIgnoreCase("stand")) {
                System.out.println("Player stands! Dealer's turn.");
                dealerTurn();
                determineWinner();
                break;
            } else {
                System.out.println("Invalid action. Please type 'hit' or 'stand'.");
            }
        }
    }
}