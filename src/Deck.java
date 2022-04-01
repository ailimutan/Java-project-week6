import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public ArrayList < Card > cards;

    public Deck() {
        ArrayList < Card > cards = new ArrayList < > ();

        String[] cardType = {
            "Spades",
            "Hearts",
            "Diamonds",
            "Clubs"
        };
        String[] numNames = {
            "Ace",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Jack",
            "Queen",
            "King"
        };

        //generate 52 cards
        for (int i = 0; i < 4; i++) {
            String cardTitle = cardType[i];
            for (int l = 2; l <= 14; l++) {
                Card card = new Card();
                String cardName = numNames[l - 2] + " of " + cardTitle;
                card.setName(cardName);
                card.setValue(l);
                cards.add(card);
            }
        }

        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        Card topCard = cards.get(0);
        cards.remove(0);
        return topCard;
    }
}