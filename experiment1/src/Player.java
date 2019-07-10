//
//public class player {
//	private int wins =0;
//	
//	public int getWins() {
//		return wins;
//	}
//	
//	public void setWins() {
//		wins++;
//	}
//}

import java.util.Scanner;

public class Player {
	private Marker marker;
	private String name;
	private ScoreCard score;
	private char symbol;
	
	public Player() {}
	
	public Player(String name,char sym) {
		this.name = name;
		this.symbol = sym;
		this.marker = new Marker(sym);
		this.score = new ScoreCard();
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
		
		System.out.print("Player " + name + " - make your move: ");
		int x;
		x = scan.nextInt();
		
		board.board = board.board.replaceFirst(Integer.toString(x), marker.toString());

	}
	
	public void showScore() {
		System.out.print("Player " + name + " wins " + score.getWin() + " times, loses " + score.getLose() + "times\n");
	}
}