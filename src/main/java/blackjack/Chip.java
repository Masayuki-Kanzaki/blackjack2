package src.main.java.blackjack;

public class Chip {
    static final int MIN = 0;
    static final int MAX = 100000000;

    private int value;

    public Chip(int value) {
        if (value < MIN) {throw new
            IllegalArgumentException("INVALID: less than " + MIN);}
        if (value > MAX) {throw new
            IllegalArgumentException("INVALID: more than " + MAX);}
        this.value = value;
    }

    public boolean canAdd(Chip other) {
        int added = addValue(other);
        return added <= MAX;
    }

    public Chip add(Chip other) {
        if ( ! canAdd(other) ) {throw new
            IllegalArgumentException("INVALID: Total is more than " + MAX);}
        int added = addValue(other);
        return new Chip(added);
    }

    private int addValue(Chip other) {
        return this.value + other.value;
    }

    @Override
    public String toString() {
        return "[ chip = " + value + "]";
    }
}
