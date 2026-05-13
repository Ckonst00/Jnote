package org.example.jnote.services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.jnote.models.Note;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class NoteStorageService  {
    private static final String FILE_PATH = "notes.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    // Save notes to JSON
    public void saveNotes(List<Note> notes) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load notes from JSON
    public List<Note> loadNotes() {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            return List.of(); // empty list if file missing or empty
        }

        try {
            return objectMapper.readValue(file, new TypeReference<List<Note>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // fallback to empty list if error
        }
    }
}
