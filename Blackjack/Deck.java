import java.util.Random;

public class Deck {

    Card[] deck;

    private int index = 0;

    public Deck(){
        deck = new Card[Value.values().length*Suit.values().length];
        initializeDeck();
    }

    public void initializeDeck(){
        int x = 0;
        for(Suit s : Suit.values()){
            for(Value v : Value.values()){
                deck[x++] = new Card(v, s);
            }
        }
    }

    public Card draw(){
        if(index >= deck.length){
            System.out.println("Deck empty, shuffle to reset.");
            return null;
        }
        else{
            return deck[index++];
        }
    }

    public void shuffle(){
        Random rand = new Random();
        int pos;

        for(int i = 0; i < deck.length; i++){
            pos = rand.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[pos];
            deck[pos] = temp;
        }
    }
}
