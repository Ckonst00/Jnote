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

    public void deleteNote(String id) {
        //found this method from: https://stackoverflow.com/questions/46645539/removing-object-of-arraylist-by-using-its-unique-id
        notes.removeIf(n ->n.getId().equals(id));
    }
}