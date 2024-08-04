package src.test.java.blackjack;
/*
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
*/
import org.junit.*;
/*
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
*/
import src.main.java.blackjack.*;

public class HandTest {
    @Test
    public void count_Ace() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countAce());
        hand = hand.addCard(new Card(CardRank.two, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countAce());
        hand = hand.addCard(new Card(CardRank.ace, CardSuit.Hearts));
        Assert.assertEquals(2, hand.countAce());

        Hand hand2 = new Hand();
        hand2 = hand2.addCard(new Card(CardRank.two, CardSuit.Diamonds));
        Assert.assertEquals(0, hand2.countAce());
    }

    @Test
    public void count_TenCard() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countTenCard());
        hand = hand.addCard(new Card(CardRank.nine, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countTenCard());
        hand = hand.addCard(new Card(CardRank.jack, CardSuit.Hearts));
        Assert.assertEquals(2, hand.countTenCard());

        Hand hand2 = new Hand();
        hand2 = hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(0, hand2.countTenCard());
    }

    @Test
    public void sum_Points_WithoutAce() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.eight, CardSuit.Diamonds));
        Assert.assertEquals(18, hand.sumPointsWithoutAce());
        hand = hand.addCard(new Card(CardRank.two, CardSuit.Diamonds));
        Assert.assertEquals(20, hand.sumPointsWithoutAce());

        Hand hand2 = new Hand();
        hand2 = hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(0, hand2.sumPointsWithoutAce());
        hand2 = hand2.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(10, hand2.sumPointsWithoutAce());
        hand2 = hand2.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(20, hand2.sumPointsWithoutAce());
        hand2 = hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(20, hand2.sumPointsWithoutAce());
    }

    @Test
    public void sum_Points_total21_with_aceFor11() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.two, CardSuit.Hearts));
        Assert.assertEquals(13, hand.sumPoints());
        hand = hand.addCard(new Card(CardRank.eight, CardSuit.Hearts));
        Assert.assertEquals(21, hand.sumPoints());
    }

    @Test
    public void sum_Points_total21_with_aceFor1() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.two, CardSuit.Hearts));
        hand = hand.addCard(new Card(CardRank.eight, CardSuit.Hearts));
        hand = hand.addCard(new Card(CardRank.ten, CardSuit.Hearts));
        Assert.assertEquals(21, hand.sumPoints());
        Assert.assertFalse(hand.isBlackjack());
    }

    @Test
    public void sum_Points_total21_without_ace() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.two, CardSuit.Hearts));
        hand = hand.addCard(new Card(CardRank.three, CardSuit.Diamonds));
        Assert.assertEquals(5, hand.sumPoints());
        hand = hand.addCard(new Card(CardRank.six, CardSuit.Hearts));
        hand = hand.addCard(new Card(CardRank.jack, CardSuit.Hearts));
        Assert.assertEquals(21, hand.sumPoints());
        Assert.assertFalse(hand.isBlackjack());
    }

    @Test
    public void sum_Points_bust() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.five, CardSuit.Hearts));
        hand = hand.addCard(new Card(CardRank.two, CardSuit.Hearts));
        hand = hand.addCard(new Card(CardRank.five, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(22, hand.sumPoints());
        Assert.assertTrue(hand.isBust());
    }

    @Test
    public void sum_Points_for_blackjack() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(21, hand.sumPoints());
        Assert.assertTrue(hand.isBlackjack());
    }
    @Test
    public void sum_Points_for_bust() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(30, hand.sumPoints());
        Assert.assertTrue(hand.isBust());
    }
    @Test
    public void isAceForEleven() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(21, hand.sumPoints());
        Assert.assertFalse(hand.isAceForEleven());

        Hand hand2 = new Hand();
        hand2 = hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand2 = hand2.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(21, hand2.sumPoints());
        Assert.assertTrue(hand2.isAceForEleven());
    }

    @Test
    public void isDealerHandSeventeenOrMore() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.eight, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(18, hand.sumPoints());
        Assert.assertTrue(hand.isDealerHandSeventeenOrMore());

        Hand hand2 = new Hand();
        hand2 = hand2.addCard(new Card(CardRank.seven, CardSuit.Diamonds));
        hand2 = hand2.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(17, hand2.sumPoints());
        Assert.assertTrue(hand2.isDealerHandSeventeenOrMore());

        Hand hand3 = new Hand();
        hand3 = hand3.addCard(new Card(CardRank.six, CardSuit.Diamonds));
        hand3 = hand3.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(17, hand3.sumPoints());
        Assert.assertFalse(hand3.isDealerHandSeventeenOrMore());

        Hand hand4 = new Hand();
        hand4 = hand4.addCard(new Card(CardRank.six, CardSuit.Diamonds));
        hand4 = hand4.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        Assert.assertEquals(16, hand4.sumPoints());
        Assert.assertFalse(hand4.isDealerHandSeventeenOrMore());

        Hand hand5 = new Hand();
        hand5 = hand4.addCard(new Card(CardRank.six, CardSuit.Diamonds));
        hand5 = hand4.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        hand5 = hand4.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(17, hand5.sumPoints());
        Assert.assertTrue(hand5.isDealerHandSeventeenOrMore());
    }

    @Test
    public void is_bust() {
        Hand hand = new Hand();
        hand = hand.addCard(new Card(CardRank.three, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        hand = hand.addCard(new Card(CardRank.nine, CardSuit.Diamonds));
        // これは分かりにくくないか？問題にならないか？
        // sumPointsの中でbustをセットしているので、実施前後で値が異なる
        Assert.assertFalse(hand.isBust());
        Assert.assertEquals(22, hand.sumPoints());
        Assert.assertTrue(hand.isBust());
    }
}
