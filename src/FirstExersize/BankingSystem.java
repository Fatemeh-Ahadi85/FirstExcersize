package FirstExersize;

import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Ahad Banking System!");
        String input = scanner.nextLine();

        if(input.equals("SignUp")){
            SignUp signUp = new SignUp();
            signUp.getUserName();
            signUp.getPassword();
            System.out.println("Your account has been successfully created.");
        }
        else if(input.equals("login")){
            login login = new login();
            login.getUserName();
            login.getPassword();
            System.out.println("You have successfully logged in to your account.");
        }
        else if(input.equals("back")){
            System.out.println("You are in homePage.");
        }
    }
}
