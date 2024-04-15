
/*
 * Author:   Amanda Martel
 * Date:     11/29/2020 
 *
 * Filename:   TicTacToe.java
 * Program will display a tic tac toe board and allow user to play.   
 * 
 */


public class TicTacToeApp {  //create TicTacToeApp class 
    private static String[][] grid = { //create grid 
        {" ", " ", " "}, 
        {" ", " ", " "}, 
        {" ", " ", " "},         
    };


    public static void main(String[] args) { //create main method 
        System.out.println("Welcome to Tic Tac Toe"); //print welcome message 
        displayGrid(); //call displayGrid
        startGame(); //call startGame 
        System.out.println("Bye!"); //print message 

    }    
    
    private static void displayGrid() { //create displayGrid method 
        System.out.println(); //print blank line 
        System.out.println("+---+---+---+");
        //create the grid 
        for(String[] row : grid) { 
            System.out.print("|");
            for (String column : row) {
                System.out.print("  " + column + "|");
            }
            System.out.println();
            System.out.println("+---+---+---+");
            
        }
        System.out.println(); //print blank line 
    }
    
    private static void startGame() { //create startGame method 
       boolean gameOver = false;  //create boolean variable gameOver set to false 
       while (gameOver == false) {
           gameOver = takeTurn(); //set gameOver to takeTurn
       }
       System.out.println(); //print blank line 
       System.out.println("Game Over!"); //print game over message 
    }

    private static boolean takeTurn() { //create takeTurn method 
        int turn = 1; //create int turn set to 1 
        boolean gameOver; 
        String mark; 
        //while statement 
        while (true) {
            if (turn % 2 != 0) {
                mark = "X"; //mark set to X 
            } else {
                mark = "O"; //mark set to O 
            }
            System.out.println(mark + "'s turn"); //print whos turn it is 
            
            //prompt user to pick a row 
            int row = Console.getInt("Pick a row (1, 2, 3): "); //create row variable 
            if (row < 1 || row > 3) {
                //print message 
               System.out.println("Invalid row number, try again."); 
               continue; //continue statement 
            }
            
            //prompt user to pick a colummn
            int col = Console.getInt("Pick a column (1, 2, 3): ");
                if (col < 1 || col > 3) {
                    //print message 
                System.out.println("Invalid row number, try again."); 
                continue; //continue statement 
            }
                
            if (!grid[row-1][col-1].equals (" ")) {
                //print message 
                System.out.println("This square is already taken. Try again!");
                continue; //continue statement 
            }
            
            grid[row-1][col-1] = mark;
            displayGrid(); //call displayGrid 
            
            String winner = checkForWinner(); //create winner variable 
            if (winner.equals("X") || winner.equals("O")) {
                System.out.println(winner + " wins!"); //print message 
                gameOver = true; 
                return gameOver; //return statement 
            }
            
            if (turn == 9) {
                System.out.println("It's a tie!"); //print statement 
                gameOver = true;
                return gameOver; //return statement 
            }
            turn++;  //increase the turn              
        }
    
    }
    
    private static String checkForWinner() { //create checkForWinner method 
        //rows
        for (int x = 0; x < 3; x++) {
            if(grid[x][0].equals(grid[x][1]) && 
               grid[x][1].equals(grid[x][2])) {
               return grid[x][0];
               
        }  
    } 
        //column
        for (int y = 0; y < 3; y++) {
            if(grid[0][y].equals(grid[1][y]) && 
               grid[1][y].equals(grid[2][y])) {
               return grid[0][y];
               
        }  
    } 
        //diagonal 1
        if (grid[0][0].equals(grid[1][1]) && 
           grid[1][1].equals(grid[2][2])) {
           return grid[0][0];
               
        } 
        
        //diagonal 2
        if (grid[0][2].equals(grid[1][1]) && 
        grid[1][1].equals(grid[2][0])) {
        return grid[2][0];
               
        } 
        
        //no winner
        return " "; 
        
    }
}