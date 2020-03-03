package com.github.thisguy_cinsea.model;

import java.util.UUID;

public class Note implements NoteInterface {
    private String id;
    private String message;
    private Boolean isDeleted;

    public Note(String id, String message, Boolean isDeleted) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.isDeleted = isDeleted;
    }

    public Note(String id, String message, int isDeleted) {
        this(id, message, isDeleted == 1);
    }

    public Note(String message){
        this(null, message, null);
    }

    public Note() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Boolean getDeleted() {
        return isDeleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId='" + id + '\'' +
                ", message='" + message + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
