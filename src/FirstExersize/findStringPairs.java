package FirstExersize;

public class findStringPairs extends findPairs {


    public findStringPairs(String input) {
        super(input);
    }

    @Override
    public int getPairs() {

        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '"') {
                if (input.charAt(i - 1) != '\\') {
                    return i;
                }
            }
        }
        return -1;
    }
}