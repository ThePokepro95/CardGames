import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String mainMenu = "Welcome to Lawrence's Collection of Card Games! \n";
        mainMenu += "------------------------------ \n";
        mainMenu += "Please Select a Game! \n";
        mainMenu += "1. Blackjack \n";
        mainMenu += "2. Baccarat \n";
        mainMenu += "3. Quit \n";

        boolean runCollection = true;
        boolean playAgain = false;
        int userSelection = 0;
        while (runCollection) {
            if (!playAgain) {
                System.out.println(mainMenu);
                userSelection = userInput.nextInt();
            }
            switch (userSelection) {
                case 1:
                    printSpace();
                    Blackjack bjGame = new Blackjack();
                    bjGame.playGame();
                    playAgain = playAgainChecker();
                    printLine();
                    printSpace();
                    break;
                case 2:
                    printSpace();
                    Baccarat bGame = new Baccarat();
                    bGame.playGame();
                    playAgain = playAgainChecker();
                    printLine();
                    printSpace();
                    break;
                case 3:
                    System.out.println("Thank you, come back soon!");
                    runCollection = false;
                    break;
                default:
                    System.out.println("Please type in a proper selection.");
                    break;
            }
        }

    }

    private static void printLine() {
        String line = "";
        for (int i = 0; i < 30; i++) {
            line += "*";
        }
        System.out.println(line);
    }

    private static void printSpace(){
        System.out.println("\n\n\n\n\n\n\n\n");
    }

    private static boolean playAgainChecker() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like to play again? Please enter yes or no.");
        return userInput.next().equalsIgnoreCase("yes");
    }
}