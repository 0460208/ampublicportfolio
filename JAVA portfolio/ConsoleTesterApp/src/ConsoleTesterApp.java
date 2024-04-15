/*
 * Author:   Amanda Martel
 * Date:     11/17/2020
 *
 * Filename: ConsoleTesterApp.java 
 * Program will perform an integer test, a double test, a string test, and a string choice test. 
 * Program will validate user entries. 
 * 
*/

public class ConsoleTesterApp { //create ConsoleTesterApp class 

    public static void main(String[] args) { //create main method 
        UserIO c = IOFactory.getUserIO(); // create variable c to call getUserIO()
        //print message 
        c.println("Welcome to the Console Tester Application");
        c.println(); //print blank line
        c.println(); //print blank line
        
        //Integer Test 
        c.println("Integer Test"); //print message 
        c.println(); //print blank line 
        //create integer variable to call getInt()
        //pass string, int, int parameters 
        int integer = c.getInt("Enter a number between -100 and 100: ", -100, 100);
        c.println();
        
        //Double test 
        c.println("Double Test");
        c.println(); //print blank line 
        //create double variable to call getDouble()
        //pass string, double, double parameters 
        double decimal = c.getDouble("Enter a number between -100 and 100: ", -100, 100);
        c.println();
        
        //String test 
        //print message 
        c.println("String Test");
        c.println(); //pront blank line 
        //create email variable to call getString()
        //pass string parameters 
        String email = c.getString("Enter your email address: ");
        c.println(); //print blank line 
        
        //Choice test 
        c.println("Choice Test");
        c.println();
        //create choice variable to call getString()
        //pass string, string, string parameters 
        String choice = c.getString("Select one (a/b): ", "a", "b");
        c.println();
        
     
            
    }
    
}
