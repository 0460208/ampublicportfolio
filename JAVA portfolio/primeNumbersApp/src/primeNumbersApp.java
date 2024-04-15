/*
 * Author:   Amanda Martel 
 * Date:     10/10/2020
 * 
 * Filename: primeNumbersApp.java
 * Program will print the numbers 1 through 10 and say whether or not it is prime. 
 */

import java.util.Scanner; 

public class primeNumbersApp {
    public int number;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //create new scanner object named sc
   
        System.out.println("number       prime or not?"); // print message 
        System.out.println("------       -------------"); // print message


        int count = 1;
        //count++;
        boolean isValid = true;
      
        String answer = "";
        boolean results = isPrime(count);
        while (count <= 10) {
            if (results == isValid) {
                answer = "prime";
                System.out.println(" " + count + "           " + answer);
            } else {
                answer = "not prime"; 
                System.out.println(" " + count + "           " + answer);
            } 
            count++;
        }
    }
    
        //create boolean method isPrime s
    public static boolean isPrime(int count) { 
        int max = 10; //create max variable 
        if (count == 1) {
            return true;  //return statement 
        }
        for (int i = 2; i < max; i++) 
            if (count % i == 0) {
                return false;  //return statement 
            }
        return true; //return statement 
    } 
}
    

