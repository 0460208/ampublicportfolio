/*
 * Author:   Amanda Martel
 * Date:     11/20/2020 
 *
 * Filename:   RoshamboApp.java
 * Program will ask user for their name, ask them to chose an opponent, 
 * and chose rock, paper, or scissors.
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */


public class RoshamboApp { //create public class RoshamboApp

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //create main method 
        System.out.print("Welcome to the game of Roshambo"); //print message 
        System.out.println(); //print blank line 
        System.out.println(); //print blank line 
        
        String name = Console.getString("Enter your name: "); //prompt user 
        System.out.println(); //print blank line 
        
        Player1 player1 = new Player1(); //create a new player1 variable with Player1 data type 
        player1.setName(name);
        
        String opponent = Console.getString(
               "Who would you like to play Bart or Lisa? (B/L): ", "b", "l"); //prompt user to chose Bart or Lisa 
               System.out.println(); //print blank line 
                
       Player player2 = null; //create player2 variable set to null
       if (opponent.equalsIgnoreCase("b")) {
             player2 = new Bart(); //set player2 to Bart
       } else {
            player2 = new Lisa(); //set player2 to Lisa 
       }
        
        Roshambo rock = Roshambo.ROCK;
        String choice = "y";
        while(choice.equalsIgnoreCase("y")) {  
            String selection = Console.getString(
                "Rock, Paper, or Scissors? (R/P/S): ", "r", "p", "s"); //prompt user to chose Bart or Lisa 
                System.out.println(); //print blank line 
                
            if (selection.equalsIgnoreCase("r")) {
                player1.setRoshambo(Roshambo.ROCK); 
            } else if (selection.equalsIgnoreCase("p")) {
                player1.setRoshambo(Roshambo.PAPER);
            } else {
                player1.setRoshambo(Roshambo.SCISSORS);
            }
        Roshambo roshb = player2.generateRoshambo();
        player2.setRoshambo(roshb);
        
        System.out.println(player1.getName() + ": " + player1.getRoshambo());
        System.out.println(player2.getName() + ": " + player2.getRoshambo());
        play(player1, player2);
        
        System.out.println(); //print blank line 
        choice = Console.getString("Do you want to play again? (Y/N): ", "y", "n");
        System.out.println(); //print blank line 
        }        
    }        
    private static void play (Player player1, Player player2) {
        if (player1.getRoshambo() == player2.getRoshambo()) {
            System.out.println("Draw!");
        } else {
            if (
                (player1.getRoshambo() == Roshambo.ROCK && 
                player2.getRoshambo() == Roshambo.SCISSORS) ||
                (player1.getRoshambo() == Roshambo.PAPER && 
                player2.getRoshambo() == Roshambo.ROCK) || 
                (player1.getRoshambo() == Roshambo.SCISSORS &&
                player2.getRoshambo() == Roshambo.PAPER)
                    )
                        
            { System.out.println(player1.getName() + " wins!");   

            } else {
              System.out.println(player2.getName() + " wins!");  
            }
        }
    }
}
