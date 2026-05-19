package org.example.jnote.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.jnote.models.Note;
import org.example.jnote.services.NoteService;
import org.example.jnote.services.NoteStorageService;
import javafx.event.ActionEvent;
import java.io.IOException;


import javafx.stage.Stage;

public class NoteController {

    @FXML
    private ListView<Note> noteList;
    @FXML
    private VBox detailPane;
    private final NoteService noteService = new NoteService();
    private final NoteStorageService noteStorageService = new NoteStorageService();
    private String noteId = "";

    /// ////////// For the titlebar ////////////
    private double dragOffsetX, dragOffsetY;
    @FXML private HBox titleBar;
    @FXML
    private void handleTitleBarPress(MouseEvent e) {
        dragOffsetX = e.getSceneX();
        dragOffsetY = e.getSceneY();
    }

    @FXML
    public void handleTitleBarDrag(MouseEvent e) {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setX(e.getScreenX() - dragOffsetX);
        stage.setY(e.getScreenY() - dragOffsetY);
    }

    @FXML
    public void handleMinimize() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void handleMaximize() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    @FXML
    public void handleClose() {
        Stage stage = (Stage) titleBar.getScene().getWindow();
        stage.close();
    }

    /// ////////////////////////////////////////

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
                noteId = selectedNote.getId(); // Sets the selected notes id

                NoteDetailController controller = loader.getController();
                controller.setNote(selectedNote);
                controller.setNoteController(this);

                detailPane.getChildren().setAll(detail);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void addNote(String title, String content) {
        if (title.isBlank()) title = "Untitled";
        if (content.isBlank()) content = "";

        noteService.addNote(new Note(title, content));
        noteStorageService.saveNotes(noteService.getNotes());
    }

    @FXML
    public void handleNewButtonAction (ActionEvent event) throws IOException {  // Method initializing the form window for new notes.
        System.out.println("Add note button pressed.");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/jnote/note-form.fxml"));
        Parent formRoot = loader.load();
        NoteFormController controller = loader.getController();
        controller.setNoteController(this); // pass reference to self

        Stage stage = new Stage();
        stage.setTitle("New Note");

        stage.setScene(new Scene(formRoot));
        stage.setResizable(false); // Doesn't allow resizing the window.
        stage.show();
    }

    @FXML
    public void deleteNoteById() {  // Method for deleting the note by its ID.
        noteService.deleteNote(noteId);
        noteStorageService.saveNotes(noteService.getNotes());
    }

    @FXML
    public void saveModifiedNoteById(String newTitle, String newContent) {  // Method for editing the note and saving its new content to notes.
        System.out.println("Save button pressed." + " ID: of the note: " + noteId);
        noteService.saveNote(newTitle, newContent, noteId);
        noteStorageService.saveNotes(noteService.getNotes());
    }

}
