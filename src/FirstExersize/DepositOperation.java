package FirstExersize;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class DepositOperation extends BankOperation {

    public DepositOperation(String UserName) throws IOException, DataFormatException {
        super(UserName);
    }

    @Override
    public void Operation() throws IOException, DataFormatException {
        System.out.println("Enter deposit amount(or type back):");
        double amount;

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("back")) {
                System.out.println("You are in Dashboard");
                return;
            }
            try {
                amount = Double.parseDouble(input);
                if(amount <= 0) {
                    System.out.println("Invalid deposit amount");
                }
                else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        System.out.println(amount+"$ has been deposited into your account.");
        balance = balance + amount;
        isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(user,"src/FirstExersize/Users.json");
        isUserProfileTrue.updateBalance(amount);

        SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("deposit",amount,user,"System","");
        saveToTransactionsJson.write();
    }
}
