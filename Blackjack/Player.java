public class Player extends Person {

    private int money;

    public Player(){
        super();
    }
    
    public boolean checkIfSameCard(int x) {
    	if(hands.get(x).getCard(0).getValue() == hands.get(x).getCard(1).getValue()) {
    		return true;
    	}
    	else
    		return false;
    }

    public void split(Deck d, int x){
    		Hand hand = new Hand();
    		hand.addCard(hands.get(x).getCard(1));
    		
    		hands.add(hand);
    		
    		hands.get(x).removeCard(1);
    		
    		super.hit(d, x);
    		super.hit(d, hands.size()-1);
    }

    public void doubleUp(Deck d, int x){
    	super.hit(d,x);
    	super.stand(x);
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int x) {
        money = x;
    }

    public void incMoney(int x){
        money += x;
    }

    public boolean isBusted(){
        for(int i = 0; i < hands.size(); i++){
            if(stand(i) <= 21){
                return false;
            }
        }
        return true;
    }

	public String toString(int x) {
		return "You have card " + hands.get(x).toString();
	}

}

