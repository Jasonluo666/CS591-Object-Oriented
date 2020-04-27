
public enum Suit {
	 	Heart('♥'),
	    Spade('♠'),
	    Club('♣'),
	    Diamond('♦');
	
    private char prettySuit;

    Suit(char c){
        prettySuit = c;
    }

    public char getSuit(){
        return prettySuit;
    }
}

