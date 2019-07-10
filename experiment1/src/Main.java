import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		boolean another = true;
		
		// new game object
		Game new_game = new Game();
		
		System.out.print("Welcome to Tic Tac Toe\n");
		while(another) {
			new_game.game();	// new game
			
			System.out.print("Do you want to play another game? y/n: ");
			String ans = scanner.nextLine();
			another = (ans.charAt(0) == 'y')? true:false;
		}
		
		new_game.printHistory();
	}

}
