package FirstExersize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class isUserProfileTrue extends jsonParser {
    public HashMap<String, Object> map;
    public String UserName;

    public isUserProfileTrue(String UserName) throws IOException, DataFormatException {
        super();
        this.UserName = UserName;
        if (input.charAt(0) == '[') {
            jsonArray Array = new jsonArray();
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
        if (map.get("UserName").equals(UserName)) {
            return true;
        }
        return false;
    }
    public boolean isPasswordTrue(String password) {
        return password.equals(map.get("Password"));
    }
    public double balance() {
        return Double.parseDouble(map.get("balance").toString());
    }
    public void updateBalance(double newBalance) {
        map.replace("balance", newBalance);
    }
}