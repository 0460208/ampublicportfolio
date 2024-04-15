
/*
 * Author:   Amanda Martel
 * Date:     10/20/2020 
 *
 * Filename:   ContactListApp.java
 * Program will allow user to input first name, last name, email, and phone number. 
 * Program will display the user information. 
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */


import java.util.Scanner; //import Scanner class 


public class ContactListApp { //create class ContactListApp 

    public static void main(String[] args) { //create main method 
        System.out.println("Welcome to the Contact List Application"); //print message 
        System.out.println(); //print blank line 

        Scanner sc = new Scanner(System.in); //create new scanner object named sc 
        String choice = "y"; 
        //while loop 
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
            System.out.print("Enter first name:    ");
            String firstName = sc.nextLine(); //create firstName string variable 
            System.out.print("Enter last name:     ");
            String lastName = sc.nextLine(); //create lasstName string variable 
            System.out.print("Enter email:         ");
            String email = sc.nextLine(); //create email string variable 
            System.out.print("Enter phone:         ");
            String phoneNum = sc.nextLine(); //create phoneNum string variable 

            
            ContactInformation userInfo = new ContactInformation(firstName, lastName, email, phoneNum);
            userInfo.setFirstName(firstName); //set firstName variable 
            userInfo.setLastName(lastName); //set lastName variable 
            userInfo.setEmail(email); //set email variable 
            userInfo.setPhoneNum(phoneNum); //set phoneNum variable 
            
            //print 
            System.out.println("----------------------------------------------------");
            System.out.println("----------- Current Contact ------------------------");
            System.out.println("----------------------------------------------------");
            // format and display output
            // store in string message variable 
            String message = 
                "Name:             " + userInfo.getFirstName() + " " + userInfo.getLastName() + "\n" +
                "Email Address:    " + userInfo.getEmail() + "\n" +
                "Phone Number:     " + userInfo.getPhoneNum() + "\n";
            System.out.println(message); //print message 
            System.out.println("----------------------------------------------------");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine(); //get user choice 
            System.out.println(); //print blank line 
        }
        System.out.println("Bye!"); //print message 
    }
}
 