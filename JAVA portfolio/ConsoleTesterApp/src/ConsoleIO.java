/*
 * Author:   Amanda Martel
 * Date:     11/17/2020
 *
 * Filename: ConsoleIO.java 
 * Program will perform an integer test, a double test, a string test, and a string choice test. 
 * Program will validate user entries. 
 * 
*/



import java.util.Scanner; //import Scanner object 

public class ConsoleIO implements UserIO { //create class ConsoleIO that implements UserIO interface 
    private Scanner sc; //create private Scanner object 
    public ConsoleIO() {
        sc = new Scanner(System.in);
    }
    @Override 
        public void print(String s) {
        System.out.print(s);
        }   
    @Override 
        public void println() {
        System.out.println();
        }
    @Override
        public void println(String s1) {
        System.out.print(s1);
        }
        
    @Override    
    public String getString(String prompt, String s1, String s2){
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
    
    @Override
    //create getString() function 
    public String getString(String prompt) {
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
    
    @Override 
    //create getInt pass prompt parameter 
    public int getInt(String prompt) { 
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
    
    @Override 
    //create getInt pass prompt, min, max parameters
    public int getInt(String prompt, 
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
    
    @Override 
    //create getDouble function pass prompt parameter
    public double getDouble(String prompt) { 
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
    
    @Override 
    //create getDouble pass prompt, min, max parameters
    public double getDouble(String prompt, 
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
