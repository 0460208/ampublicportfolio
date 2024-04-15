/*
 * Author:   Amanda Martel
 * Date:     11/20/2020 
 *
 * Filename:   Bart.java
 * Program will ask user for their name, ask them to chose an opponent, 
 * and chose rock, paper, or scissors.
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

public class Bart extends Player { //create class Bart that extends Player 
    public Bart() {
        super();
        super.setName("Bart"); //setName to "Bart"
    }

    @Override 
    public Roshambo generateRoshambo() {
        return Roshambo.ROCK; //return statement 
    }   
}