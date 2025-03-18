package FirstExersize;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class TransferOperation extends BankOperation{


    public TransferOperation(String UserName) throws IOException, DataFormatException {
        super(UserName);
    }

    @Override
    public void Operation() throws IOException, DataFormatException {
        System.out.println("Whose account do you want to transfer money into ?");
        String recipient = "";
        isUserProfileTrue isTrue = new isUserProfileTrue(recipient);
        while (true) {
            recipient = scanner.nextLine();
            if (!isTrue.isUserNameTrue()) {
                System.out.println("Please enter a valid username");
            }
            else {
                break;
            }
        }
        System.out.println("Enter the amount to be transferred:");
        double amount = Double.parseDouble(scanner.nextLine());
        if(amount > balance) {
            System.out.println("Your account balance is insufficient.");
        }
        else {
            balance = balance - amount;
            isUserProfileTrue isUserProfileTrue = new isUserProfileTrue(user);
            isUserProfileTrue.updateBalance(balance);
            isTrue.updateBalance(amount);
            System.out.println("You deposited $" + amount+" to "+recipient);
        }
        SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("transfer",amount,user,user,recipient);
        saveToTransactionsJson.write();
    }
}
