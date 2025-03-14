package FirstExersize;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class jsonParser {

    //public  String Value(String key) throws DataFormatException, IOException;

    public String input;

    public jsonParser() throws IOException, DataFormatException {
        StringBuilder stringBuilder = new StringBuilder();

        FileInputStream fileInputStream = new FileInputStream("src/FirstExersize/users.json");
        int data;
        while ((data = fileInputStream.read()) != -1) {
            stringBuilder.append((char) data);
        }
        fileInputStream.close();

        this.input = stringBuilder.toString();
        delete delete = new delete(input);
        input = delete.getInput();

    }

    public boolean value(String value1,String value2) throws IOException, DataFormatException {
//        if (input.charAt(0) == '{') {
//            jsonObject object = new jsonObject();
//            HashMap<String, String> map = object.Map(input);
//            return map.get(key);
//        }
        if (input.charAt(0) == '[') {
            jsonArray Array = new jsonArray();
            ArrayList<Object> list = Array.Array(input);
            for (int i = 0; i < list.size(); i++) {
                Object item = list.get(i);
                if (item instanceof HashMap) {
                    HashMap<?, ?> map = (HashMap<?, ?>) item;
                    if (String.valueOf(map.get("UserName")).equals(value1)) {
                        if(map.get("Password").equals(value2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}


