package FirstExersize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class WithdrawOperation extends BankOperation {

    public WithdrawOperation() throws DataFormatException, IOException {
        super();
    }

    @Override
    public void Operation() throws FileNotFoundException {
        System.out.println("Enter the amount to be withdrawn...");
        double amount = Double.parseDouble(scanner.nextLine());
        if(amount > balance) {
            System.out.println("Your account balance is insufficient.");
        }
        else {
            balance = balance - amount;
            System.out.println("You withdrew $"+amount+" from your account.");
            SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("withdraw",amount,user,user,"");
            saveToTransactionsJson.write();
        }
    }
}
