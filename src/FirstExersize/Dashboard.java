package FirstExersize;

import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Dashboard {
    private String UserName;

    public Dashboard(String UserName) {
        this.UserName = UserName;
    }
    public void start() throws DataFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + UserName+" !");
        while(true){
            String input = scanner.nextLine();

            if(input.equals("balance")){
                Balance balance = new Balance();
                balance.Operation();
            }
            else if(input.equals("withdraw")){
                WithdrawOperation withdrawOperation = new WithdrawOperation();
                withdrawOperation.Operation();
            }
            else if(input.equals("deposit")){
                DepositOperation depositOperation = new DepositOperation();
                depositOperation.Operation();
            }
            else if(input.equals("transfer")){
                TransferOperation transferOperation = new TransferOperation();
                transferOperation.Operation();
            }
            else if(input.equals("history")){
                History history = new History();
                history.read();
            }
        }
    }
}
