package FirstExersize;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class Balance extends BankOperation{

    public Balance() throws DataFormatException, IOException {
        super();
    }

    @Override
    public void Operation() {
        System.out.println("Your balance is "+ balance);
    }
}
