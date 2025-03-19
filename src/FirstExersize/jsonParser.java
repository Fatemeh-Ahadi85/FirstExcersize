package FirstExersize;

import java.io.IOException;

public class jsonParser{

    public String input;
    protected String fileName;

    public jsonParser(String fileName) throws IOException {
        this.fileName = fileName;
        ReadFile readFile = new ReadFile(fileName);
        this.input = readFile.getFile();
        delete delete = new delete(input);
        input = delete.getInput();
    }
}