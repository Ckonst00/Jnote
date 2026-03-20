package org.example.jnote.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.jnote.models.Note;
import org.example.jnote.services.NoteService;
import org.example.jnote.services.NoteStorageService;

import java.util.ArrayList;

public class NoteController {

    @FXML
    private ListView<Note> noteList;
    private final NoteService noteService = new NoteService();
    private final NoteStorageService noteStorageService = new NoteStorageService();


    @FXML
    public void initialize() {
        noteService.getNotes().addAll(noteStorageService.loadNotes());

        noteList.setItems(noteService.getNotes());
    }

    @FXML
    public void addNote() {}
}
