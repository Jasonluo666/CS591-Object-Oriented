
import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;
    private int numAces = 0;

    public Hand(){
        hand = new ArrayList<Card>();
    }

    public void addCard(Card c){
        if(c.getName() == Value.Ace){
            numAces++;
        }
        hand.add(c);
    }
    
    public void removeCard(int x){
    	if(hand.get(x).getName() == Value.Ace) {
    		numAces--;
    	}
        hand.remove(x);
    }

    public int handValue(){
        int res = 0;
        int temp = numAces;
        for(Card c : hand){
            res += c.getValue();
        }

        //If there are aces in the hand and we bust, set an ace value to 1 and decrement numAces
        while((res > 21) && (temp > 0)){
            temp--;
            res -= 10;
        }
        return res;
    }

    public int handSize(){
        return hand.size();
    }
    
    public void clear() {
    	hand.clear();
    }
    
    public Card getCard(int x) {
    	return hand.get(x);
    }

    public String toString(){
        String res = "";
        for(Card c : hand){
            res += c + ", ";
        }
        return res;
    }
    
    
}

