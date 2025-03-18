package FirstExersize;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadUserFile {
    public String file;

    public ReadUserFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/FirstExersize/Users.json");
        StringBuilder stringBuilder = new StringBuilder();
        int data;
        while ((data = fileInputStream.read()) != -1) {
            stringBuilder.append((char) data);
        }
        file = stringBuilder.toString();
        if (file.isEmpty()) {
            file = "";
        }
    }

    public String getFile() {
        return file;
    }
}
