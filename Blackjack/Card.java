
public class Card {

    private Value value;

    private Suit suit;

    public Card(Value v, Suit s){
        setValue(v);
        setSuit(s);
    }

    public void setValue(Value x){
        value = x;
    }

    public void setSuit(Suit s){
        suit = s;
    }

    public int getValue(){
        return value.getVal();
    }

    public Value getName(){
        return value;
    }

    public char getSuit(){
        return suit.getSuit();
    }

    public String toString(){
        return value.getSymb() + getSuit();
    }

}

