/*
 * Author:   Amanda Martel
 * Date:     11/17/2020
 *
 * Filename: IOFactory.java 
 * Program will perform an integer test, a double test, a string test, and a string choice test. 
 * Program will validate user entries. 
 * 
*/


public class IOFactory {  //create class IOFactory
    public static UserIO getUserIO() { //getUserIO method
        return new ConsoleIO(); //return new ConsoleIO 
    }   
}
