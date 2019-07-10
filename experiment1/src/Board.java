//
//public class board {
//
//	public void showBoard(char[][] map)	
//	{
//		System.out.println("-------------");
//		for(int i=0;i<3;i++)
//		{
//			System.out.print("|");
//			for(int j=0;j<3;j++)
//			{
////				if(map[i][j]!='\u0000')
////					System.out.print(" "+map[i][j]+" |");
////				else
////					System.out.print("   |");
//		
//					System.out.print(" "+map[i][j]+" |");
//			}
//			System.out.println();
//			System.out.println("-------------");
//		}
//	}
//}

import java.util.Scanner;


public class Board {
	public int length, width;
	public String board;
	public int acc = 1;
	
	public Board(int length) {
		this.length = length;
		this.width = length;
		this.makeBoard(length,length);
	}
	
	public String makeRoof(int length) {
		String roof = "+";
		String piece = "--+";
		for (int i = 0; i < this.length; i++) {
			roof += piece;
		}
		return roof;
	}
	
	public String makeBoard(int length, int width) {
		String tile = " |";
		String roof = makeRoof(length);
		board = roof + "\n";
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0) {
					board += "|" + Integer.toString(acc) + tile;
					acc++;
				}
				else {
				board += Integer.toString(acc) + tile;
				acc++;
				}
			}
			board+= "\n" + roof + "\n";
		}
		return(board);
	}
	
//	public String makeMove( Marker marker) {
//		System.out.println(board);
//		System.out.println("Player " + marker + ", please enter in your move: ");
//		Scanner scan = new Scanner(System.in);
//		// make sure input is int and is >0 and <acc OR just check if the int is in the board string
//		int choice = scan.nextInt();
//		board = board.replaceFirst(Integer.toString(choice), marker);
//		return board;
//	}

	
	
	
	public static void main(String[] args) {
//		Board ex = new Board(5);
//		System.out.println(ex.makeBoard(ex.length, ex.width));
//		ex.makeMove("X");
//		ex.makeMove("O");
//		System.out.println(ex.board);
////		
//		String a = ex.board;
//		System.out.println(a);
//		a = a.replace("2", "fu");
//		System.out.println(a);
//		
		
//		String text = "test";
//		text = text.replace("es", "x");
//		System.out.println(text);
	}

}

