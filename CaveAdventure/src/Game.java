import java.util.Random;
import java.util.Scanner;

public class Game {
	private String player_name;
	protected Scanner scan;

	Game(){
		init();
	}
	
	public void init() {
		scan = new Scanner(System.in);
		
		System.out.println("Brave knight!!! What is your name?");
		player_name = scan.nextLine();
	}
	
	public void newGame() {
		System.out.println("We are in need of your help, " + player_name + "!");
		System.out.println("Our village is being overrun by the goblins of the NorthernCaves.");
		System.out.println("We need you to defeat them!");
		
		System.out.println("Will you accept the challenge (Y/N)?");
		while(scan.nextLine().contains("N")) {
			System.out.println("How dare you not accept the challenge! Will you accept the challenge (Y/N)?");
		}
		
		System.out.println("Thank You Thank You Oh brave knight, are you ready to enter the mouth of the caves (Y/N)?");
		while(scan.nextLine().contains("N")) {
			System.out.println("How dare you! Are you ready to enter the mouth of the caves (Y/N)?");
		}
		
		int count = 0;
		Mission[] missions = {new MissionOne(), new MissionTwo(), new MissionThree()};
		
		Random r = new Random();
		missions[r.nextInt() % missions.length].setSecondTreasure(true);
		
		for(Mission mission: missions) {
			System.out.println("------------------------------");
			mission.question();
			
			if(!mission.isPass()) {
				break;
			}
			count++;
		}
		
		if(count < missions.length) {
			System.out.println("Restart the game..------------------------------");
			newGame();
			return;
		}
		
		LastTask end = new LastTask();
		while(!end.isPass()) {
			end.askSpecialWord();
		}
		System.out.println("Generate the poem: " + end.generate());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game();
		
		game.newGame();
		
		System.out.println("Well played, cheers.");
	}

}
