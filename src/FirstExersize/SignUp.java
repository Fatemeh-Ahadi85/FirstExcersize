package FirstExersize;

import java.util.Scanner;

public class SignUp {

    Scanner input = new Scanner(System.in);

    public String UserName;
    public int Password;

    SignUp(){
        System.out.println("Enter your UserName: ");
        this.UserName = input.nextLine();
        System.out.println("Enter your Password: ");
        this.Password = input.nextInt();
    }

    public String getUserName(){
        return UserName;
    }

    public int getPassword(){
        return Password;
    }
}
