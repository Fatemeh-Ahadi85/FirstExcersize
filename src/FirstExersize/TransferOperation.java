package FirstExersize;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class TransferOperation extends BankOperation{


    public TransferOperation(String UserName) throws IOException, DataFormatException {
        super(UserName);
    }

    @Override
    public void Operation() throws IOException, DataFormatException {
        System.out.println("Whose account do you want to transfer money into ?(or type back)");
        String recipient ;
        isUserProfileTrue isTrue;
        while (true) {
            String input = scanner.nextLine();
            if(input.equals("back")){
                System.out.println("You are in Dashboard");
                return;
            }
            recipient = input;
            isTrue = new isUserProfileTrue(recipient,"src/FirstExersize/Users.json");
            if (!isTrue.isUserNameTrue()) {
                System.out.println(recipient+" does not have account.");
            }
            else {
                break;
            }
        }
        System.out.println("Enter the amount to be transferred:(or type back)");
        double amount;
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("back")){
                System.out.println("You are in Dashboard");
                return;
            }
            try {
                amount = Double.parseDouble(input);
                if (amount <= 0) {
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
            isTrue.updateBalance(amount);
            System.out.println("You deposited $" + amount+" to "+recipient+".");
        }
        SaveToTransactionsJson saveToTransactionsJson = new SaveToTransactionsJson("transfer",amount,user,user,recipient);
        saveToTransactionsJson.write();
    }
}
