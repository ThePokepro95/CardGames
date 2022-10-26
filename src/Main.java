
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.print();
        System.out.println();
        deck.cut();
        deck.print();
        System.out.println();
        System.out.println(deck.dealCard());
        deck.print();
    }
}