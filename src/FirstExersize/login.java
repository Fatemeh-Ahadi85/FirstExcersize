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

    public String getUserName(){
        SignUp signUp = new SignUp();
        if(signUp.UserName.equals(this.UserName)){
            return UserName;
        }
        else{
            return "Your UserName is incorrect";
        }
    }

    public String getPassword(){
        SignUp signUp = new SignUp();
        if(signUp.Password == Password){
            return String.valueOf(Password);
        }
        else{
            return "Your password is incorrect";
        }
    }
}
