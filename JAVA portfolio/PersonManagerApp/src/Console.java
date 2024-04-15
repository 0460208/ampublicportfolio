/*
 * Author:   Amanda Martel
 * Date:     11/5/2020 
 *
 * Filename:   Console.java
 * Program will allow user to input information for either a customer or employee.
 * Program will allow user to input first name, last name, customer number, or social security number. 
 *
 * Program will display the user information. 
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

import java.util.Scanner; //import Scanner class 

public class Console {
    private static Scanner sc = new Scanner(System.in); //create private Scanner object 
        
     //create getChoice() function 
    public static String getString(String prompt, String s1, String s2){
       String s = "";
       boolean isValid = false;
       while(!isValid) {
          s = getString(prompt);
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
    public static String getString(String prompt) {
       String s = ""; //create s String variable 
       boolean isValid = false; //create boolean variable 
       //while statement 
       while(!isValid) {
          //print message
          System.out.print(prompt);
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
    
      //create getInt pass prompt parameter 
    private static int getInt(String prompt) { 
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
    
    //create getInt pass prompt, min, max parameters
    private static int getInt(String prompt, 
            int min, int max) {
        int i = 0; //initialize i variable 
        boolean isValid = false; //create boolean variable 
        //while statement 
        while (!isValid) {
            i = getInt(prompt); //call getInt() function
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
    
       //create getDouble function pass prompt parameter
    private static double getDouble(String prompt) { 
        double i = 0; //initialize i variable 
        boolean isValid = false; //create boolean variable 
        //while statement 
        while (!isValid){
            System.out.print(prompt); //print prompt 
            if (sc.hasNextDouble()) { //if int assign to variable i 
               i = sc.nextDouble();
               isValid = true; // assign value to true 
            } else {
               //print message if user guess is an invalid number
               System.out.println("Error! Invalid Number. Try again. " ); 
            }
            sc.nextLine();
        }    
        return i; //return statement 
    }
    
    //create getDouble pass prompt, min, max parameters
    private static double getDouble(String prompt, 
            double min, double max) {
        double i = 0; //initialize i variable 
        boolean isValid = false; //create boolean variable 
        //while statement 
        while (!isValid) {
            i = getDouble(prompt); //call getInt() function
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
