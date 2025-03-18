package FirstExersize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class DepositOperation extends BankOperation {

    public DepositOperation(String UserName) throws IOException, DataFormatException {
        super(UserName);
    }

    @Override
    public void Operation() throws IOException, DataFormatException {
        System.out.println("Enter deposit amount:");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println(amount+"$ has been deposited into your account.");
        balance = balance + amount;
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(user);
        isUserProfileTrue.updateBalance(balance);

        SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("deposit",amount,user,"System","");
        saveToTransactionsJson.write();
    }
}
