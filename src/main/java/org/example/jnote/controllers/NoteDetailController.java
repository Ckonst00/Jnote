package org.example.jnote.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.jnote.models.Note;

public class NoteDetailController {
    private NoteController noteController; // <-- Calls method from NoteController

    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;
    @FXML
    private Label dateLabel;

    public void setNote(Note note) {
        titleField.setText(note.getTitle());
        contentArea.setText(note.getContent());
        dateLabel.setText(note.getDate());
    }

    public void setNoteController(NoteController noteController) {
        this.noteController = noteController;
    }

    @FXML
    public void handleDelete() {
        noteController.deleteNoteById();
    }

    @FXML
    public void handleSave() {
        noteController.saveModifiedNoteById(titleField.getText(), contentArea.getText());
    }
}
