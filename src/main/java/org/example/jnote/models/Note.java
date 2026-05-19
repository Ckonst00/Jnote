package org.example.jnote.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Note {

    private String title;
    private String content;
    private String date;
    private String id;

    @JsonCreator
    public Note() {} //JSON

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.date = LocalDateTime.now().format(formatter);
        this.id = generateId();
    }

    /// //////// GETTERS ////////////////
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() { return date; }

    public String getId() { return this.id; }

    /// //////// SETTERS //////////////////
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }


    /// /////////////////////////////////////////////
    private String generateId() {
        return UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
        return title + " - " + content + " - " + date;
    }
}


