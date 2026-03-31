package org.example.jnote.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.jnote.models.Note;
import org.example.jnote.services.NoteService;
import org.example.jnote.services.NoteStorageService;

import java.io.IOException;
import java.util.ArrayList;

public class NoteController {

    @FXML
    private ListView<Note> noteList;
    @FXML
    private VBox detailPane;
    private final NoteService noteService = new NoteService();
    private final NoteStorageService noteStorageService = new NoteStorageService();


    @FXML
    public void initialize() {
        noteService.getNotes().addAll(noteStorageService.loadNotes());

        noteList.setCellFactory(lv -> new ListCell<Note>() {
            @Override
            protected void updateItem(Note note, boolean empty) {
                super.updateItem(note, empty);
                if (empty || note == null) setText(null);
                else setText(note.getTitle());
            }
        });

        noteList.setItems(noteService.getNotes());

        noteList.getSelectionModel().selectedItemProperty().addListener((obs, oldNote, selectedNote) -> {
            if (selectedNote == null) return;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/jnote/note-detail.fxml"));
                Node detail = loader.load();

                NoteDetailController controller = loader.getController();
                controller.setNote(selectedNote);

                detailPane.getChildren().setAll(detail);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    public void addNote() {}

}
