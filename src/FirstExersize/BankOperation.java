package FirstExersize;

import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

abstract class BankOperation {
    protected String user;
    protected Double balance;
    protected Scanner scanner;
    public abstract void Operation() throws IOException, DataFormatException;

    public BankOperation(String UserName) throws IOException, DataFormatException {
        user = UserName;
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(user,"src/FirstExersize/Users.json");
        balance = isUserProfileTrue.balance();
        scanner = new Scanner(System.in);
    }
}
