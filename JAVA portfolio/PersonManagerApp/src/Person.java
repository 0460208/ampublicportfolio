/*
 * Author:   Amanda Martel
 * Date:     11/5/2020 
 *
 * Filename:   Person.java
 * Program will allow user to input information for either a customer or employee.
 * Program will allow user to input first name, last name, customer number, or social security number. 
 *
 * Program will display the user information. 
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */
    
public class Person { //create class person
    private String firstName; //create private string for first 
    private String lastName; //create private string for last
    
    public Person(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    public String getFirstName() { //create getFirstName() method 
       return firstName;    //return first
    }

    public void setFirstName(String firstName) { //create setFirstName() method with firstName argument 
        this.firstName = firstName; //set first
    }
    
    public String getLastName() { //create getLastName() method
        return lastName; //return last
    }

    public void setLastName(String lastName) { //create setLastName() method with lastName argument 
        this.lastName = lastName; //set last
    }
    
    @Override 
    public String toString() { //create getDisplayText method 
        return "Name: "  + firstName + " " + lastName + "\n"; //return statement 
              
    }


}

