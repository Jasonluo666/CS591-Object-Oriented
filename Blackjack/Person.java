import java.util.ArrayList;

abstract class Person {
    protected ArrayList<Hand> hands;

    Person(){
        hands = new ArrayList<Hand>();
        hands.add(new Hand());
    }
    
    public ArrayList<Hand> getHands(){
    	return hands;
    }
    
    public int getHandsNum() {
    	return hands.size();
    }
    
    // clear the hands -> leave an empty hand
    public void clear() {
    	hands.clear();
		hands.add(new Hand());
    }
    
    public void hit(Deck d, int x){
        hands.get(x).addCard(d.draw());
    }

    public int stand(int x){
        return hands.get(x).handValue();
    }
    
    public abstract String toString(int x);
}
