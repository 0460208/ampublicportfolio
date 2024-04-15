
public class ContactInformation {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    
    public ContactInformation(String firstName, String lastName, String email, String phoneNum) {
        firstName = "";
        lastName = "";
        email = "";
        phoneNum = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    
}
