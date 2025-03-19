package FirstExersize;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class BalanceOperation extends BankOperation{


    public BalanceOperation(String UserName) throws IOException, DataFormatException {
        super(UserName);
    }

    @Override
    public void Operation() {
        System.out.println("Your balance is $"+ balance+".");
    }
}
