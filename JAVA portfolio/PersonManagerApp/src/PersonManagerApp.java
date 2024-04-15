/*
 * Author:   Amanda Martel
 * Date:     11/5/2020 
 *
 * Filename:   PersonManagerApp.java
 * Program will allow user to input information for either a customer or employee.
 * Program will allow user to input first name, last name, customer number, or social security number. 
 *
 * Program will display the user information. 
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */


public class PersonManagerApp { //create class ContactListApp 

    public static void main(String[] args) { //create main method 
        System.out.println("Welcome to the Person Manager"); //print message 
        System.out.println(); //print blank line 
        

        String choice = "y"; 
        //while loop 
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
            String option = Console.getString("Create customer or employee? (c/e)", "c", "e");

           //set first, last
            String first = Console.getString("First name:  "); //create first string variable 
            String last = Console.getString("Last name:  "); //create last string variable 
            System.out.println(); //print blank line 
            Person person; //create person of type Person
            if (option.equalsIgnoreCase("c")) {
                String custNum = Console.getString("Customer Number:  "); //create number string variable 
                person = new Customer(first, last, custNum); //pass first, last, custNum parameters to make a copy of person
            } else {
                String ssn = Console.getString("Enter social security number:  "); //create ssn string variable 
                person = new Employee(first, last, ssn); //pass first, last, ssn parameters to make a copy of person
            }
            
            Class c = person.getClass(); //call getClass on person object 
            System.out.println("You entered a new " + c.getName() + ": ");  //print message 
            System.out.println(person.toString()); //print message calls toString()
            System.out.println(); //print blank line 
            
            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n):  ");
            System.out.println(); //print blank line 

        }
        System.out.println("Bye!"); //print message 
    }
}
 