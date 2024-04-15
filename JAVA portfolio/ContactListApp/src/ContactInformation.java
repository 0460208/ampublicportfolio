
/*
 * Author:   Amanda Martel
 * Date:     10/20/2020 
 *
 * Filename:   ContactInformation.java
 * Program will allow user to input first name, last name, email, and phone number. 
 * Program will display the user information. 
 * Program will continue if user enters 'y' or 'Y'.  
 * 
 */

import java.util.Scanner; //import scanner class

    
public class ContactInformation { //create class ContactInformation
    private String firstName; 
    private String lastName;
    private String email;
    private String phoneNum;
    
     
    public ContactInformation(String firstName, String lastName, String email, String phoneNum) {
        firstName = ""; //create firstName variable 
        lastName = ""; //create lastName variable
        email = "";  //create email variable
        phoneNum = ""; //create phoneNum variable
    } 

    public String getFirstName() { //create getFirstName() method 
       return firstName;    //return firstName 
    }

    public void setFirstName(String firstName) { //create setFirstName() method with firstName argument 
        this.firstName = firstName; 
    }
    
    public String getLastName() { //create getLastName() method
        return lastName; //returnLastName
    }

    public void setLastName(String lastName) { //create setLastName() method with lastName argument 
        this.lastName = lastName;
    }
    
    public String getEmail() { //create getEmail() method
        return email; //return email
    }

    public void setEmail(String email) { //create setEmail() method with email argument 
        this.email = email;
    }
    
    public String getPhoneNum() { //create getPhoneNum() method
        return phoneNum; //return phoneNum
    }

    public void setPhoneNum(String phoneNum) { //create setPhoneNum() method with phoneNum argument 
        this.phoneNum = phoneNum; 
    }

    
}

