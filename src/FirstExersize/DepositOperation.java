package FirstExersize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class DepositOperation extends BankOperation {

    public DepositOperation() throws DataFormatException, IOException {
        super();
    }

    @Override
    public void Operation() throws FileNotFoundException {
        System.out.println("Enter deposit amount...");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println(amount+"$ has been deposited into your account.");
        balance = balance + amount;

        SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("deposit",amount,user,"System","");
        saveToTransactionsJson.write();
    }
}
