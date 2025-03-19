package FirstExersize;

import java.io.IOException;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class jsonObject extends jsonParser {

    public jsonObject(String fileName) throws IOException, DataFormatException {
        super(fileName);
    }

    public HashMap<String,Object> Map(String input) throws DataFormatException, IOException {
        HashMap<String, Object> map = new HashMap();
        Format('{',input);
        findPairs findBracePair = new findBracePairs(input);
        input = input.substring(0,findBracePair.pairs()+1);
        if ( input.charAt(input.length() - 1) != '}') {
            throw new DataFormatException("Your Jason format is incorrect");
        }
        input = input.substring(1, input.length() - 1);
        while(input.length()>0) {
            String key = getKey(input);
            input = input.substring(key.length() + 2);
            Format(':', input);
            input = input.substring(1);
            Object value = getValue(input);
            if(input.charAt(0)=='\"') {
                input = input.substring(String.valueOf(value).length()+2);
            }
            else {
                input = input.substring(String.valueOf(value).length());
            }
            map.put(key, value);
            if(input.length()>0){
                Format(',',input);
                input = input.substring(1);
            }
        }

        return map;
    }

    public String getKey(String input) throws DataFormatException {
        Format('\"',input);
        findPairs findStringPair = new findStringPairs(input);
        int index = findStringPair.pairs();
        if (index == -1) {
            throw new DataFormatException("Your Jason format is incorrect");
        }
        input = input.substring(1, index);
        return input;
    }

    public Object getValue(String input) throws DataFormatException, IOException {
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
            jsonObject object = new jsonObject(fileName);
            return object.Map(input);
        }
        else if (input.charAt(0)=='['){
            jsonArray jsonArray = new jsonArray(fileName);
            return jsonArray.Array(input);
        }
        return "Your Jason format is incorrect";
    }

    public static void Format(char c, String input) throws DataFormatException {
        if (input.charAt(0) != c) {
            throw new DataFormatException("Your Jason format is incorrect");
        }
    }

}
