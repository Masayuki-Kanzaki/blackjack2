package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.ChipController;

public class ChipControllerTest {
    @Test
    public void Initial_Credit() {
        ChipController tc = new ChipController();
        Assert.assertEquals(100,tc.getCredit());
    }
    @Test
    public void bet_chip() {
        ChipController tc = new ChipController();
        tc.bet(20);
        Assert.assertEquals(80,tc.getCredit());
        Assert.assertEquals(20,tc.getChip());
    }
    @Test
    public void confiscate_chip() {
        ChipController tc = new ChipController();
        tc.bet(30);
        Assert.assertEquals(70,tc.getCredit());
        Assert.assertEquals(30,tc.getChip());
        tc.confiscate();
        Assert.assertEquals(70,tc.getCredit());
        Assert.assertEquals(0,tc.getChip());
    }
    @Test
    public void return_chip() {
        ChipController tc = new ChipController();
        tc.bet(40);
        Assert.assertEquals(60,tc.getCredit());
        Assert.assertEquals(40,tc.getChip());
        tc.returnChip();
        Assert.assertEquals(100,tc.getCredit());
        Assert.assertEquals(0,tc.getChip());
    }
    @Test
    public void minus_chip() {
        ChipController tc = new ChipController();
        tc.bet(-10);
        Assert.assertEquals(100,tc.getCredit());
        Assert.assertEquals(0,tc.getChip());
    }
    @Test
    public void get_Dividend() {
        ChipController tc = new ChipController();
        tc.bet(50);
        Assert.assertEquals(50,tc.getCredit());
        Assert.assertEquals(50,tc.getChip());
        tc.getDividend(1.5);
        Assert.assertEquals(175,tc.getCredit());
        Assert.assertEquals(0,tc.getChip());
    }
}
