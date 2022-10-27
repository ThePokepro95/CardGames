import java.util.Scanner;

public class Blackjack extends Game {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    Blackjack() {
        setup();
    }

    protected void setup() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        deck.shuffle();
        deck.cut();
        deck.shuffle();


    }

    public void playGame() {
        boolean playing = true;

        String hitOrStay = "";
        Scanner userInput = new Scanner(System.in);

        deal();
        showDescription();

        printLine();
        System.out.println(dealerHand + " Total: " + getHandValue(dealerHand));
        System.out.println("\n\n\n\n\n");
        System.out.println(playerHand + " Total: " + getHandValue(playerHand));

        boolean hitting = true;
        boolean busted = false;
        while (hitting) {
            if (getHandValue(dealerHand) == 21) {
                System.out.println("You Lose! Dealer has blackjack. Good luck next time!");
                hitting = false;
                break;
            }
            System.out.println("Would you like to hit or stay? Type hit or stay then press enter.");
            hitOrStay = userInput.next();
            hitOrStay.toLowerCase();
            if (hitOrStay.equals("hit")) {
                playerHand.addToHand(deck.dealCard());
                if (getHandValue(playerHand) > 21) {
                    System.out.println(playerHand + " Total: " + getHandValue(playerHand));
                    busted = true;
                    hitting = false;
                    break;
                }
                System.out.println(playerHand + " Total: " + getHandValue(playerHand));
            } else if (hitOrStay.equals("stay")) {
                hitting = false;
                break;
            } else {
                System.out.println("Please type in a proper input.");
            }
        }

        if (busted) {
            System.out.println("You busted! Good luck next time!");
        } else {
            dealerSequence();
        }


    }

    protected void deal() {
        dealerHand.addToHand(deck.dealCard());
        playerHand.addToHand(deck.dealCard());
        dealerHand.addToHand(deck.dealCard());
        playerHand.addToHand(deck.dealCard());
    }

    protected void showDescription() {
        System.out.println("Welcome to Blackjack! Your goal is to beat the dealer by getting as close to 21 without going over.");
        System.out.println("Hit to take a card and stay when you don't want to get any more. If you go over 21, you bust.");
        System.out.println("The dealer will draw until they reach 17. All face cards are valued at 10 and Aces can be either 1 or 11. Good luck!\n");
    }

    protected int getHandValue(Hand h) {
        int total = 0;
        int aceCount = 0;
        for (int i = 0; i < h.numberOfCards(); i++) {
            if (h.getCard(i).getValue() == 1) {
                total += 11;
                aceCount++;
            } else if (h.getCard(i).getValue() > 10) {
                total += 10;
            } else {
                total += h.getCard(i).getValue();
            }
        }
        //Logic to handle Aces
        while (aceCount > 0) {
            if (total > 21) {
                total -= 10;
                aceCount--;
            } else {
                return total;
            }
        }
        return total;
    }

    protected void dealerSequence() {
        while (getHandValue(dealerHand) < 17) {
            dealerHand.addToHand(deck.dealCard());
        }
        printLine();
        System.out.println(dealerHand + " Total: " + getHandValue(dealerHand));
        System.out.println("\n\n\n\n\n");
        System.out.println(playerHand + " Total: " + getHandValue(playerHand));
        if (getHandValue(dealerHand) > 21){
            System.out.println("You Win! Dealer busted. See you next time!");
        } else if (getHandValue(dealerHand) > getHandValue(playerHand)){
            System.out.println("You Lose! Dealer has a higher total. Good luck next time!");
        } else if (getHandValue(dealerHand) < getHandValue(playerHand)){
            System.out.println("You Win! You have a higher total. See you next time!");
        } else {
            System.out.println("It's a tie. Better luck next time!");
        }
    }
}
