public class Marker {
	private char symbol;
	private int val;
	private final char sym1 = 'X';
	private final char sym2 = 'O';
	private final char sym3 = ' ';
	
	//constructor method
	public Marker(char sym) {
		if (sym == sym1) {
			setVal(3);
			setSym(sym);
		}
		else if (sym == sym2) {
			setVal(-3);
			setSym(sym);
		}
		else if (sym == sym3) {
			setVal(0);
			setSym(sym);
			
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	// constructor method
	public Marker() {
		this(' ');
	}
	
	// setter method - symbols
	public void setSym(char sym) {
		this.symbol = sym;
	}
		
	// setter method - value
	public void setVal(int value) {
		this.val = value;
	}
	
	// accessor method
	public char getSym() {
		return symbol;
	}
	
	// accessor method
	public int getVal() {
		return val;
	}
		
	// overwriting equals method
	public boolean equals(Marker other) {
		return (other != null && this.symbol == other.symbol && this.val == other.val);
	}
		
	// overwriting toString method
	public String toString() {
		return Character.toString(symbol);
	}
}
