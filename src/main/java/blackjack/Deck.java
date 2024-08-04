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

    public Deck(List<Card> deck) {
        this.deck = new LinkedList<>(deck);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        Card card = deck.get(0);
        return card;
    }

    public Deck removeCard() {
        List<Card> newDeck = new LinkedList<>(this.deck);
        newDeck.remove(0);
        return new Deck(newDeck);
    }

    // unit test用
    public Deck addCard(Card card) {
        List<Card> newDeck = new LinkedList<>(this.deck);
        newDeck.add(card);
        return new Deck(newDeck);
    }

}