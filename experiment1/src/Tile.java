package TicTacToeNew;

public class Tile {
	private int x;
	private int y;
	private Marker marker;
	private Color clr;
	
	// constructor method
	public Tile(int xpos, int ypos, Marker mrk) {
		setX(xpos);
		setY(ypos);
		setMrk(mrk);
	}
	
	// constructor method
	public Tile(int xpos, int ypos) {
		this(xpos,ypos,Marker());
	}
	
	// accessor method
	public int getXPosition() {
		return x;
	}
	
	// accessor method
	public int getYPosition() {
		return y;
	}
	
	// accessor method
	public Marker getMarker() {
		return marker;
	}
	
	// overwriting equals method
	public boolean equals(Tile other) {
		return (other != null && this.marker == other.marker);
	}
	
	// overwriting toString method
	public String toString() {
		return marker;
	}
	
	// setter method - x position
	public void setX(int xpos) {
		if (xpos < 0) {
			throw new IllegalArgumentException();
		}
		this.x = xpos;
	}
	
	// setter method - y position
	public void setY(int ypos) {
		if (ypos < 0) {
			throw new IllegalArgumentException();
		}
		this.y = ypos;
	}
	
	// setter method - marker
	public void setMrk(Marker mkr) {
		if (mkr.getValue() != 0 || mkr.getValue() != 3 || mkr.getValue() != -3) {
			throw new IllegalArgumentException();
		}
		this.marker = mkr;
	}
	
}
