package FirstExersize;

public class delete {

    private String input;

    public delete(String input){
//        input = input.replaceAll(" ","");
//        input = input.replaceAll("\n","");
//        input = input.replaceAll("\t","");
//        input = input.replaceAll("\r","");
//        this.input = input;
        char[] charAt = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charAt.length; i++) {
            if (charAt[i] != ' ' && charAt[i] != '\t' && charAt[i] != '\n' && charAt[i] != '\r') {
                stringBuilder.append(charAt[i]);
            }
        }
        this.input = stringBuilder.toString();

    }
    public String getInput() {
        return input;
    }
}
