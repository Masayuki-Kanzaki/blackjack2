package src.main.java.blackjack;

public class Card {
    CardRank rank;
    CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public boolean isAce() {
        return rank.equals(CardRank.ace);
    }

    public boolean isTenCard() {
        if (rank.getPoint() == 10) {
            return true;
        }
        return false;
    }

    public int getCardRankPoint() {
        return rank.getPoint();
    }
/* 
    public CardRank getCardRank() {
        return rank;
    }

    public CardSuit getCardSuit() {
        return suit;
    }
*/
    @Override
    public String toString() {
        return "Card: " + rank + " of " + suit;
    }
}
