package FirstExersize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class BankingSystem {
    public static boolean flag = false;
    public static void main(String[] args) throws IOException, DataFormatException {

        FileOutputStream fileOutputStream = new FileOutputStream("src/FirstExersize/Users.json");
        PrintStream printStream = new PrintStream(fileOutputStream);
        printStream.print("[");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Ahad Banking System!");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("SignUp")) {
                SignUp signUp = new SignUp();
                String UserName = signUp.getUserName();
                int password = signUp.getPassword();
                double balance = signUp.getBalance();
                saveToJson(UserName, password, balance, printStream);

                System.out.println("Your account has been successfully created.");
            } else if (input.equals("login")) {
                login login = new login();
                login.get();
            } else if (input.equals("back")) {
                System.out.println("You are in homePage.");
            }
            else if (input.equals("exit")) {
                break;
            }
        }
    }

    public static void saveToJson(String UserName, int Password, double balance, PrintStream printStream){
        StringBuilder stringBuilder = new StringBuilder();
        if(flag){
            stringBuilder.append(",");
        }
        stringBuilder.append("{\n");
        stringBuilder.append("    \"UserName\": ");
        stringBuilder.append("\""+UserName+"\"");
        stringBuilder.append(",\n");
        stringBuilder.append("    \"Password\": ");
        stringBuilder.append(Password);
        stringBuilder.append(",\n");
        stringBuilder.append("    \"Balance\": ");
        stringBuilder.append(balance);
        stringBuilder.append("\n}\n");
        printStream.print(stringBuilder);
        flag = true;
    }
}
