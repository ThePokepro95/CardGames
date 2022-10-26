public class Card {
    //Data Members
    private int value;
    private String suit;

    //Constructors
    Card (){
        value = 1;
        suit = "spades";
    }

    Card (int val, String s){
        value = val;
        suit = s;
    }

    //Getters and Setters
    int getValue(){
        return value;
    }

    String getSuit(){
        return suit;
    }

    @Override
    public String toString(){
        switch (value){
            case 1:
                return "Ace of " + suit;
            case 11:
                return "Jack of " + suit;
            case 12:
                return "Queen of " + suit;
            case 13:
                return "King of " + suit;
            default:
                return value + " of " + suit;
        }

    }

    public boolean equals(Card other){
        if (this.value == other.value && this.suit.equals(other.suit)) return true;
        return false;
    }
}
