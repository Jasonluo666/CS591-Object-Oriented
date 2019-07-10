import java.util.Scanner;

public class Player {
	private Marker mark;
	private String name;
	private ScoreCard score;
	
	public Player() {}
	
	public Player(String name) {
		this.name = name;
		this.mark = new Marker(param);
		this.score = new ScoreCard();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Tile makeMove() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Player " + name + " - make your move: ");
		int x, y;
		x = scan.nextInt();
		y = scan.nextInt();
		
		Tile t = new Tile(x, y, mark);
		return t;
	}
	
	public String showScore() {
		System.out.print("Player " + name + " wins " + score.getWin() + " times, loses " + score.getLose() + "times\n");
	}
}