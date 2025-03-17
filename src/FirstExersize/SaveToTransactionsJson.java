package FirstExersize;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;


public class SaveToTransactionsJson {

    private String type;
    private double amount;
    private String user;
    private String depositor;
    private String recipient;
    private String date;
    private String time;

    public SaveToTransactionsJson(String type, double amount , String user, String depositor, String recipient) {
        this.type = type;
        this.amount = amount;
        this.user = user;
        this.depositor = depositor;
        this.recipient = recipient;
        LocalDate date = LocalDate.now();
        this.date = date.toString();
        LocalTime time = LocalTime.now();
        this.time = time.toString();
    }

    public void write() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/FirstExersize/Transactions.json");
        PrintStream printStream = new PrintStream(fileOutputStream);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        stringBuilder.append("    \"type\": ");
        stringBuilder.append("\""+type+"\"");
        stringBuilder.append(",\n");
        stringBuilder.append("    \"amount\": ");
        stringBuilder.append(amount);

        if(type.equals("transfer")){
            stringBuilder.append(",\n");
            stringBuilder.append("    \"from\": ");
            stringBuilder.append("\""+depositor+"\"");
            stringBuilder.append(",\n");
            stringBuilder.append("    \"to\": ");
            stringBuilder.append("\""+recipient+"\"");
        }
        else if(type.equals("deposit")){
            stringBuilder.append(",\n");
            stringBuilder.append("    \"from\": ");
            stringBuilder.append("\""+depositor+"\"");
            stringBuilder.append(",\n");
            stringBuilder.append("    \"to\": ");
            stringBuilder.append("\""+"you"+"\"");
        }
        else{
            stringBuilder.append(",\n");
            stringBuilder.append("    \"user\": ");
            stringBuilder.append("\""+user+"\"");
        }
        stringBuilder.append(",\n");
        stringBuilder.append("    \"date&time\": ");
        stringBuilder.append("\""+date+" "+time+"\"");
        stringBuilder.append("\n}\n");
        printStream.print(stringBuilder);
    }
}
