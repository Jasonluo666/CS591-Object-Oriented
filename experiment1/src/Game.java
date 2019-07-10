import java.util.Scanner;

//import java.util.Scanner;
//
//public class Game {
//	int[][] board = new int[3][3];
//	int turn_no;
//	Scanner scan = new Scanner(System.in);
//	String winner;
//	int[] history = new int[2];
//	
//	public Game() {
//		init();
//		
//		history[0] = history[1] = 0;
//	}
//	
//	// cleanup the board
//	public void init() {
//		winner = "";
//		turn_no = 0;
//		
//		for(int row = 0; row < 3; row++)
//			for(int col = 0; col < 3; col++)
//				board[row][col] = 0;
//	}
//	
//	// single game
//	public void game() {
//		init();
//		printStatus();
//		
//		while(!isFinish()) {
//			System.out.print("Turn No " + Integer.toString(turn_no) + "\n");
//			try {
//				turn();
//			}
//			catch(Exception e) {
//				System.out.print("Invalid input. Try Again.");
//				continue;
//			}
//
//			printStatus();
//			turn_no++;
//		}
//		
//		if(winner.equals("None"))
//			System.out.print("Nobody wins.");
//		else {
//			System.out.print("Player " + winner + " wins.");
//			
//			if(winner.contentEquals("O"))
//				history[0]++;
//			else
//				history[1]++;
//		}
//	}
//	
//	// game result
//	void printHistory() {
//		System.out.print("Game Over. Cheers!\n");
//		System.out.print("Game History:\n");
//		System.out.print("Player O: " + Integer.toString(history[0]) + "\n");
//		System.out.print("Player X: " + Integer.toString(history[1]) + "\n");
//	}
//	
//	// check if anyone wins the game
//	public boolean isFinish() {
//		// diagonal
//		if(((board[0][0] == board[1][1] && board[1][1] == board[2][2]) 
//			|| (board[0][2] == board[1][1] && board[1][1] == board[2][0])) 
//				&& board[1][1] != 0)
//			winner = (board[1][1] == 1)? "O": "X";
//		// horizontal or vertical
//		else {
//			for(int x=0; x < 3; x++) {
//				if(board[x][0] == board[x][1] && board[x][1] == board[x][2] && board[x][0] != 0)
//					winner = (board[x][0] == 1)? "O": "X";
//				else if(board[0][x] == board[1][x] && board[1][x] == board[2][x] && board[0][x] != 0)
//					winner = (board[0][x] == 1)? "O": "X";
//			}
//		}
//		
//		if(turn_no == 9 && winner.contentEquals(""))
//			winner = "None";
//		
//		if(!winner.contentEquals(""))
//			return true;
//		return false;
//	}
//	
//	// each turn
//	public void turn() {
//		if(turn_no % 2 == 0)
//			System.out.print("Player O's Turn. Please enter your command:");
//		else
//			System.out.print("Player X's Turn. Please enter your command:");
//		
//		String[] line_of_int = scan.nextLine().split(",");
//		int row = Integer.parseInt(line_of_int[0]) - 1;
//		int col = Integer.parseInt(line_of_int[1]) - 1;
//		
//		if(row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == 0) {
//			board[row][col] = (turn_no % 2 == 0)? 1: 2;
//		}
//		else {
//			System.out.print("Invalid input. Try Again.");
//			turn();
//		}
//	}
//	
//	// board
//	public void printStatus() {
//		System.out.print("Current Status:\n" );
//		
//		for(int row = 0; row < 3; row++) {
//			System.out.print("+--+--+--+\n" );
//			
//			for(int col = 0; col < 3; col++) {
//				System.out.print("|");
//				
//				switch(board[row][col]){
//				case 0:
//					System.out.print("  ");
//					break;
//				case 1:
//					System.out.print("O ");
//					break;
//				case 2:
//					System.out.print("X ");
//					break;
//				}
//			}
//			
//			System.out.print("|\n");
//		}
//		
//
//		System.out.print("+--+--+--+\n" );
//	}
//}

public class Game{
	private Player playerOne;
	private Player playerTwo;
	private Board board;
	private int game_id;
	
	public void init() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please input Player 1's name: ");
		playerOne = new Player(scan.nextLine());
		
		System.out.print("Please input Player 2's name: ");
		playerTwo = new Player(scan.nextLine());
		
		System.out.print("Please input the game size:");
		board = new Board(scan.nextInt());
		
		game_id = 0;
	}
	
	public void startGame() {
		System.out.print("Game ID: " + game_id + ", start.\n");
		
		
	}
}