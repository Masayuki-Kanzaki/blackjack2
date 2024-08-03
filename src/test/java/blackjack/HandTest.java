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
/* 
    @Test
    public void add_Card() {
        Hand hand2 = new Hand();
        hand2.addCard(new Card(CardRank.two, CardSuit.Diamonds));
        Assert.assertEquals(2, hand2.showPoints());
        hand2.addCard(new Card(CardRank.two, CardSuit.heart));
        Assert.assertEquals(4, hand2.showPoints());
    }
*/
    @Test
    public void count_Ace() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countAce());
        hand.addCard(new Card(CardRank.two, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countAce());
        hand.addCard(new Card(CardRank.ace, CardSuit.Hearts));
        Assert.assertEquals(2, hand.countAce());

        Hand hand2 = new Hand();
        hand2.addCard(new Card(CardRank.two, CardSuit.Diamonds));
        Assert.assertEquals(0, hand2.countAce());
    }

    @Test
    public void count_TenCard() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countTenCard());
        hand.addCard(new Card(CardRank.nine, CardSuit.Diamonds));
        Assert.assertEquals(1, hand.countTenCard());
        hand.addCard(new Card(CardRank.jack, CardSuit.Hearts));
        Assert.assertEquals(2, hand.countTenCard());

        Hand hand2 = new Hand();
        hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(0, hand2.countTenCard());
    }

    @Test
    public void sum_Points_WithoutAce() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        hand.addCard(new Card(CardRank.eight, CardSuit.Diamonds));
        Assert.assertEquals(18, hand.sumPointsWithoutAce());
        hand.addCard(new Card(CardRank.two, CardSuit.Diamonds));
        Assert.assertEquals(20, hand.sumPointsWithoutAce());

        Hand hand2 = new Hand();
        hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(0, hand2.sumPointsWithoutAce());
        hand2.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(10, hand2.sumPointsWithoutAce());
        hand2.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(20, hand2.sumPointsWithoutAce());
        hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(20, hand2.sumPointsWithoutAce());
    }

    @Test
    public void sum_Points() {
        Hand hand3 = new Hand();
        hand3.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand3.addCard(new Card(CardRank.two, CardSuit.Hearts));
        Assert.assertEquals(13, hand3.sumPoints());
        hand3.addCard(new Card(CardRank.eight, CardSuit.Hearts));
        Assert.assertEquals(21, hand3.sumPoints());
    }
    @Test
    public void sum_Points2() {
        Hand hand3 = new Hand();
        hand3.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand3.addCard(new Card(CardRank.two, CardSuit.Hearts));
        Assert.assertEquals(13, hand3.sumPoints());
        hand3.addCard(new Card(CardRank.five, CardSuit.Hearts));
        Assert.assertEquals(18, hand3.sumPoints());
    }
    @Test
    public void sum_Points3() {
        Hand hand3 = new Hand();
        hand3.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand3.addCard(new Card(CardRank.two, CardSuit.Hearts));
        hand3.addCard(new Card(CardRank.five, CardSuit.Hearts));
        Assert.assertEquals(18, hand3.sumPoints());
    }
    @Test
    public void sum_Points4() {
        Hand hand3 = new Hand();
        hand3.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand3.addCard(new Card(CardRank.two, CardSuit.Hearts));
        hand3.addCard(new Card(CardRank.eight, CardSuit.Hearts));
        Assert.assertEquals(21, hand3.sumPoints());
        Assert.assertFalse(hand3.isBlackjack());
    }
    @Test
    public void sum_Points5_for_blackjack() {
        Hand hand5 = new Hand();
        hand5.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand5.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(21, hand5.sumPoints());
        Assert.assertTrue(hand5.isBlackjack());
    }
    @Test
    public void sum_Points6_for_bust() {
        Hand hand6 = new Hand();
        hand6.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        hand6.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        hand6.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(30, hand6.sumPoints());
        Assert.assertTrue(hand6.isBust());
    }
    @Test
    public void isAceForEleven() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        hand.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(21, hand.sumPoints());
        Assert.assertFalse(hand.isAceForEleven());

        Hand hand2 = new Hand();
        hand2.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand2.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(21, hand2.sumPoints());
        Assert.assertTrue(hand2.isAceForEleven());

        Hand hand3 = new Hand();
        hand3.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        hand3.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        hand3.addCard(new Card(CardRank.queen, CardSuit.Diamonds));
        Assert.assertEquals(21, hand3.sumPoints());
        Assert.assertFalse(hand3.isAceForEleven());
    }
    @Test
    public void isDealerHandSeventeenOrMore() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardRank.eight, CardSuit.Diamonds));
        hand.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(18, hand.sumPoints());
        Assert.assertTrue(hand.isDealerHandSeventeenOrMore());

        Hand hand2 = new Hand();
        hand2.addCard(new Card(CardRank.seven, CardSuit.Diamonds));
        hand2.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        Assert.assertEquals(17, hand2.sumPoints());
        Assert.assertTrue(hand2.isDealerHandSeventeenOrMore());

        Hand hand3 = new Hand();
        hand3.addCard(new Card(CardRank.six, CardSuit.Diamonds));
        hand3.addCard(new Card(CardRank.ace, CardSuit.Diamonds));
        Assert.assertEquals(17, hand3.sumPoints());
        Assert.assertFalse(hand3.isDealerHandSeventeenOrMore());

        Hand hand4 = new Hand();
        hand4.addCard(new Card(CardRank.six, CardSuit.Diamonds));
        hand4.addCard(new Card(CardRank.ten, CardSuit.Diamonds));
        Assert.assertEquals(16, hand4.sumPoints());
        Assert.assertFalse(hand4.isDealerHandSeventeenOrMore());
    }
    @Test
    public void is_bust() {
        Hand hand6 = new Hand();
        hand6.addCard(new Card(CardRank.three, CardSuit.Diamonds));
        hand6.addCard(new Card(CardRank.jack, CardSuit.Diamonds));
        hand6.addCard(new Card(CardRank.nine, CardSuit.Diamonds));
        // これは問題にならないか？
        Assert.assertFalse(hand6.isBust());
        Assert.assertEquals(22, hand6.sumPoints());
        Assert.assertTrue(hand6.isBust());
    }
/*
    // printlnの複数行テストを試したが、うまくテストできないため、コメントアウト
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    public void MultiLinePrintln() { 

        System.out.print("Card: two of diasmond");
        String actualOutput = outContent.toString().trim();
        String expectedOutput = "Card: two of diasmond";
        Assert.assertEquals(expectedOutput, actualOutput);

        System.out.print("redirection test");
        String redirectionTestOutput = outContent.toString().trim();
//        Assert.assertEquals("redirection test", redirectionTestOutput, "redirection is not working");
        Assert.assertEquals("redirection test", redirectionTestOutput);

    }
*/
}
