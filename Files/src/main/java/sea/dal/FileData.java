package sea.dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileData {

    List<String> words = new ArrayList<>();

    public void loadFile(){

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\lucas\\OneDrive\\Skrivebord\\Files\\src\\main\\java\\sea\\files\\Words.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWords(){
        return words;
    }
}
