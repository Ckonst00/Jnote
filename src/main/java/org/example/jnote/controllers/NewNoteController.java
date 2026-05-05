package org.example.jnote.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class NewNoteController {
    private NoteController noteController; // <-- Calls method from NoteController
    @FXML
    private Text actiontarget;
    @FXML
    private TextField titlelabel;
    @FXML
    private TextArea content;

    public void setNoteController(NoteController noteController) {
        this.noteController = noteController;
    }

    @FXML protected void handleSubmitButtonAction() {
        actiontarget.setText("Submit button pressed");
        noteController.addNote(titlelabel.getText(), content.getText());
    }
}
