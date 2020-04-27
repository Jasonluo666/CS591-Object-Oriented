
public class Dealer extends Person {
	public Dealer() {
		super();
	}
	
	public boolean continueHit() {
		if(hands.get(0).handValue() < 17)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString(int x) {
		return hands.get(x).toString();
	}
	
	public String showInitCards() {
		return hands.get(0).toString().substring(0, 3) + " and a hidden card";
	}
}
