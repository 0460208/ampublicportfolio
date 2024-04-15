/*
 * Author:   Amanda Martel
 * Date:     11/20/2020 
 *
 * Filename:   Player1.java
 * Program will ask user for their name, ask them to chose an opponent, 
 * and chose rock, paper, or scissors.
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

public class Player1 extends Player { //create Player1 class that extends Player 
    public Player1() { //create Player1 class 
        super(); 
    }
    @Override 
    public Roshambo generateRoshambo() {
        return Roshambo.ROCK; //return statement 
    }
}
