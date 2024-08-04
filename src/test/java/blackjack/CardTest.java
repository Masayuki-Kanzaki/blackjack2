package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.Card;
import src.main.java.blackjack.CardSuit;
import src.main.java.blackjack.CardRank;

public class CardTest {
    @Test
    public void isAce() {
        Card card = new Card(CardRank.ace, CardSuit.Diamonds);
        Assert.assertTrue(card.isAce());
        Card card2 = new Card(CardRank.two, CardSuit.Hearts);
        Assert.assertFalse(card2.isAce());
    }

    @Test
    public void howManyPoint() {
        Card card2 = new Card(CardRank.two, CardSuit.Hearts);
        Assert.assertEquals(2, card2.getCardRankPoint());
        Card cardAce = new Card(CardRank.ace, CardSuit.Hearts);
        Assert.assertEquals(0, cardAce.getCardRankPoint());
        Card cardJack = new Card(CardRank.jack, CardSuit.Hearts);
        Assert.assertEquals(10, cardJack.getCardRankPoint());
    }

    @Test
    public void isTenCard() {
        Card cardTen = new Card(CardRank.ten, CardSuit.Diamonds);
        Assert.assertTrue(cardTen.isTenCard());
        Card card2 = new Card(CardRank.two, CardSuit.Hearts);
        Assert.assertFalse(card2.isTenCard());
    }

}
