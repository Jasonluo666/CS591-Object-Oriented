import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// base class for all three missions
public abstract class Mission {
	private boolean pass;
	private boolean second_treasure;

	protected String question1, question2, extra_question, move_on;
	protected Scanner scan;
	
	// define data members gthat shared by three missions
	public Mission(){
		pass = false;
		second_treasure = false;
		extra_question = "Pick up the silver tray of life";
		move_on = "Move on to the next adventure";
		
		scan = new Scanner(System.in);
	}
	
	// print lyrics with animals in random order
	protected void snooze() {
		System.out.println("You have picked up the treasure, now go rest before continuing the mission.\n");
		
		String[] animals = new String[] {"cows", "sheep", "pigs", "chickens"};
		ArrayList<String> part_of_lyrics = new ArrayList<String>();
		
		part_of_lyrics.add("Old MACDONALD had a farm\r\n" + 
				"E-I-E-I-O\r\n" + 
				"And on his farm he had a cow\r\n" + 
				"E-I-E-I-O\r\n" + 
				"With a moo moo here\r\n" + 
				"And a moo moo there\r\n" + 
				"Here a moo, there a moo\r\n" + 
				"Everywhere a moo moo\r\n" + 
				"Old MacDonald had a farm\r\n" + 
				"E-I-E-I-O");
		
		part_of_lyrics.add("Old MACDONALD had a farm\r\n" + 
				"E-I-E-I-O\r\n" + 
				"And on his farm he had a pig\r\n" + 
				"E-I-E-I-O\r\n" + 
				"With a oink oink here\r\n" + 
				"And a oink oink there\r\n" + 
				"Here a oink, there a oink\r\n" + 
				"Everywhere a oink oink\r\n" + 
				"Old MacDonald had a farm\r\n" + 
				"E-I-E-I-O");
		
		part_of_lyrics.add("Old MACDONALD had a farm\r\n" + 
				"E-I-E-I-O\r\n" + 
				"And on his farm he had a lamb\r\n" + 
				"E-I-E-I-O\r\n" + 
				"With a baa baa here\r\n" + 
				"And a baa baa there\r\n" + 
				"Here a baa, there a baa\r\n" + 
				"Everywhere a baa baa\r\n" + 
				"Old MacDonald had a farm\r\n" + 
				"E-I-E-I-O");
		
		part_of_lyrics.add("Old MACDONALD had a farm\r\n" + 
				"E-I-E-I-O\r\n" + 
				"And on his farm he had some chickens\r\n" + 
				"E-I-E-I-O\r\n" + 
				"With a cluck cluck here\r\n" + 
				"And a cluck cluck there\r\n" + 
				"Here a cluck, there a cluck\r\n" + 
				"Everywhere a cluck cluck");
		
		// shuffle the animal order
		Collections.shuffle(part_of_lyrics);
		System.out.println(part_of_lyrics); 
	}
	
	// print the lyrics
	protected void tricked() {
		System.out.println("On the first day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"A partridge in a pear tree\r\n" + 
				"On the second day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the third day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the fourth day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the fifth day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Five gold rings\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the sixth day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Six geese a laying\r\n" + 
				"Five gold rings\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the seventh day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Seven swans a swimming\r\n" + 
				"Six geese a laying\r\n" + 
				"Five gold rings\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the eighth day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Eight maids a milking\r\n" + 
				"Seven swans a swimming\r\n" + 
				"Six geese a laying\r\n" + 
				"Five gold rings\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the ninth day of Christmas\r\n" + 
				"Me me me me me me\r\n" + 
				"Nine ladies dancing\r\n" + 
				"Eight maids a milking\r\n" + 
				"Seven swans a swimming\r\n" + 
				"Six geese a laying\r\n" + 
				"Five gold rings, badam-pam-pam\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the tenth day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Ten lords a leaping\r\n" + 
				"Nine ladies dancing\r\n" + 
				"Eight maids a milking\r\n" + 
				"Seven swans a swimming\r\n" + 
				"Six geese a laying\r\n" + 
				"Five gold rings, badam-pam-pam\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the eleventh day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"Eleven pipers piping\r\n" + 
				"Ten lords a leaping\r\n" + 
				"Nine ladies dancing\r\n" + 
				"Eight maids a milking\r\n" + 
				"Seven swans a swimming\r\n" + 
				"Six geese a laying\r\n" + 
				"Five gold rings, badam-pam-pam\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree\r\n" + 
				"On the twelfth day of Christmas\r\n" + 
				"My true love gave to me\r\n" + 
				"12 drummers drumming\r\n" + 
				"Eleven pipers piping\r\n" + 
				"Ten lords a leaping\r\n" + 
				"Nine ladies dancing\r\n" + 
				"Eight maids a milking\r\n" + 
				"Seven swans a swimming\r\n" + 
				"Six geese a laying\r\n" + 
				"Five gold rings, badam-pam-pam\r\n" + 
				"Four calling birds\r\n" + 
				"Three French hens\r\n" + 
				"Two turtle doves\r\n" + 
				"And a partridge in a pear tree");
	}
	
	// setter/getter for the second treasure
	protected boolean hasSecondTreasure() {
		return second_treasure;
	}
	
	public void setSecondTreasure(boolean x) {
		second_treasure = x;
	}
	
	// setter/getter for pass variable
	protected void setPass(boolean x) {
		pass = x;
	}
	
	public boolean isPass() {
		return pass;
	}
	
	// this is the method that's overridden by the subclasses
	abstract public void question();
}
