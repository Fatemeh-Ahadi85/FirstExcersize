package FirstExersize;

import java.util.zip.DataFormatException;

public class NumberLiteral extends jsonLiteral{
    public String input;

    public NumberLiteral(String input) throws DataFormatException {
        super(input);
        int index=0;
        while(index<input.length() &&(Character.isDigit(input.charAt(index)) || input.charAt(index)=='.' || input.charAt(index)=='-')){
            index++;
        }
        this.input = input.substring(0,index);
    }
    @Override
    public Object getValue() {
        return this.input;
    }
}
