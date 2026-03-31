package org.example.jnote.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.example.jnote.models.Note;

public class NoteDetailController {
    @FXML
    private Label titleLabel;
    @FXML
    private TextArea contentArea;
    @FXML
    private Label dateLabel;

    public void setNote(Note note) {
        titleLabel.setText(note.getTitle());
        contentArea.setText(note.getContent());
        dateLabel.setText(note.getDate());
    }
}
