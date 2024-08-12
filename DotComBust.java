import java.util.*;

/*
The game class.
Makes DotComs, gets user input, plays until all Dot-Coms are dead.

Uses the GameHelper class to get user input and make DotCom locations.
Uses the DotCom class to make DotCom objects and check the user's guesses.
 */

public class DotComBust {
    // Declare and initialize the variables we'll need
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;


    /*
    Set up the game: make three DotCom objects, give them names, and place them in the ArrayList.
     */
    private void setUpGame() {
        // Make three DotCom objects, give them names, and place them in the ArrayList
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        // Print brief instructions for the user
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        // Repeat with each DotCom in the list
        for (DotCom dotComToSet : dotComsList) {
            // Ask the helper for a DotCom location
            ArrayList<String> newLocation = helper.placeDotCom(3);
            // Call the setter method on this DotCom to give it the location you just got from the helper
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        // As long as the DotCom list is NOT empty
        while (!dotComsList.isEmpty()) {
            // Get user input
            String userGuess = helper.getUserInput("Enter a guess");
            // Call our own checkUserGuess method
            checkUserGuess(userGuess);
        }
        // Call our own finishGame method
        finishGame();
    }

    /*
    Check the user guess, look for a hit (or kill)
     */
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        // Repeat with all DotComs in the list
        for (DotCom dotComToTest : dotComsList) {
            // Ask the DotCom to check the user guess, looking for a hit (or kill)
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                // Remove this DotCom from the list
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        // Print the result for the user
        System.out.println(result);
    }

    /*
    Finish the game, print a message to the user
     */
    private void finishGame() {
        // Print a message telling the user how he did in the game
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main (String[] args) {
        // Create the game object
        DotComBust game = new DotComBust();
        // Tell the game object to set up the game
        game.setUpGame();
        // Tell the game object to start the main game play loop
        game.startPlaying();
    }

}
