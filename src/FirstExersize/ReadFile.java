package FirstExersize;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public String file;

    public ReadFile(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
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
