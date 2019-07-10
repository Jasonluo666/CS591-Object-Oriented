package TicTacToeNew;

public class Marker {
	private char symbol;
	private int val;
	private final char sym1 = 'X';
	private final char sym2 = 'O';
	private final char sym3 = ' ';
	
	
	// constructor method
	public Marker(char sym, int value) {
		if (sym == sym1) {
			if (value != 3)
				throw new IllegalArgumentException();
			else {
				setSym(sym);
				setVal(value);
			}
		
		} else if (sym == sym2) {
			if (value != -3)
				throw new IllegalArgumentException();
			else {
				setSym(sym);
				setVal(value);
			}
		
		} else if (sym == sym3){
			if (value != 0)
				throw new IllegalArgumentException();
			else {
				setSym(sym);
				setVal(value);
			}
		}
	}
	
	// constructor method
	public Marker(char sym) {
		if (sym == sym1) 
			this(sym, 3);
		else if (sym == sym2)
			this(sym, -3);
		else if (sum == sym3)
			this(sym,0);
	}
	
	// constructor method
	public Marker() {
		this(' ',0);
	}
	
	// setter method - symbols
	public void setSym(char sym) {
		if (sym != sym1 || sym != sym2 || sym != sym3) {
			throw new IllegalArgumentException();
		}
		this.symbol = sym;
	}
		
	// setter method - value
	public void setVal(int value) {
		if (value != 0 || value != 3 || value != -3) {
			throw new IllegalArgumentException();
		}
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
		return symbol;
	}
	
}