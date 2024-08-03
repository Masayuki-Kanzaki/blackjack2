package src.main.java.blackjack;

public enum CardRank {
    // Aceのポイントは２つとりえるため、ここではポイントが決まらない
    ace(),
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine(9),
    ten(10),
    jack(10),
    queen(10),
    king(10);

    private int point;

    private CardRank(int point) {
	    this.point = point;
    }

    // Ace用
    private CardRank() {
    }

    public int getPoint() {
        return point;
    }
}
