package FirstExersize;

import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class login {
    Scanner input = new Scanner(System.in);

    private String UserName;
    private int Password;

    login(){
        System.out.println("Enter your UserName: ");
        this.UserName = input.nextLine();
        System.out.println("Enter your Password: ");
        this.Password = input.nextInt();

    }

    public Object get() throws DataFormatException, IOException {
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue();
        if(isUserProfileTrue.isUserExist(this.UserName,String.valueOf(this.Password))){
            return true;
        }
        else {
            System.out.println("Please Enter Your Details Carefully!");
            return new login();
        }
    }
}
