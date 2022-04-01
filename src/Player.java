import java.util.ArrayList;

public class Player {
    public ArrayList < Card > hand;
    public int score;
    public String name;


    public Player(String name) {
        this.hand = new ArrayList < > ();
        this.score = 0;
        this.name = name;
    }


    /**
     * This method prints out information about the player and 
     * calls the describe method for each card in the 
     * Hand List.
     */
    public void describe() {
        System.out.println(name + "'s cards:");
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).describe();
        }
    }


    /**
     * This method removes and returns the
     *  top card of the Hand calls the describe 
     *  method for each card in the Hand List.
     */
    public Card flip() {
        Card topCard = hand.get(0);
        hand.remove(0);
        return topCard;
    }

    /**
     * This method takes a Deck as an argument and calls 
     * the draw method on the deck, adding 
     * the returned Card to the hand field.
     * @param deck, an instance of Deck class
     */
    public void draw(Deck deck) {
        hand.add(deck.draw());
    }


    /**
     * This method adds 1 to the Player’s
     *  score field.
     */
    public void incrementScore() {
        score++;
    }
}