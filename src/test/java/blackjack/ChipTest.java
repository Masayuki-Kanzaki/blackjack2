package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.Chip;

public class ChipTest {
    @Test
    public void add_howMuchChip() {
        Chip chip1 = new Chip(1);
        Chip chip2 = new Chip(2);
        Chip chip3 = chip1.add(chip2);
        Assert.assertEquals("[ chip = 3]", chip3.toString());
    }

    @Test
    public void subtract_howMuchChip() {
        Chip chip100 = new Chip(100);
        Chip chip20 = new Chip(20);
        Chip chip80 = chip100.subtract(chip20);
        Assert.assertEquals("[ chip = 80]", chip80.toString());
    }
}