package src.main.java.blackjack;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() {
        deck = new LinkedList<>();
        CardRank[] cardRanks = CardRank.values();
        CardSuit[] cardSuits = CardSuit.values();
        
        for (CardRank rank : cardRanks) {
            for (CardSuit suit : cardSuits) {
                deck.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    public void addCard(Card card) {
        // unit test用
        deck.add(card);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }
}