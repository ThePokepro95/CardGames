import java.util.Scanner;

public class Baccarat extends Game {
    private Hand playerHand;
    private Hand bankerHand;
    private Deck deck;

    Baccarat(){
        setup();
    }

    protected void setup(){
        deck = new Deck();
        playerHand = new Hand();
        bankerHand = new Hand();
        deck.shuffle();
        deck.cut();
        deck.shuffle();
    }

    public void playGame(){

        Scanner userInput = new Scanner(System.in);

        deal();
        showDescription();

        boolean validInput = false;
        String prediction = "";
        while (!validInput){
            System.out.println("Who do you think will win, the banker or the player or will there be a tie? Please type it in now.");
            prediction = userInput.next();
            prediction.toLowerCase();


            if (prediction.equals("player") || prediction.equals("banker") || prediction.equals("tie")){
                validInput = true;
            }  else {
                System.out.println("Please type in player, banker, or tie.");
            }
        }

        printLine();
        printSpace();
        if ((getHandValue(playerHand) == 8) || (getHandValue(playerHand) == 9) || (getHandValue(bankerHand) == 8) || (getHandValue(bankerHand) == 9)){
        } else if ((getHandValue(playerHand) == 6) || (getHandValue(playerHand) == 7)) {
            if (getHandValue(bankerHand) < 5){
                bankerHand.addToHand(deck.dealCard());
            }
        } else {
            playerHand.addToHand(deck.dealCard());
            int pThirdCardVal = playerHand.getCard(2).getValue();

            if (getHandValue(bankerHand) < 3){
                bankerHand.addToHand(deck.dealCard());
            } else {
                switch (getHandValue(bankerHand)){
                    case 3:
                        if (pThirdCardVal != 8){
                            bankerHand.addToHand(deck.dealCard());
                        }
                        break;
                    case 4:
                        if (pThirdCardVal > 1 && pThirdCardVal < 8){
                            bankerHand.addToHand(deck.dealCard());
                        }
                        break;
                    case 5:
                        if (pThirdCardVal > 3 && pThirdCardVal < 8){
                            bankerHand.addToHand(deck.dealCard());
                        }
                        break;
                    case 6:
                        if (pThirdCardVal == 6 || pThirdCardVal == 7){
                            bankerHand.addToHand(deck.dealCard());
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        printLine();
        System.out.println("Banker: " + bankerHand + " | Value: " + getHandValue(bankerHand));
        System.out.println("\n\n\n\n\n");
        System.out.println("Player: " + playerHand + " | Value: " + getHandValue(playerHand));
        checkWinner(prediction);
    }

    protected void showDescription(){
        System.out.println("Welcome to Baccarat! In this game there are two hands, the player and the banker.");
        System.out.println("You will choose who you think will win and see what the outcome is.");
        System.out.println("There are many rules in terms of who draws cards and when, but the winner is the hand with the higher value.");
    }

    protected void deal(){
        bankerHand.addToHand(deck.dealCard());
        playerHand.addToHand(deck.dealCard());
        bankerHand.addToHand(deck.dealCard());
        playerHand.addToHand(deck.dealCard());
    }

    protected int getHandValue(Hand h){
        int total = 0;
        for (int i = 0; i < h.numberOfCards(); i++){
            if (h.getCard(i).getValue() > 9){
                total += 0;
            } else {
                total += h.getCard(i).getValue();
            }
        }
        total = total % 10;
        return total;
    }

    protected void checkWinner(String prediction){
        String winner;
        if (getHandValue(playerHand) > getHandValue(bankerHand)){
            winner = "player";
        } else if (getHandValue(playerHand) < getHandValue(bankerHand)){
            winner = "banker";
        } else {
            winner = "tie";
        }

        if (winner.equals(prediction)){
            if (winner.equals("tie")){
                System.out.println("You were correct! It was a tie! See you next time!");
            } else {
                System.out.println("You were correct! The " + winner + " won! See you next time!");
            }
        } else {
            if (winner.equals("tie")){
                System.out.println("You guessed wrong. It was a tie. Better luck next time!");
            } else {
                System.out.println("You guessed wrong. The " + winner + " won. Better luck next time!");
            }
        }
    }
}
