public class App {

    public static void main(String[] args) {
        Deck deck = new Deck();

        //instantiate players
        Player player1 = new Player("Joshua");
        Player player2 = new Player("Sarah");


        deck.shuffle(); //shuffle the deck
        System.out.println("Deck has been shuffled ....");

        //players draw card alternately starting with Player 1, then Player 2
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player1.draw(deck);
            } else {
                player2.draw(deck);
            }
        }

        System.out.println("Players are drawing cards ....");

        displayRoundResults(player1, player2);
        displayGameResults(player1, player2);

    }

    /**
     * This method is used to display results of each 
     * rounds when players flip their card.
     * @param player1, the first player of the game
     * @param player2,the second player of the game
     * @return Nothing
     */
    public static void displayRoundResults(Player player1, Player player2) {

        System.out.println("========================================");
        System.out.println("Player 1 hand cards size: " + player1.hand.size());
        System.out.println("Player 2 hand cards size: " + player2.hand.size());
        System.out.println("========================================\n");

        //iterate 26 times and call the flip method for each player
        for (int i = 0; i < 26; i++) {

            Card playerOneCard = player1.flip();
            Card playerTwoCard = player2.flip();

            System.out.println("ROUND " + (i + 1));
            System.out.println("Player One: " + playerOneCard.describe() + "\n" + "Player Two: " + playerTwoCard.describe());

            int playerOneValue = playerOneCard.getValue();
            int playerTwoValue = playerTwoCard.getValue();

            String results = "RESULT: ";

            if (playerOneValue > playerTwoValue) {
                player1.incrementScore();
                results = results + "Player ONE Wins!!\n";
            } else if (playerOneValue == playerTwoValue) {
                results = results + "It's a TIE !!\n";
            } else {
                player2.incrementScore();
                results = results + "Player TWO Wins!!\n";
            }

            System.out.println(results);
        }

    }

    /**
     * This method is used to display the final results
     * of the game.
     * @param player1, the first player of the game
     * @param player2,the second player of the game
     * @return Nothing
     */

    public static void displayGameResults(Player player1, Player player2) {
        System.out.println("======= TALLY OF SCORES ================");
        System.out.println("Player One, " + player1.name + " has " + player1.score + " total points.");
        System.out.println("Player Two, " + player2.name + " has " + player2.score + " total points.");

        String finalResult = "";

        if (player1.score > player2.score) {
            finalResult = "Congratulations to the WINNER, PLAYER ONE, " + player1.name + "!";
        } else if (player1.score == player2.score) {
            finalResult = "It's a DRAW !!";
        } else {
            finalResult = "Congratulations to the WINNER, PLAYER TWO, " + player2.name + "!";
        }

        System.out.println(finalResult);
    }
}