package FirstExersize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class WithdrawOperation extends BankOperation {


    public WithdrawOperation(String UserName) throws IOException, DataFormatException {
        super(UserName);
    }

    @Override
    public void Operation() throws IOException, DataFormatException {
        System.out.println("Enter the amount to be withdrawn:");
        double amount = Double.parseDouble(scanner.nextLine());
        if(amount > balance) {
            System.out.println("Your account balance is insufficient.");
        }
        else {
            balance = balance - amount;
            isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(user);
            isUserProfileTrue.updateBalance(balance);
            System.out.println("You withdrew $"+amount+" from your account.");
            SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("withdraw",amount,user,user,"");
            saveToTransactionsJson.write();
        }
    }
}
