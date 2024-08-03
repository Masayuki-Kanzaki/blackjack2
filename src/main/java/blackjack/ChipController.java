package src.main.java.blackjack;

public class ChipController {
    final int INITIAL_CREDIT = 100;
	private int credit;
	private int chip;

	public ChipController() {
		setCredit(INITIAL_CREDIT); 
	}

	public String toString() {
		return "[ credit = " + credit + " ]";
	}

	private void setCredit(int c) {
		credit = c;	
	}

	public int getCredit() {
		return credit;	
	}

	private void setChip(int t) {
		chip = t;	
	}

	public int getChip() {
		return chip;	
	}

	public int bet(int chip) {
		if (chip < 0) {
			chip = 0;
		}
		if (credit - chip < 0) {
			chip = credit;
		}
		setChip(chip);	
		credit = credit - chip;
		return chip;
	}

	public void confiscate() {
		chip = 0;	
	}

	public void returnChip() {
		credit = credit + chip;
		chip = 0;	
	}

	public void getDividend(double ratio) {
		if (ratio < 0) {
			ratio = 1;
		}
		credit = credit + (int)(chip * ratio);
		// 計算結果が小数点以下の値が発生した場合の考慮が必要か？今は切り捨て
		returnChip();
	}

}
