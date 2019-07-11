import java.util.Scanner;
import java.util.Arrays;


public class Board {
	public int length, width;
	public String board;
	public Tile[][] aboard = new Tile[length][length];
	public int acc = 1;
	
	public Board(int length) {
		int acc2 = this.acc;
		this.length = length;
		this.width = length;
		Tile[][] bboard = new Tile[this.length][this.length];
		
		for (int i = 0; i < length; i++) {
			Tile[] row = new Tile[length];
			for (int j = 0; j < length; j++) {
				row[j] = new Tile(i,j, new Marker(' '));
				//row[j].setID(0);
				row[j].setID(acc2);
				acc2++;
			}
			bboard[i] = row;
		}
		aboard = bboard;
	}
	

	
	public String makeRoof(int length) {
		String roof = "+";
		String piece = "---+";
		for (int i = 0; i < this.length; i++) {
			roof += piece;
		}
		return roof;
	}

	
	public String toString() {
	String barrier = " |";
	String roof = makeRoof(length);
	board = roof + "\n";
	for (int i = 0; i < length; i++) {
		for (int j = 0; j < width; j++) {
			if (aboard[i][j].getMarker().getSym() == ' ') {
				if (j == 0) {
					if (acc < 10) {
						board += "|" + aboard[i][j].getID() + " " + barrier;
					}
					else {
					board += "|" + aboard[i][j].getID() + " " + barrier;
					}
					acc++;
				}
				else {
					if (acc < 10) {
						board += aboard[i][j].getID() + " " + barrier;
					}
					else {
					board += aboard[i][j].getID() + " " + barrier;
					}
					acc++;
				}
			}
			else {
				if (j == 0) {
					board += "|" + aboard[i][j].getMarker().toString() + " " + barrier;
					acc++;
				}
				else {
					board += aboard[i][j].getMarker().toString() + " " + barrier;
					acc++;
				}
			}
		}
		board+= "\n" + roof + "\n";
		}
		return(board);
	}
	
	public boolean contains(int id, Marker marker) {
		// if the id is in range, proceed
		if (id >0 && id <=(length*length)) {
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					
					// if found the cell
					if (id == aboard[i][j].getID()) {
						// if the cell isn't empty, user selects again
						if (aboard[i][j].getMarker().getSym() != ' ') {
							System.out.println("Cell occupied. Please select again.");
							Scanner scan = new Scanner(System.in);
							int newID = scan.nextInt();
							return contains(newID, marker);
						}
						aboard[i][j].setMrk(marker);
						return true;
					}
				}
			}
		}
		else {
			System.out.println("Cell number out of range. Please select again.");
			Scanner scan = new Scanner(System.in);
			int newID = scan.nextInt();
			return contains(newID, marker);
		}
		
		return false;
	}	
	
	public Marker checkWin() {
		
		for(int i=0;i<aboard.length;i++)//row check
			{
				int count = 0;
				for(int j=0;j<aboard[i].length;j++)
				{
					count += aboard[i][j].getMarker().getVal();
				}
				if(count == aboard.length * 3 || count == -aboard.length * 3)
				{
					return aboard[i][0].getMarker();
				}
			}
			
			for(int i=0;i<aboard.length;i++)//column check
			{
				int count = 0;
				for(int j=0;j<aboard[i].length;j++)
				{
					count += aboard[j][i].getMarker().getVal();
				}
				if(count == aboard.length * 3 || count == -aboard.length * 3)
				{
					return aboard[0][i].getMarker();
				}
			}
			
			int diagonal_count = 0, anti_diagonal_count = 0;
			for(int i=0;i<aboard.length;i++)//diagonal check
			{
				diagonal_count += aboard[i][i].getMarker().getVal();
				anti_diagonal_count += aboard[i][aboard.length - i - 1].getMarker().getVal();
				
			}
			if(diagonal_count == aboard.length * 3 || diagonal_count == -aboard.length * 3)
			{
				return aboard[0][0].getMarker();
			}
			else if(anti_diagonal_count == aboard.length * 3 || anti_diagonal_count == -aboard.length * 3)
			{
				return aboard[0][aboard.length - 1].getMarker();
			}
			return null;
		}

}

