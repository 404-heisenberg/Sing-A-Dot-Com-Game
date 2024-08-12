import java.io.*;
import java.util.*;

/*
The helper class.
It knows how to accept user command-line input, and make DotCom locations.
 */

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    /*
    Get user input from the command line.
     */
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    /*
    Place a DotCom on the grid.
     */
    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();

        // Temp string for concat
        String temp = null;
        // Current candidate x coordinate
        int[] coords = new int[comSize];
        // Current attempts counter
        int attempts = 0;
        // Flag = found a good location?
        boolean success = false;
        // Current starting location
        int location = 0;

        // Increment a counter for the number of DotComs created
        comCount++;
        // Set the horizontal increment
        int incr = 1;
        // If the DotCom is odd (an odd number of them), place it vertically
        if ((comCount % 2) == 1) {
            // Set the vertical increment
            incr = gridLength;
        }

        // While we haven't found a good location
        while (!success & attempts++ < 200) {
            // Get random starting point
            location = (int) (Math.random() * gridSize);

            // nth position in dotcom to place
            int x = 0;
            success = true;

            // Look for adjacent unused spots
            while (success && x < comSize) {
                // If not already used
                if (grid[location] == 0) {
                    // Save location
                    coords[x++] = location;
                    // Try next adjacent
                    location += incr;
                    // Out of bounds - 'bottom'
                    if (location >= gridSize) {
                        success = false;
                    }
                    // Out of bounds - right edge
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    }
                    // Found already used location
                } else {
                    success = false;
                }
            }
        }

        // Turn location into alpha coords
        int x = 0;
        int row = 0;
        int column = 0;

        while (x < comSize) {
            // Mark master grid points as 'used'
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            // Convert row to string
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }

        return alphaCells;
    }
}
