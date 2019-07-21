
public final class MissionOne extends Mission{
	public MissionOne() {
		// TODO Auto-generated constructor stub
		super();
		
		question1 = "Attack the evil goblin and clean all the cob webs";
		question2 = "Pick up the golden sword";
	}
	
	public void question() {
		int choice;
		
		while(true) {
			try {
				System.out.println("You are now entering the mouth of the cave, what would you like to do?");
				System.out.println("1. " + question1);
				System.out.println("2. " + question2);
				
				choice = scan.nextInt();
				if(choice == 1) {
					System.out.println("You slayed the evil goblin and are sill alive, what would you like to do?");
					System.out.println("1. " + move_on);
					System.out.println("2. " + question2);
					
					choice = scan.nextInt();
					if(choice == 1) {
						System.out.println("Uh, you did not pick up the treasure. Mission Failed.");
						break;
					}
					else {
						if(hasSecondTreasure()) {
							System.out.println("You have picked up the gold sword and are still alive, what would you like to do?");
							System.out.println("1. " + move_on);
							System.out.println("2. " + extra_question);
							
							choice = scan.nextInt();
							if(choice != 1) {
								System.out.println("They tricked you into picking up a second treasure, your penance is to sing the Twelve Days of Christmas.");
								tricked();
								
								System.out.println("Great! You have done your penance, what would you like to do?");
								System.out.println("1. " + move_on);
								choice = scan.nextInt();
							}
						}
						else
							System.out.println("You have picked up the gold sword and are still alive, you can move on to your next Adventure!");
					}
				}
				else {
					System.out.println("You have picked up the treasure, now go rest before continuing the mission.");
					snooze();

					System.out.println("Great! You are awake and rested what would you like to do?");
					System.out.println("1. " + question1);
					if(hasSecondTreasure()) {
						System.out.println("2. " + extra_question);
						
						choice = scan.nextInt();
						if(choice == 1) {
							System.out.println("You slayed the evil goblin and are sill alive, what would you like to do?");
							System.out.println("1. " + move_on);
							System.out.println("2. " + extra_question);
							
							choice = scan.nextInt();
							if(choice != 1) {
								System.out.println("They tricked you into picking up a second treasure, your penance is to sing the Twelve Days of Christmas.");
								tricked();
								
								System.out.println("Great! You have done your penance, what would you like to do?");
								System.out.println("1. " + move_on);
								choice = scan.nextInt();
							}
						}
						else {
							System.out.println("They tricked you into picking up a second treasure, your penance is to sing the Twelve Days of Christmas.");
							tricked();
							
							System.out.println("Great! You have done your penance, what would you like to do?");
							System.out.println("1. " + question1);
							choice = scan.nextInt();
							
							System.out.println("You slayed the evil goblin and are sill alive, what would you like to do?");
							System.out.println("1. " + move_on);
							choice = scan.nextInt();
						}
					}
					else {
						choice = scan.nextInt();
						System.out.println("You slayed the evil goblin and are sill alive, what would you like to do?");
						System.out.println("1. " + move_on);
						choice = scan.nextInt();
					}
				}
				
			}
			catch(Exception e) {
				System.out.println("Oops. Invalid input. You misguided yourself to the starting point of this mission.");
				continue;
			}
			
			setPass(true);
			break;
		}
		
	}
}
