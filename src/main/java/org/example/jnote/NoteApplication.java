package org.example.jnote;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NoteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NoteApplication.class.getResource("main.fxml"));
        Font.loadFont(getClass().getResourceAsStream("/org/example/jnote/fonts/YourFont.ttf"), 14);
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("JNOTE");
        stage.initStyle(StageStyle.UNDECORATED); // removes native title bar
        stage.setScene(scene);
        stage.show();
    }
}
