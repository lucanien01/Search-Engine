package sea.bll;

import sea.dal.FileData;

import java.util.ArrayList;
import java.util.List;

public class FileManager {

    FileData fileData = new FileData();

    public List<String> loadWords(){
        List<String> words = fileData.getWords();

        if(words.isEmpty()){
            fileData.loadFile();
        }
        return words;
    }

    public boolean wordsExists(String word){
        List<String> wordList = fileData.getWords();

        for(String mWord : wordList)
        {
            if (word.equalsIgnoreCase(mWord)){
                return true;
            }
        }
        return false;
    }

    public List<String> loadWordsByLetter(String letter) {
        List<String> words = fileData.getWords();

        fileData.loadFile();
        words = fileData.getWords();


        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (word.startsWith(letter)) {
                filteredWords.add(word);
            }
        }

        return filteredWords;
    }
}
