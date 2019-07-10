
import java.util.Scanner;


public class Board {
	public int length, width;
	public String board;
	public int acc = 1;
	
	public Board(int length, int width) {
		this.length = length;
		this.width = width;
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
	
	public String makeMove(/*change to class Marker*/ String marker) {
		System.out.println(board);
		System.out.println("Player " + marker + ", please enter in your move: ");
		Scanner scan = new Scanner(System.in);
		// make sure input is int and is >0 and <acc OR just check if the int is in the board string
		int choice = scan.nextInt();
		board = board.replaceFirst(Integer.toString(choice), marker);
		return board;
	}

	
	
	
	public static void main(String[] args) {
		Board ex = new Board(3,3);
		System.out.println(ex.makeBoard(ex.length, ex.width));
		ex.makeMove("X");
		ex.makeMove("O");
		System.out.println(ex.board);
//		
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
