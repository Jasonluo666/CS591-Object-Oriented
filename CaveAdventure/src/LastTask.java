import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LastTask {
	private boolean pass;
	private ArrayList<String> words;
	private String terminate_word;

	protected Scanner scan;
	
	LastTask(){
		scan = new Scanner(System.in);
		
		pass = false;
		words = new ArrayList<String>();
		terminate_word = "BostonUniversity";
	}
	
	public boolean isPass() {
		return pass;
	}
	
	public void askSpecialWord() {
		System.out.println("You have picked up the golden helmet and are ready to move on to your final mission.");
		
		System.out.println("Are you ready for the final mission (Y/N)?");
		while(scan.nextLine().contains("N")) {
			System.out.println("How dare you procrastinate like that! Are you ready for the final mission (Y/N)?");
		}
		
		String new_word = "";
		while(!new_word.equals(terminate_word)) {
			System.out.println("Village Idiot #" + (words.size() + 1) + ", what is your special word? (Hint: end word -> BostonUniversity)");
			new_word = scan.nextLine();
			words.add(new_word);
		}
		
		pass = true;
	}
	
	public String generate() {
		Random r = new Random();
		int rand_length = Math.abs(r.nextInt()) % words.size();
		
		Collections.shuffle(words);
		
		String generate_sentence = "";
		for(String word: words.subList(0, rand_length)) {
			generate_sentence += word + " ";
		}
		
		return generate_sentence;
	}
}
