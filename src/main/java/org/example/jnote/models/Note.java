package org.example.jnote.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Note {

    private String title;
    private String content;
    private String date;
    private String id;

    public Note() {} //JSON

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now().toString();
        this.id = setId();
    }

    /// //////// GETTERS ////////////////
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() { return "Created:" + " " + date; }

    public String getId() { return this.id; }

    /// ////////// SETTERS ////////////////
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) { this.date = date; }

    public String setId() {
        // Create random ID
        return UUID.randomUUID().toString();
    }


    /// /////////////////////////////////////////////
    @Override
    public String toString() {
        return title + " - " + content + " - " + date;
    }
}


