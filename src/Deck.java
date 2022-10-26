import java.util.ArrayList;

public class Deck {
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
        int index1, index2;
        for (int i = 0; i < 50; i++){
            index1 = (int) Math.floor(Math.random()*(deck.size()));
            index2 = (int) Math.floor(Math.random()*(deck.size()));
            swap(deck, index1, index2);
        }
    }

    void cut(){
        int index = (int) Math.floor(Math.random()*(deck.size()-1)+2);
        ArrayList<Card> temp = new ArrayList<>();
        for (int i = index; i < deck.size(); i++){
            temp.add(deck.get(i));
        }
        for (int i = 0; i < index; i++){
            temp.add(deck.get(i));
        }
        deck.clear();
        for(int i = 0; i < temp.size(); i++){
            deck.add(temp.get(i));
        }
    }

    Card dealCard(){
        return deck.remove(0);
    }

    void print(){
        if (deck.size() == 1) {System.out.println("1 card");}
        else {System.out.println(deck.size() + " cards");}
        for (int i = 0; i < deck.size(); i++){
            System.out.println(deck.get(i).toString());
        }
    }

    private static void swap(ArrayList<Card> deck, int index1, int index2) {
        Card temp = deck.get(index1);
        deck.set(index1, deck.get(index2));
        deck.set(index2, temp);
    }
}


