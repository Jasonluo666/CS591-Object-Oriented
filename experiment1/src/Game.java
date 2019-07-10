

//
//import java.util.Scanner;
//
//class game
//{
//	public void play(move m, board b, player p1, player p2){
//		int step=0;
//		int cor;
//		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Welcome to the game Tic Tac Toe!");
//		
//		b.showBoard(m.getmoves());
//		
//		while(isWin(m.getmoves(),p1,p2)==false && step<9)
//		{
//			if(step%2==0)  //zero and even number means the player O's turn
//			{
//				System.out.print("Player O Enter your move:");
//				cor = scan.nextInt();
//				
//				m.nextMove(cor, 'O');
//				b.showBoard(m.getmoves());
//			}else  //odd number means the player O's turn
//			{
//				System.out.print("Player X Enter your move:");
//				cor = scan.nextInt();
//
//				m.nextMove(cor, 'X');
//				b.showBoard(m.getmoves());
//			}
//			step++;
//		}
//		if(step==9)  //draw
//			System.out.println("The game ended in a draw");	
//	}
//	
//	public boolean isWin(char[][] chess,player p1,player p2)
//	{
//		for(int i=0;i<3;i++)   // check row
//		{
//			boolean row=true;
//			if(chess[i][0]=='\u0000')
//				continue;
//			for(int j=1;j<3;j++)
//			{
//				if(chess[i][j]!=chess[i][0]||chess[i][j]=='\u0000')
//				{
//					row=false;
//					break;
//				}
//			}
//			if(row)
//			{
//				System.out.println("Player " + chess[i][0]+" won!");
//				
//				if(chess[i][0] == 'X')
//					p1.setWins();
//				else if(chess[i][0] == 'O')
//					p2.setWins();
//				
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public void next(player p1, player p2) {
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Do you want to play another game? y/n");
//		
//		String ch = scan.next();
//		
//		if(ch.equals("y")) {
//			board board = new board();
//			move move = new move();
//			game game = new game();
//			
//			game.play(move,board,p1,p2);
//			game.next(p1,p2);
//		}
//		else {
//			System.out.println("Game Summary:");
//			System.out.println("Player X wins "+ p1.getWins() +" times");
//			System.out.println("Player O wins "+ p2.getWins() +" times");
//			System.out.println("Bye");
//			System.exit(1);
//		}
//	}
//	
//	public static void main(String[] args)
//	{
//		board board = new board();
//		move move = new move();
//		game game = new game();
//		player p1 = new player();
//		player p2 = new player();
//		
//		game.play(move,board,p1,p2);
//		
//		game.next(p1,p2);
//	}
//}
import java.util.Scanner;

public class Game{
	private Player playerOne;
	private Player playerTwo;
	private Board board;
	
	public void init() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please input Player 1's name: ");
		
		
		String name = scan.nextLine();
		
		System.out.print("Please input Player 1's symbol: ");
		String sym = scan.nextLine();
		
		playerOne = new Player(name,sym.charAt(0));
		
		System.out.print("Please input Player 2's name: ");
		name = scan.nextLine();
		
		System.out.print("Please input Player 2's symbol: ");
		sym = scan.nextLine();
		playerTwo = new Player(name,sym.charAt(0));
		
		System.out.print("Please input the game size:");
		board = new Board(scan.nextInt());
		
	}
	
	public void startGame() {
		System.out.print("Game start.\n");
		
		while(true) {
		
		System.out.print(board.board);
		
		playerOne.makeMove(board);
		
		System.out.print(board.board);
		
		playerTwo.makeMove(board);
		}
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.init();
		g.startGame();
	}
}
