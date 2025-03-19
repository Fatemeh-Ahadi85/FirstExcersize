package FirstExersize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class isUserProfileTrue extends jsonParser {
    public HashMap<String, Object> map;
    public String UserName;

    public isUserProfileTrue(String UserName,String fileName) throws IOException, DataFormatException {
        super(fileName);
        this.UserName = UserName;
        if (input.charAt(0) == '[') {
            jsonArray Array = new jsonArray(fileName);
            ArrayList<Object> list = Array.Array(input);
            for (int i = 0; i < list.size(); i++) {
                Object item = list.get(i);
                if (item instanceof HashMap) {
                    HashMap<String, Object> Map = (HashMap<String, Object>) item;
                    if (Map.get("UserName").equals(UserName)) {
                        this.map = Map;
                    }
                }
            }
        }
    }
    public boolean isUserNameTrue() {
        try {
            return map != null && map.get("UserName") != null && map.get("UserName").equals(UserName);
        } catch (NullPointerException e) {
            return false;
        }
    }
    public boolean isPasswordTrue(String password) {
        try {
            return map != null && map.get("Password") != null && map.get("Password").equals(password);
        } catch (NullPointerException e) {
            return false;
        }

    }
    public double balance() {
        return Double.parseDouble(map.get("Balance").toString());
    }
    public void updateBalance(double newBalance) throws IOException {
        ReadFile readFile = new ReadFile("src/FirstExersize/Users.json");
        this.input = readFile.getFile();
        delete delete = new delete(input);
        input = delete.getInput();
        newBalance = Double.parseDouble(map.get("Balance").toString()) + newBalance;
        int ind = input.indexOf(UserName);
        int firstIndex = input.indexOf("Balance", ind);
        int lastIndex = input.indexOf("}", firstIndex);
        StringBuilder builder = new StringBuilder();
        builder.append(input.substring(0, firstIndex+9));
        builder.append(newBalance);
        builder.append(input.substring(lastIndex));
        input = builder.toString();
        FileOutputStream fileOutputStream = new FileOutputStream("src/FirstExersize/Users.json");
        PrintStream printStream = new PrintStream(fileOutputStream);
        printStream.print(input);

    }
}