/*
* Author:   Amanda Martel 
* Date:     9/25/2020
*
* Filename: CommonDivisorApp.java
* Program to calculate the greatest common divisor between 
* two numbers that the user inputs. 
* Program will continue to run as long as user enters 'y' or 'Y' 
*  
*/

import java.util.Scanner; //import Scanner class 


public class commonDivisorApp { //create CommonDivisorApp class 

    public static void main(String[] args) { //create main method 
        
        Scanner sc = new Scanner(System.in); //create new scanner object named sc
        String choice = "y"; //create choice variable
        
        
        System.out.println("Greatest Common Divisor Finder"); // print message for user 
        System.out.println(); //print blank line
        
        //while loop to continue program if user enters 'y' or 'Y'
        while (!choice.equalsIgnoreCase("n")) {
            // get the input from the user
            System.out.print("Enter first number:       "); //print message for user 
            int number1 = sc.nextInt(); //create int variable for number1
            System.out.print("Enter second number:      "); //print message for user 
            int number2 = sc.nextInt(); //create int varible for number2 
             
            
            //formula for finding greatest common divisor 
            //subtract x from y until y < x
            //swap the values of x and y
            //repeat first two steps until x = 0 
            //y is the greatest common divisor 
            while (number1 != number2) { //while number1 is not equal to number2 loop runs
        	if(number1 > number2) 
                number1 = number1 - number2;
                else
                number2 = number2 - number1;
            }
                
            System.out.print("Greatest common divisor:  " + number2); //print message for user 
            System.out.println(); //print blank line 
            
        // see if the user wants to continue
        System.out.print("Continue? (y/n):   "); //print message for user 
        choice = sc.next();
        System.out.println(); //print blank line 
        }
    }
    
}
