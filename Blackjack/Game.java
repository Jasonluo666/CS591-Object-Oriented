import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Deck deck;
	private Player player;
	private Dealer dealer;
	
	
	private int current_bet = 0;
	
	static final Scanner scan = new Scanner(System.in);
	
	private boolean ifNatural;
	
	public Game() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		ifNatural = false;
		current_bet = 0;
		
		player.setMoney(100);
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	// reset game
	public void init() {
		deck.initializeDeck();
		deck.shuffle();
		
		player.clear();
		dealer.clear();
		
		// deal two cards
		for(int i = 0; i < 2; i++) {
			player.hit(deck, 0);
			dealer.hit(deck, 0);
		}
//		
//		Card c = new Card(Value.Ace,Suit.Club);
//		Card d = new Card(Value.Jack,Suit.Spade);
//
//		player.getHands().get(0).addCard(c);
//		player.getHands().get(0).addCard(d);
	}
	
	// check if player is bankrupted
	public boolean isBankrupted() {
		if(player.getMoney() <= 0) {
			System.out.println("Bankrupted...");
			return true;
		}
		return false;
	}
	
	// new game
	public void startGame(int bet) {
		current_bet = bet;
		init();
		// directly win the game
		if(isNaturalBlackjack()) {
			ifNatural = true;
			System.out.println("The dealer has " +dealer.toString(0));
			System.out.println("Now you have " + player.toString(0));
		}
		else {
			String ans;
			
			// scan thru player's hands (considering the case: player keeps "splitting")
			for(int hand_id = 0; hand_id < player.getHandsNum(); hand_id++) {
				System.out.println("The dealer has " +dealer.showInitCards());
				System.out.println("Now you have " + player.toString(hand_id));

				//b keeps track of if the player was given the option to double up
				boolean b = false, isDoubled = false;
				
				while(player.stand(hand_id) < 21 && !isDoubled) {
				
					if(b == false) {
					System.out.println("What do you want to do next?");
					System.out.print("Please select a number: 1.Hit 2.Stand 3.Double Up");
					
					if(player.checkIfSameCard(hand_id)) {
						System.out.print(" 4.Split\n");
						ans = scan.nextLine();
						
						if(ans.equals("2")) {
							break;
						}
						
						switch(ans) {
							case "1" :
								player.hit(deck, hand_id);
								
								System.out.println("The dealer has " +dealer.showInitCards());
								System.out.println("Now you have " + player.toString(hand_id));
								
								b = true;
								break;
							case "4" :
								player.split(deck, hand_id);
								
								System.out.println("The dealer has " +dealer.showInitCards());
								System.out.println("Now you have " + player.toString(hand_id));
								
								continue;
							case "3" :
								player.doubleUp(deck, hand_id);
								
								System.out.println("The dealer has " +dealer.showInitCards());
								System.out.println("Now you have " + player.toString(hand_id));
								
								current_bet = current_bet * 2;
								isDoubled = true;
								b = true;
								break;
						}
					}else {
						System.out.print("\n");
						ans = scan.nextLine();
						
						if(ans.equals("2")) {
							break;
						}
						
						switch(ans) {
							case "1" :
								player.hit(deck, hand_id);
								
								System.out.println("The dealer has " +dealer.showInitCards());
								System.out.println("Now you have " + player.toString(hand_id));
								
								b = true;
								break;
							case "3" :
								player.doubleUp(deck, hand_id);
								
								System.out.println("The dealer has " +dealer.showInitCards());
								System.out.println("Now you have " + player.toString(hand_id));
								
								current_bet = current_bet * 2;
								isDoubled = true;
								b = true;
								break;
						}
					}
				}else {
					System.out.println("What do you want to do next?");
					System.out.println("Please select a number: 1.Hit 2.Stand ");

					ans = scan.nextLine();

					if(ans.equals("2")) {
						break;
					}else
						player.hit(deck, hand_id);

						System.out.println("The dealer has " +dealer.showInitCards());
						System.out.println("Now you have " + player.toString(hand_id));
				}
			}
				
				System.out.println("Ending hand " + (hand_id + 1) + "----------------------------");
		}
	}
		// dealer keeps hitting till >= 17
		if(!player.isBusted()) {
			while (dealer.continueHit()) {
				dealer.hit(deck, 0);
				System.out.println("The dealer has " +dealer.toString(0));
			}
		}
		else{
			System.out.println("All hands busted!");
		}
			
	}
	
	// check wins, update game info
	public void end() {
		System.out.println("Calculating------------------------------------------------");
		
		for(int hand_id = 0; hand_id < player.getHandsNum(); hand_id++) {
			int player_score = player.getHands().get(hand_id).handValue();
			int dealer_score = dealer.getHands().get(0).handValue();
			
			System.out.println("The dealer has " +dealer.toString(0));
			System.out.println("Now you have " + player.toString(hand_id));
			
			if(ifNatural == true) {
				System.out.println("Hand " + (hand_id + 1) + ": You win!" );
				update(2*current_bet);
			}
			else if((player_score > dealer_score && player_score <= 21) || dealer_score > 21) {
				System.out.println("Hand " + (hand_id + 1) + ": You win!");
				update(current_bet);
			}
			else if(player_score == dealer_score){
				System.out.println("Hand " + (hand_id + 1) + ": Draw!");
				update(0);
			}else {
				System.out.println("Hand " + (hand_id + 1) + ": You Lose!");
				update(-current_bet);
			}
		}
		
		// print out player/dealer's info
		showMoney();
	}

	private void showMoney(){
		if(player.getMoney() < 0){
			System.out.println("You are " + -player.getMoney() + " dollars in debt");
		}
		else if(player.getMoney() == 0){
			System.out.println("You have 0 dollars");
		}
		else{
			System.out.println("You still have " + player.getMoney() + " dollars");
		}
	}
	
	private void update(int x) {
		player.incMoney(x);
	}
	
	private boolean isNaturalBlackjack() {
		return (player.getHands().get(0).handValue() == 21);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Black Jack!");
		Game game = new Game();
		String ans;
		int bet;
		
		while(!game.isBankrupted()) {
			System.out.println("You have " +game.getPlayer().getMoney() +" dollars");
			System.out.println("How much do you want to bet? (press n to quit)");
			ans = scan.nextLine();
			
			if(ans.contentEquals("n"))
				break;
			else {
				try {
					 bet = Integer.valueOf(ans);
				}
				catch(Exception e) {
					System.out.println("Invalid input, try again");
					continue;
				}
				
				if(bet > game.getPlayer().getMoney()) {
					System.out.println("You don't have enough money!");
					continue;
				}
				game.startGame(bet);
			}
			
			game.end();
		}
		
		System.out.println("See you later.");
	}
}
