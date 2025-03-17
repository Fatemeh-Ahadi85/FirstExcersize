package FirstExersize;

import java.util.Scanner;

public class SignUp {

    Scanner input = new Scanner(System.in);

    public String UserName;
    public int Password;
    public double balance;

    SignUp(){
        System.out.println("Enter your UserName: ");
        this.UserName = input.nextLine();
        System.out.println("Enter your Password: ");
        this.Password = input.nextInt();
        System.out.println("Enter your balance: ");
        this.balance = input.nextDouble();
    }

    public String getUserName(){
        return UserName;
    }

    public int getPassword(){
        return Password;
    }

    public double getBalance(){
        return balance;
    }
}
