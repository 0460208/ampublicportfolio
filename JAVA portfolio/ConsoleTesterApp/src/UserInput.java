/*
 * Author:   Amanda Martel
 * Date:     11/17/2020
 *
 * Filename: UserInput.java 
 * Program will perform an integer test, a double test, a string test, and a string choice test. 
 * Program will validate user entries. 
 * 
*/


public interface UserInput { //create UserInput interface 
    public int getInt(String prompt);
    public int getInt(String prompt, int min, int max);
    public double getDouble(String prompt);
    public double getDouble(String prompt, double min, double max);
    public String getString(String prompt);
    public String getString(String prompt, String s1, String s2);
}
