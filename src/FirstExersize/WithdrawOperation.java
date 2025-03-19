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
        System.out.println("Enter the amount to be withdrawn(or type back):");
        double amount;
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("back")) {
                System.out.println("Your are in Dashboard");
                return;
            }
            try {
                amount = Double.parseDouble(input);
                if(amount <= 0) {
                    System.out.println("Amount must be a positive number");
                }
                else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        if(amount > balance) {
            System.out.println("Your account balance is insufficient.");
            return;
        }
        else {
            balance = balance - amount;
            isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(user,"src/FirstExersize/Users.json");
            isUserProfileTrue.updateBalance(-amount);
            System.out.println("You withdrew $"+amount+" from your account.");
            SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("withdraw",amount,user,user,"");
            saveToTransactionsJson.write();
        }
    }
}
