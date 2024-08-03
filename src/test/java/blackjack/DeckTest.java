package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.*;

public class DeckTest {
    @Test
    public void addCard_and_drawCard() {
        Card card1 = new Card(CardRank.ace, CardSuit.Diamonds);
        Card card2 = new Card(CardRank.two, CardSuit.Diamonds);

        Deck deck =new Deck();
        deck.addCard(card1);
        deck.addCard(card2);
//        Assert.assertEquals(0, deck.drawCard().getCardRankPoint());
//        Assert.assertEquals(2, deck.drawCard().getCardRankPoint());
//      Assert.assertEquals(2, deck.drawCard().getCardRankPoint());
    }

    @Test
    public void shuffle() {
        Card card1 = new Card(CardRank.ace, CardSuit.Diamonds);
        Card card2 = new Card(CardRank.two, CardSuit.Diamonds);

        Deck deck =new Deck();
        deck.addCard(card1);
        deck.addCard(card2);
        deck.shuffle();
//        Assert.assertEquals(0, deck.drawCard().getCardRankPoint() % 2);
    }

}
