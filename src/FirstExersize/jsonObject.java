package FirstExersize;

import java.io.IOException;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class jsonObject extends jsonParser {
    private String input;

    public jsonObject() throws IOException {
        this.input = super.input;
    }

    public HashMap<String, String> Map(String input) throws DataFormatException, IOException {
        HashMap<String, String> map = new HashMap();
        input = this.input;
        Format('{',input);
        if ( input.charAt(input.length() - 1) != '}') {
            throw new DataFormatException("Your Jason format is incorrect");
        }
        input = input.substring(1, input.length() - 1);
        while(input.length()>0) {
            String key = getKey(input);
            input = input.substring(key.length() + 1);
            Format(':', input);
            input = input.substring(1);
            String value = getValue(input);

            map.put(key, value);
            if(input.length()>0){
                Format(',',input);
            }
        }
        return map;
    }

    public String getKey(String input) throws DataFormatException {
        Format('\"',input);
        input = input.substring(1, input.length() - 1);
        int index = input.indexOf('\"');
        if (index == -1) {
            throw new DataFormatException("Your Jason format is incorrect");
        }
        input = input.substring(0, index);
        return input;
    }

    public String getValue(String input) throws DataFormatException, IOException {
        if(input.charAt(0)=='\"'){
            jsonLiteral string = new StringLiteral(input);
            return string.Value();
        }
        else if (Character.isDigit(input.charAt(0)) || input.charAt(0)=='.' || input.charAt(0)=='-') {
            jsonLiteral number = new NumberLiteral(input);
            return number.Value();
        }
        else if(input.startsWith("true")){
            input = input.substring(4);
            return "true";
        }
        else if(input.startsWith("false")){
            input = input.substring(5);
            return "false";
        }
        else if (input.startsWith("null")){
            input = input.substring(4);
            return "null";
        }
        else if (input.charAt(0)=='{'){
            jsonObject object = new jsonObject();
            return String.valueOf(object.Map(input));
        }
        else if (input.charAt(0)=='['){
            jsonArray jsonArray = new jsonArray(input);
            return String.valueOf(jsonArray.Array(input));
        }
        return "Your Jason format is incorrect";
    }

    public static void Format(char c, String input) throws DataFormatException {
        if (input.charAt(0) != c) {
            throw new DataFormatException("Your Jason format is incorrect");
        }
    }
}
