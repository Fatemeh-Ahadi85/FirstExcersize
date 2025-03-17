package FirstExersize;

import java.io.FileInputStream;
import java.io.IOException;
public class History {

    public void read () throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/FirstExersize/Transactions.json");
        StringBuilder stringBuilder = new StringBuilder();
        int data;
        while ((data = fileInputStream.read()) != -1) {
            stringBuilder.append((char) data);
        }
        fileInputStream.close();

        System.out.println(stringBuilder);
    }
}
