package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.*;

public class DeckTest {
    @Test
    public void drawCard_and_removeCard() {
        Card card1 = new Card(CardRank.ace, CardSuit.Diamonds);
        Card card2 = new Card(CardRank.two, CardSuit.Diamonds);

        Deck deck =new Deck();
        for (int i = 0; i < 52; i++) {
            deck.drawCard();
            deck = deck.removeCard();
        }
        deck = deck.addCard(card1);
        Assert.assertEquals(1, deck.drawCard().getCardRankPoint());
        deck = deck.removeCard();
        deck = deck.addCard(card2);
        Assert.assertEquals(2, deck.drawCard().getCardRankPoint());
        deck = deck.removeCard();
    }
}
