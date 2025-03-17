package FirstExersize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class TransferOperation extends BankOperation{
    public TransferOperation() throws DataFormatException, IOException {
        super();
    }

    @Override
    public void Operation() throws IOException {
        System.out.println("Whose account do you want to transfer money into ?");
        String recipient = "";
        while (true) {
            recipient = scanner.nextLine();
            isUserProfileTrue isTrue = new isUserProfileTrue();
            if (!isTrue.isUserNameTrue(recipient)) {
                System.out.println("Please enter a valid username");
            }
            else {
                break;
            }
        }
        System.out.println("Enter the amount to be transferred...");
        double amount = Double.parseDouble(scanner.nextLine());
        if(amount > balance) {
            System.out.println("Your account balance is insufficient.");
        }
        else {
            balance = balance - amount;
            System.out.println("You deposited $" + amount+" to "+recipient);
        }
        SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("transfer",amount,user,user,recipient);
        saveToTransactionsJson.write();
    }
}
