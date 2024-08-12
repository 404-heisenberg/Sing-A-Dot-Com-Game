import java.util.*;

/*
The actual DotCom objects.
DotComs know their name, location, and how to check a user guess for a match.
 */

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    // setter method that updates the DotCom's location. (Random location provided by the GameHelper placeDotCom method)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    /*
    Check the user guess. Return "hit", "miss", or "kill"
     */
    public String checkYourself(String userInput) {
        String result = "miss";
        // indexOf returns -1 if the element is not in the ArrayList
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            // Check to see if you've sunk the DotCom
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " :(");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
