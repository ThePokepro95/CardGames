import java.util.ArrayList;

public abstract class Deck {
    //Data Members
    private ArrayList<Card> deck;

    //Constructors
    Deck(){
        deck = new ArrayList<Card>();
        String suit = "";
        for (int i = 0; i < 4; i++){
            switch (i){
                case 0:
                    suit = "spades";
                    break;
                case 1:
                    suit = "clubs";
                    break;
                case 2:
                    suit = "hearts";
                    break;
                case 3:
                    suit = "diamonds";
                    break;
            }
            for (int j = 1; j < 14; j++){
                deck.add(new Card(j, suit));
            }
        }
    }

    //Methods
    void shuffle(){

    }

    void print(){
        if (deck.size() == 1) {System.out.println("1 card");}
        else {System.out.println(deck.size() + " cards");}
        for (int i = 0; i < deck.size(); i++){
            System.out.println(deck.get(i).toString());
        }
    }

    abstract Card dealCard();

}
