package FirstExersize;

import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class login {
    Scanner scanner = new Scanner(System.in);

    protected String UserName;
    protected int Password;

    login(){
        System.out.println("Enter your UserName: ");
        this.UserName = scanner.nextLine();
        System.out.println("Enter your Password: ");
        this.Password = scanner.nextInt();

    }

    public Object getUserName() throws DataFormatException, IOException {
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(this.UserName);
        if(isUserProfileTrue.isUserNameTrue()){
            return this.UserName;
        }
        else {
            System.out.println("Please Enter Your UserName Carefully!");
            return new login();
        }
    }
    public Object getPassword() throws DataFormatException, IOException {
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(this.UserName);
        if(isUserProfileTrue.isPasswordTrue(String.valueOf(Password))){
            return this.Password;
        }
        else {
            System.out.println("Please Enter Your Password Carefully!");
            return new login();
        }
    }
}
