package FirstExersize;

import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class login {
    Scanner scanner = new Scanner(System.in);

    protected String UserName;
    protected int Password;

    public Object getUserName() throws DataFormatException, IOException {
        System.out.println("Enter your UserName: ");
        UserName = scanner.nextLine();
        if(UserName.equals("back")) {
            return "back";
        }
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(this.UserName,"src/FirstExersize/Users.json");
        if(isUserProfileTrue.isUserNameTrue()){
            return this.UserName;
        }
        else {
            System.out.println("Please Enter Your UserName Carefully!");
            return getUserName();
        }
    }
    public Object getPassword() throws DataFormatException, IOException {
        System.out.println("Enter your Password: ");
        String i =  scanner.nextLine();
        if(i.equals("back")){
            return "back";
        }
        Password = Integer.parseInt(i);
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(this.UserName,"src/FirstExersize/Users.json");
        if(isUserProfileTrue.isPasswordTrue(String.valueOf(Password))){
            return this.Password;
        }
        else {
            System.out.println("Please Enter Your Password Carefully!");
            return getPassword();
        }
    }
}
