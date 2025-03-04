package FirstExersize;

import java.util.Scanner;

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

    public String getUserName(String UserName){
        return UserName;
    }

    public int getPassword(int Password){
        return Password;
    }
}
