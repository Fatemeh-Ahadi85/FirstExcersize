package FirstExersize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class History extends BankOperation {

    public String file;

    public History(String UserName) throws IOException, DataFormatException {
        super(UserName);
        ReadFile readFile = new ReadFile("src/FirstExersize/Transactions.json");
        file = readFile.getFile();
    }

    public String getFile() {
        return file;
    }

    @Override
    public void Operation() throws IOException, DataFormatException {
        StringBuilder stringBuilder = new StringBuilder();
        jsonArray Array = new jsonArray("src/FirstExersize/Transactions.json");
        delete delete = new delete(file);
        String File = delete.getInput();
        ArrayList<Object> list = Array.Array(File);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            if (item instanceof HashMap) {
                HashMap<String, Object> Map = (HashMap<String, Object>) item;
                if (Map.containsKey("from") && Map.get("from").equals(user)) {
                    count++;
                    stringBuilder.append(count + ". ");
                    stringBuilder.append("transfer");
                    stringBuilder.append(":");
                    stringBuilder.append("-");
                    stringBuilder.append(Map.get("amount")+" ");
                    stringBuilder.append("to ");
                    stringBuilder.append(Map.get("to")+" ");
                    stringBuilder.append(" (");
                    stringBuilder.append(Map.get("date&time"));
                    stringBuilder.append(") ");
                    stringBuilder.append("\n");
                } else if ((Map.containsKey("from") &&Map.get("from").equals("System")&&(Map.containsKey("to")&&Map.get("to").equals(user))) || (Map.containsKey("to")&&Map.get("to").equals(user))) {
                    count++;
                    stringBuilder.append(count + ". ");
                    stringBuilder.append("deposit");
                    stringBuilder.append(":");
                    stringBuilder.append("+");
                    stringBuilder.append(Map.get("amount")+" ");
                    stringBuilder.append("from ");
                    stringBuilder.append("System ");
                    stringBuilder.append(" (");
                    stringBuilder.append(Map.get("date&time"));
                    stringBuilder.append(") ");
                    stringBuilder.append("\n");
                } else if (Map.containsKey("user")&&Map.get("user").equals(user)) {
                    count++;
                    stringBuilder.append(count + ". ");
                    stringBuilder.append("withdraw");
                    stringBuilder.append(":");
                    stringBuilder.append("-");
                    stringBuilder.append(Map.get("amount")+" ");
                    stringBuilder.append("from ");
                    stringBuilder.append("Your account ");
                    stringBuilder.append(" (");
                    stringBuilder.append(Map.get("date&time"));
                    stringBuilder.append(") ");
                    stringBuilder.append("\n");
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
