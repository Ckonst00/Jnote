package org.example.jnote.controllers;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NoteFormController {
    private NoteController noteController; // <-- Calls method from NoteController

    @FXML
    private TextField titleField;
    @FXML
    private TextArea content;
    @FXML
    private javafx.scene.control.Button submitButton;

    public void setNoteController(NoteController noteController) {
        this.noteController = noteController;
    }

    @FXML protected void handleSubmitButtonAction() {

        noteController.addNote(titleField.getText(), content.getText());

            PauseTransition pause = new PauseTransition(Duration.millis(100));  // Makes the UI look and feel cooler :D.
            pause.setOnFinished(e -> {
                Stage stage = (Stage) submitButton.getScene().getWindow(); // Got this method from: https://stackoverflow.com/questions/13567019/close-fxml-window-by-code-javafx
                stage.close();  // Closes the Form window.
            });
            pause.play();
    }
}
