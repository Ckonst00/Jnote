package org.example.jnote.models;

import java.time.LocalDateTime;

public class Note {

    private String title;
    private String content;
    private String date;

    public Note() {} //JSON

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now().toString();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return title + " - " + content + " - " + date;
    }
}


