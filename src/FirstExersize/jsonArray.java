package FirstExersize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class jsonArray extends jsonParser {

    public jsonArray(String fileName) throws IOException {
        super(fileName);
    }
    public ArrayList<Object>Array(String input) throws DataFormatException, IOException {

        ArrayList <Object> list = new ArrayList<>();
        Format('[',input);
        if(input.charAt(input.length()-1)!=']'){
            throw new DataFormatException("Your Jason format is incorrect");
        }
        input = input.substring(1, input.length()-1);
        while(input.length()>0) {
            if (input.charAt(0) == '"') {
                jsonLiteral string = new StringLiteral(input);
                list.add(string.Value());
            }
            else if (Character.isDigit(input.charAt(0)) || input.charAt(0)=='.' || input.charAt(0)=='-') {
                jsonLiteral number = new NumberLiteral(input);
                list.add(number.Value());
            }
            else if(input.startsWith("true")){
                input = input.substring(4);
                list.add("true");
            }
            else if(input.startsWith("false")){
                input = input.substring(5);
                list.add("false");
            }
            else if (input.startsWith("null")){
                input = input.substring(4);
                list.add("null");
            }
            else if (input.charAt(0)=='['){
                jsonArray jsonArray = new jsonArray(fileName);
                ArrayList<Object> List = jsonArray.Array(input);
                list.add(String.valueOf(List));
            }
            else if(input.charAt(0)=='{'){
                jsonObject jsonObject = new jsonObject(fileName);
                list.add(jsonObject.Map(input));
                findPairs findBracePair = new findBracePairs(input);
                input = input.substring(findBracePair.pairs()+1);
            }
            if(input.length()>0) {
                Format(',', input);
                input=input.substring(1);
            }
        }
        return list;
    }
    public static void Format(char c,String input) throws DataFormatException {
        if(input.charAt(0)!= c){
            throw new DataFormatException("Your Jason format is incorrect");
        }
    }

}
