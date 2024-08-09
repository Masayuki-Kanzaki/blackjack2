package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.Chip;

public class ChipTest {
    @Test
    public void howMuchChip() {
        Chip chip1 = new Chip(1);
        Chip chip2 = new Chip(2);
        Chip chip3 = chip1.add(chip2);
        Assert.assertEquals("[ chip = 3]", chip3.toString());
    }

}