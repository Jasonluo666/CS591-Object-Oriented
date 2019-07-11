
import java.util.Scanner;

public class Game{
	private Player playerOne;
	private Player playerTwo;
	private Board board;
	private int gameNum = 1;
	private int size;
	
	public void init() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please input Player 1's name: ");
		
		
		String name = scan.nextLine();
		
		System.out.print("Please input Player 1's symbol: capital X or O");
		String sym = scan.nextLine();
		
		playerOne = new Player(name,sym.charAt(0));
		
		System.out.print("Please input Player 2's name: ");
		name = scan.nextLine();
		
		System.out.print("Please input Player 2's symbol: capital X or O");
		sym = scan.nextLine();
		playerTwo = new Player(name,sym.charAt(0));
	}
	
	public void startGame() {
		
		int step = 0;
		
		Marker marker;
		
		System.out.print("Game start.\n");
		
		while(true) {
		
			System.out.print(board);
			
			playerOne.makeMove(board);
			
			step ++;
			
			if(board.checkWin() != null || step == board.length * board.length)
				break;
			
			System.out.print(board);
			
			playerTwo.makeMove(board);
			
			step ++;
			
			if(board.checkWin() != null || step == board.length * board.length)
				break;
		}
		
		marker = board.checkWin();
		
		if(playerOne.getMarker().equals(marker)) {
			System.out.println(board);
			System.out.println("Player " + playerOne.getName() + " wins!");
			
			playerOne.setWin();
			playerTwo.setLose();
		}
		else if(playerTwo.getMarker().equals(marker)) {
			System.out.println(board);
			System.out.println("Player " + playerTwo.getName() + " wins!");
			
			playerTwo.setWin();
			playerOne.setLose();
		}else {
			System.out.println(board);
			System.out.println("Draw game !");
		}
	}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			if (gameNum == 1) {
				System.out.println("Please input the game size:");
				size = scan.nextInt();
			}
			
			else if (gameNum > 1) {
				System.out.println("Do you want to start a new game? (y/n)");
				scan.nextLine();
				String ch = scan.nextLine();
				
				if(ch.equals("n")) {
					
					System.out.println("Game Summary:");
					
					playerOne.showScore();
					playerTwo.showScore();
					
					System.out.println("Thanks for playing :)");
					
					break;
				}
			}
			
			board = new Board(size);
			startGame();
			gameNum++;
		}
		
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.init();
		g.run();
	}
}