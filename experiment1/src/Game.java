import java.util.Scanner;

public class Game{

	// Two Players of the game
	private Player playerOne;
	private Player playerTwo;
	private Board board;
	//Game enumeration - starts with 1
	private int gameNum = 1;
	// size of the board
	private int size;
	
	// initialization of the game - getting user input
	public void init() {
		
		// Getting user input: Players' names and chosen symbols (X/O)
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input Player 1's name: ");
		
		
		String name = scan.nextLine();
		System.out.print("Please input Player 1's symbol, capital X or O: ");
		String sym = scan.nextLine();
		
		playerOne = new Player(name,sym.charAt(0));
		
		System.out.print("Please input Player 2's name: ");
		name = scan.nextLine();
		
		System.out.print("Please input Player 2's symbol, capital X or O: ");
		sym = scan.nextLine();
		playerTwo = new Player(name,sym.charAt(0));
	}
	
	
	// Starting the game, playing the game, and checking for a winner or a draw
	public void startGame() {
		
		// step number in a game
		int step = 0;
		Marker marker;
		
		System.out.print("Game start.\n");
		
		while(true) {
			// displays the board, asks PlayerOne to make a move
			System.out.print(board);
			playerOne.makeMove(board);
			
			step ++;
			
			// check if the made move makes a win
			if(board.checkWin() != null || step == board.length * board.length)
				break;
			
			// display the board with a made move
			System.out.print(board);
			
			// asks PlayerTwo to make a move
			playerTwo.makeMove(board);
			
			step ++;
			// check if the made move makes a win
			if(board.checkWin() != null || step == board.length * board.length)
				break;
		}
		
		// if there is a win, save a marker of that player
		marker = board.checkWin();
		
		// check who won the game out of the two players, display game statistics
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
	
	// running the game - getting board size from user, checking if they would like to play another game
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		// gets board size
		while(true) {
			// if the first game, ask for the board size
			if (gameNum == 1) {
				System.out.println("Please input the game size:");
				size = scan.nextInt();
			}
			// if the user doesn't want a new game, finish the game and show statistics
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
			// start a new game is user says "y"
			board = new Board(size);
			startGame();
			gameNum++;
		}
		
	}
	
	// main function that initializes the game and plays it
	public static void main(String[] args) {
		Game g = new Game();
		g.init();
		g.run();
	}
}
