package FirstExersize;

import java.util.zip.DataFormatException;

public class StringLiteral extends jsonLiteral{
    public String input;

    public StringLiteral(String input) throws DataFormatException {
        super(input);
        if(input.charAt(0)!='\"'){
            throw new DataFormatException("Your Jason format is incorrect");
        }
        findPairs findStringPair = new findStringPairs(input);
        int index = findStringPair.pairs();
        if (index == -1) {
            throw new DataFormatException("Your Jason format is incorrect");
        }
        this.input = input.substring(1, index);
    }
    @Override
    public Object getValue() {
        return this.input;
    }

}
