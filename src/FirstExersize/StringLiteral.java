package FirstExersize;

import java.util.zip.DataFormatException;

public class StringLiteral extends jsonLiteral{
    public String input;

    public StringLiteral(String input) throws DataFormatException {
        super(input);
        if(input.charAt(0)!='\"'){
            throw new DataFormatException("Your Jason format is incorrect");
        }
        input = input.substring(1);
        int index = 0;
        while(input.charAt(index)!='\"'){
            index++;
        }
        input = input.substring(0,index);
        this.input=input;
    }
    @Override
    public Object getValue() {
        return this.input;
    }

}
