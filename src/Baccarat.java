import java.util.Scanner;

public class Baccarat extends Game {
    private Hand playerHand;
    private Hand cpuHand;
    private Deck deck;

    Baccarat(){
        setup();
    }

    protected void setup(){
        deck = new Deck();
        playerHand = new Hand();
        cpuHand = new Hand();
        deck.shuffle();
        deck.cut();
        deck.shuffle();
    }

    public void playGame(){

    }

    protected void showDescription(){
        System.out.println("Welcome to Baccarat! In this game there are two hands, the player and the banker.");
        System.out.println("You will choose who you think will win and see what the outcome is.");
        System.out.println("There are many rules in terms of who draws cards, but the winner is the hand with the higher value.");
    }
    protected void deal(){
        for (int i = 0; i < 7; i++){
            playerHand.addToHand(deck.dealCard());
            cpuHand.addToHand(deck.dealCard());
        }
    }
}
