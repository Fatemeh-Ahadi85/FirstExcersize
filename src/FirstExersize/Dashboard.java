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
            System.out.println("Please enter your transaction type: ");
            String input = scanner.nextLine();

            if(input.equals("balance")){
                BankOperation balanceOperation = new BalanceOperation(UserName);
                balanceOperation.Operation();
            }
            else if(input.equals("withdraw")){
                BankOperation withdrawOperation = new WithdrawOperation(UserName);
                withdrawOperation.Operation();
            }
            else if(input.equals("deposit")){
                BankOperation depositOperation = new DepositOperation(UserName);
                depositOperation.Operation();
            }
            else if(input.equals("transfer")){
                BankOperation transferOperation = new TransferOperation(UserName);
                transferOperation.Operation();
            }
            else if(input.equals("history")){
                BankOperation history = new History(UserName);
                history.Operation();
            }
            else if(input.equals("back")){
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }
}
