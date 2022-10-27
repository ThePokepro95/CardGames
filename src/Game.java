import java.util.ArrayList;

public abstract class Game {
    protected abstract void setup();
    abstract void playGame();
    abstract void showDescription();
    protected abstract void deal();
    static void printLine(){
        String line = "";
        for (int i = 0; i < 30; i++){
            line += "*";
        }
        System.out.println(line);
    }
}

class Hand {
    private ArrayList<Card> hand;

    Hand(){
        hand = new ArrayList<>();
    }

    void addToHand(Card c){
        hand.add(c);
    }

    void removeFromHand(int index){
        hand.remove(index);
    }

    Card getCard(int index){
        return hand.get(index);
    }

    int numberOfCards(){
        return hand.size();
    }

    @Override
    public String toString(){
        String handString = "";
        for (int i = 0; i < hand.size()-1; i++){
            handString += hand.get(i).toString() + ", ";
        }
        handString += hand.get(hand.size()-1).toString();
        return handString;
    }
}
