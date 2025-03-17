package FirstExersize;

import java.io.FileInputStream;
import java.io.IOException;

public class SaveToUsersJson {

    private String UserName;
    private int Password;
    private double balance;
    private String input;
    public SaveToUsersJson(String UserName, int Password, double balance) throws IOException {
        this.UserName = UserName;
        this.Password = Password;
        this.balance = balance;
        this.input = read();
    }
    public String read() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        FileInputStream fileInputStream = new FileInputStream("src/FirstExersize/Users.json");
        int data;
        while ((data = fileInputStream.read()) != -1) {
            stringBuilder.append((char) data);
        }
        fileInputStream.close();

        String input = stringBuilder.toString();
        delete delete = new delete(input);
        input = delete.getInput();
        input = input + "]";
        return input;
    }
    public void delete() {
        int ind = input.indexOf(UserName);
        int index = input.indexOf("balance",ind);

        input = input.replaceFirst(input.substring(index,index+String.valueOf(balance).length()),balance+"") ;
    }

}
