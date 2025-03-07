package FirstExersize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/FirstExersize/users.txt");
        PrintStream printStream = new PrintStream(fileOutputStream);
        printStream.println("[");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Ahad Banking System!");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("SignUp")) {
                SignUp signUp = new SignUp();
                String UserName = signUp.getUserName();
                int password = signUp.getPassword();
                saveToJson(UserName, password,printStream);

                System.out.println("Your account has been successfully created.");
            } else if (input.equals("login")) {
                login login = new login();
                login.getUserName();
                login.getPassword();
                System.out.println("You have successfully logged in to your account.");
            } else if (input.equals("back")) {
                System.out.println("You are in homePage.");
            }
            else if (input.equals("exit")) {
                printStream.print("]");
                break;
            }
        }
    }

    public static void saveToJson(String UserName, int Password,PrintStream printStream) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        stringBuilder.append("    \"UserName\": ");
        stringBuilder.append("\""+UserName+"\"");
        stringBuilder.append(",\n");
        stringBuilder.append("    \"Password\": ");
        stringBuilder.append(Password);
        stringBuilder.append("\n}\n");
        printStream.print(stringBuilder);
    }
}
