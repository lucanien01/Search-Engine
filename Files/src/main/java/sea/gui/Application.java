package sea.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/sea/File Creation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 600);
        stage.setTitle("WordSearch");
        stage.setScene(scene);
        stage.show();
    }
}
