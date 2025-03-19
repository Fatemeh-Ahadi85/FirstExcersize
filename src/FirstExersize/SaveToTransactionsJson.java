package FirstExersize;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.zip.DataFormatException;


public class SaveToTransactionsJson {

    private String type;
    private double amount;
    private String user;
    private String depositor;
    private String recipient;
    private String date;
    private String time;
    private boolean flag = false;

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

    public void write() throws IOException, DataFormatException {

        StringBuilder stringBuilder = new StringBuilder();
        History history = new History(user);
        String file = history.getFile();
        if(file.length()>0){
            int firstIndex = file.indexOf("[");
            int lastIndex = file.lastIndexOf("]");
            file = file.substring(firstIndex+1,lastIndex);
            file = file + ",";
        }
        FileOutputStream fileOutputStream = new FileOutputStream("src/FirstExersize/Transactions.json");
        PrintStream printStream = new PrintStream(fileOutputStream);
        printStream.print("[");
        printStream.println(file);

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
            stringBuilder.append("\""+user+"\"");
        }
        else{
            stringBuilder.append(",\n");
            stringBuilder.append("    \"user\": ");
            stringBuilder.append("\""+user+"\"");
        }
        stringBuilder.append(",\n");
        stringBuilder.append("    \"date&time\": ");
        stringBuilder.append("\""+date+"   "+time+"\"");
        stringBuilder.append("\n}\n");
        printStream.print(stringBuilder);
        printStream.println("]");
        flag = true;
    }
}
