package FirstExersize;

import java.io.FileInputStream;
import java.io.IOException;


public class jsonParser {


    public String input;

    public jsonParser() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        FileInputStream fileInputStream = new FileInputStream("src/FirstExersize/Users.json");
        int data;
        while ((data = fileInputStream.read()) != -1) {
            stringBuilder.append((char) data);
        }
        fileInputStream.close();

        this.input = stringBuilder.toString();
        delete delete = new delete(input);
        input = delete.getInput();
        input = input + "]";
    }
}

//    public boolean value(String value1,String value2) throws IOException, DataFormatException {
//
//        if (input.charAt(0) == '[') {
//            jsonArray Array = new jsonArray();
//            ArrayList<Object> list = Array.Array(input);
//            for (int i = 0; i < list.size(); i++) {
//                Object item = list.get(i);
//                if (item instanceof HashMap) {
//                    HashMap<?, ?> map = (HashMap<?, ?>) item;
//                    if ()) {
//                        if(map.get("Password").equals(value2)) {
//                            this.map = map;
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }
//    public boolean isUserNameTrue(String UserName) {
//        if (String.valueOf(map.get("UserName")).equals(UserName)) {
//            return true;
//        }
//        return false;
//    }
//    public Object get(String key){
//        return map.get(key);
//    }
//}


