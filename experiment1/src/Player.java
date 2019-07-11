import java.util.Scanner;

public class Player {
	private Marker marker;
	private String name;
	private ScoreCard scoreCard;
	private char symbol;
	
	public Marker getMarker() {
		return marker;
	}
	
	public void setWin() {
		scoreCard.setWin();
	}
	
	public void setLose() {
		scoreCard.setLose();
	}

	
	public Player() {}
	
	public Player(String name,char sym) {
		this.name = name;
		this.symbol = sym;
		this.marker = new Marker(sym);
		this.scoreCard = new ScoreCard();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSymbol(char sym) {
		this.symbol = sym;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void makeMove(Board board) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Player " + name + " - make your move: ");
		
		int x;
		x = scan.nextInt();
	
		board.contains(x,marker);
	}
	
	public void showScore() {
		System.out.println("Player " + name + " wins " + scoreCard.getWin() + " times, loses " + scoreCard.getLose() + " times.\n");
	}
}