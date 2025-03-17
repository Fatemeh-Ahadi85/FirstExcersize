package FirstExersize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class isUserProfileTrue extends jsonParser {
    public HashMap<String, Object> map;


    public isUserProfileTrue() throws IOException {
        super();
    }

    public boolean isUserExist(String value1, String value2) throws IOException, DataFormatException {
        if (input.charAt(0) == '[') {
            jsonArray Array = new jsonArray();
            ArrayList<Object> list = Array.Array(input);
            for (int i = 0; i < list.size(); i++) {
                Object item = list.get(i);
                if (item instanceof HashMap) {
                    this.map = (HashMap<String, Object>) item;
                    if (isUserNameTrue(value1)) {
                        if (isPasswordTrue(value2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isUserNameTrue(String userName) {
        return userName.equals(map.get("UserName"));
    }

    public boolean isPasswordTrue(String password) {
        return password.equals(map.get("Password"));
    }

    public Object get(String key) {
        return map.get(key);
    }
}