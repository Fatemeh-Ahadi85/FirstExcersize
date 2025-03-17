package FirstExersize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

abstract class BankOperation {
    protected String user;
    protected Double balance;
    protected Scanner scanner;

    public abstract void Operation() throws IOException;

    public BankOperation() throws DataFormatException, IOException {
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue();
        balance = (Double)isUserProfileTrue.get("balance");
        user = (String)isUserProfileTrue.get("user");
        scanner = new Scanner(System.in);
    }
}
