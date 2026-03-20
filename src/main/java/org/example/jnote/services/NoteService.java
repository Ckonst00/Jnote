package org.example.jnote.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.jnote.models.Note;

public class NoteService {

    private final ObservableList<Note> notes = FXCollections.observableArrayList();

    public ObservableList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(Note note) {
        notes.remove(note);
    }
}