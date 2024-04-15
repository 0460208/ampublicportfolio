/*
 * Author:   Amanda Martel
 * Date:     11/20/2020 
 *
 * Filename:   Roshambo.java
 * Program will ask user for their name, ask them to chose an opponent, 
 * and chose rock, paper, or scissors.
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

public enum Roshambo { //create public enum Roshambo
    //create constants 
    ROCK, 
    PAPER,
    SCISSORS;
    
    @Override
    public String toString() {
        String s = ""; //create s variable set to empty string 
        if (this.ordinal() == 0) {
            s = "Rock"; //set s to "Rock"
        } else if (this.ordinal() == 1) {
            s = "Paper"; //set s to "Paper"
        } else if (this.ordinal() == 2) {
            s = "Scissors"; //set s to "Scissors"
        }
        return s;  //return statement 
    }
    
}
