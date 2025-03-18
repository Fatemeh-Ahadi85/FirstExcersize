package FirstExersize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class History {

    public String file;
    public History() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/FirstExersize/Transactions.json");
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
    public void read(){
        System.out.println(file);
    }
    public String getFile() {
        return file;
    }
}
