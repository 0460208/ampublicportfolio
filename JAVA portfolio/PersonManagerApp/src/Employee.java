/*
 * Author:   Amanda Martel
 * Date:     11/5/2020 
 *
 * Filename:   Employee.java
 * Program will allow user to input information for either a customer or employee.
 * Program will allow user to input first name, last name, customer number, or social security number. 
 *
 * Program will display the user information. 
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

public class Employee extends Person {
    private String ssn;
    
    public Employee(String firstName, String lastName, String ssn) {
        super(firstName, lastName); //use superclass 
        this.ssn = ssn;
    }

    public String getSsn() { //create getSsn
        return "xxx-xx-" + ssn.substring(ssn.length() -4); //return statement 
        //display only last four digits of ssn 
    }

    public void setSsn(String ssn) { //create setSsn 
        this.ssn = ssn; //set ssn
    }
    @Override
    public String toString() { //override toString method 
        String name = super.toString();
        return name + "\n" + "SSN: " + getSsn(); //return statement 
    }


}
