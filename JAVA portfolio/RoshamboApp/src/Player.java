/*
 * Author:   Amanda Martel
 * Date:     11/20/2020 
 *
 * Filename:   Player.java
 * Program will ask user for their name, ask them to chose an opponent, 
 * and chose rock, paper, or scissors.
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

public abstract class Player { //create abstract class Player 
    private String name; //create String name 
    private Roshambo roshb; //create Roshambo roshb
    
    public Player() { //create Player class
        name = ""; //set name to empty string 
    }
    
    public void setName(String name) {
        this.name = name; //set name 
    }
    
    public String getName() {
        return name; //return statement 
    }
    
    public void setRoshambo(Roshambo roshb) {
        this.roshb = roshb; //set Roshambo 
    }
    
    public Roshambo getRoshambo() {
        return roshb; //return roshb 
    }
    
    public abstract Roshambo generateRoshambo(); //generateRoshambo 
}
