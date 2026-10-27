package sea.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sea.bll.FileManager;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FileCreationController implements Initializable {

    @FXML
    public ListView<String> historyLst;

    @FXML
    public ListView<String> wordsLst;

    @FXML
    public ListView<String> wordsNLst;

    @FXML
    public ListView<String> wordsALst;

    @FXML
    public TextField searchLbl;

    @FXML
    public Label wordCountLbl;

    @FXML
    public Label searchResultLbl;

    FileManager fileManager = new FileManager();

    public void loadFiles(){

        //Words
        List<String> words = fileManager.loadWords();
        wordsLst.getItems().addAll(words);
        List<String> wordsStartsWithA = fileManager.loadWordsByLetter("a");
        wordsALst.getItems().setAll(wordsStartsWithA);
        List<String> wordsStartsWithN = fileManager.loadWordsByLetter("n");
        wordsNLst.getItems().setAll(wordsStartsWithN);
    }

    public void btnSearch(ActionEvent actionEvent) {
        historyLst.getItems().add(searchLbl.getText());

        String searchWord = searchLbl.getText();
        boolean wordExists = fileManager.wordsExists(searchWord);

        if(wordExists){
            wordsLst.getSelectionModel().select(searchWord);
            wordsLst.scrollTo(searchWord);
            searchResultLbl.setText("Search word found!");
        } else {
            searchResultLbl.setText(searchWord + " is not found!");
        }
    }

    public void btnClearHistory(ActionEvent actionEvent) {
        historyLst.getItems().setAll();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadFiles();
    }
}
