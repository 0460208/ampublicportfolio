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

public class Lisa extends Player { //create class Lisa that extends Player 
        public Lisa() { //create public Lisa 
        super();
        super.setName("Lisa"); //setName to "Lisa"
    }
    @Override 
    public Roshambo generateRoshambo() { //generateRoshambo 
        int i = (int)(Math.random() * 3);
            if (i == 0) {
                return Roshambo.ROCK;    
            } else if (i == 1) {
                return Roshambo.PAPER;
            } else {
                return Roshambo.SCISSORS;
            }

    }       

}
