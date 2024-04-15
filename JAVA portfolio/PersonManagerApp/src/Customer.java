/*
 * Author:   Amanda Martel
 * Date:     11/5/2020 
 *
 * Filename:   Customer.java
 * Program will allow user to input information for either a customer or employee.
 * Program will allow user to input first name, last name, customer number, or social security number. 
 *
 * Program will display the user information. 
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

public class Customer extends Person {
    private String custNum;
    
    public Customer(String firstName, String lastName, String number) {
        super(firstName, lastName); //use superclass 
        custNum = number; //set number variable to empty string 
    }

    public String getCustomerNumber() { //create getCustomerNumber method
        return custNum; //return number
    }

    public void setCustomerNumber(String custNum) { //create setCustomerNumber() method with email argument 
        this.custNum = custNum; //setnumber
    }
    
    @Override
    public String toString() { //create getDisplayText method 
        String name = super.toString();
        return name + "\n" + "Customer Number: " + custNum; //return statement 
    }
}
