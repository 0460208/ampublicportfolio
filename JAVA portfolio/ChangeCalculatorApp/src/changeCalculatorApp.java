/*
 * Author:   Amanda Martel
 * Date:     11/7/2020
 *
 * Filename: changeCalculatorApp.java 
 * Program will ask the user to enter number of cents.
 * Program will return minimum amount of quarters, dimes, nickels, and pennies as output to the user. 
*/


import java.util.Scanner; //import Scanner class

public class changeCalculatorApp { //create the changeCalculatorApp class
    public static void main(String[] args) { //create main function
       //print welcome message for the user
       System.out.println("Welcome to the Change Calculator");
       System.out.println(); //print blank line
   
       Scanner sc = new Scanner(System.in); //create scanner object named sc 

      
       //while loop to begin program
       String choice = "y"; 
            while (choice.equalsIgnoreCase("y")) { //program continues if user enters y or Y
               int number = getIntWithinRange(sc, "Enter number of cents (0-99):   ", 0, 100);
               //int amount = sc.nextInt(); //create amount variable 
               System.out.println(); //print blank line
               
               //create int variables for quarters, dimes, nickels, and pennies
               //calculate remainder after each coin
               int quarters = number / 25;
               number = number % 25; 
               int dimes = number / 10;
               number = number % 10;
               int nickels = number / 5;
               number = number % 5;
               int pennies = number;
             
               //print messages amount in quarters, dimes, nickels, and pennies
               System.out.println("Quarters:       " + quarters);
               System.out.println("Dimes:          " + dimes);
               System.out.println("Nickels:        " + nickels);
               System.out.println("Pennies:        " + pennies);
               System.out.println(); //print blank line
           
               //ask user if they would like to continue
               choice = getChoice(sc, "Continue? (y/n):   ", "y", "n");
               System.out.println(); //print blank line
           }
        System.out.print("Goobye!");
       }

  
       //create getChoice() function 
    private static String getChoice(Scanner sc, String prompt, String s1, String s2){
       String s = "";
       boolean isValid = false;
       while(!isValid) {
          s = getString(sc, prompt);
          if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
              System.out.println("Error! Must be " + s1 + " or " + s2 + 
                      " Try again.");      
          } else {
               isValid = true;
          }
       }
       return s; 
    }
    
    //create getString() function 
    private static String getString(Scanner sc, String prompt){
       String s = ""; //create s String variable 
       boolean isValid = false; //create boolean variable 
       //while statement 
       while(!isValid) {
          //print message
          System.out.println(prompt);
          s = sc.nextLine(); //next string object 
          if (s.equals("")) {
              //print message 
              System.out.println("Error! Something is required. Try again.");      
          } else {
               isValid = true;
          }
       }
       return s; 
    }
    
        //create getInt function 
    public static int getInt(Scanner sc, String prompt) { 
        int i = 0; //initialize i variable 
        boolean isValid = false; //create boolean variable 
        //while statement 
        while (!isValid){
            System.out.print(prompt); //print prompt 
            if (sc.hasNextInt()) { //if int assign to variable i 
               i = sc.nextInt();
               isValid = true; // assign value to true 
            } else {
               //print message if user guess is an invalid number
               System.out.println("Error! Invalid Number. Try again. " ); 
            }
            sc.nextLine();
        }    
        return i; //return statement 
    }
    
    //create getIntWithinRange function 
    private static int getIntWithinRange(Scanner sc, String prompt, 
            int min, int max) {
        int i = 0; //initialize i variable 
        boolean isValid = false; //create boolean variable 
        //while statement 
        while (!isValid) {
            i = getInt(sc, prompt); //call getInt() function
            if (i <= min) {
                //print statement if user guess is less than min
                System.out.println("Error! Number must be greater than " + min);
            } else if (i >= max) {
                //print message if user guess is greater than max 
                System.out.println("Error! Numer must be less than " + max);
            } else {
                isValid = true;
            }
        }
            return i; //return statement 
    }
}
