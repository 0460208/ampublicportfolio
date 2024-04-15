import java.util.Scanner;

public class ContactListApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Contact List Application");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
            System.out.print("Enter first name:    ");
            String firstName = sc.nextLine();
            System.out.print("Enter last name:     ");
            String lastName = sc.nextLine();
            System.out.print("Enter email:         ");
            String email = sc.nextLine();
            System.out.print("Enter phone:         ");
            String phoneNum = sc.nextLine();

            //System.out.print("Enter width:  ");
            //double width = Double.parseDouble(sc.nextLine());

            //String userInfo;
            //userInfo = ContactInformation.(firstName, lastName, email, phoneNum);
            
            ContactInformation userInfo = new ContactInformation(firstName, lastName, email, phoneNum);
            userInfo.setFirstName(firstName);
            userInfo.setLastName(lastName);
            userInfo.setEmail(email);
            userInfo.setPhoneNum(phoneNum);
            // format and display output
            String message = 
                "Name:             " + userInfo.getFirstName() + " " + userInfo.getLastName() + "\n" +
                "Email Address:    " + userInfo.getEmail() + "\n" +
                "Phone Number:     " + userInfo.getPhoneNum() + "\n";
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        System.out.println("Bye!");
    }  
}
