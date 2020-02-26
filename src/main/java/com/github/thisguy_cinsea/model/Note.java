package com.github.thisguy_cinsea.model;

import java.util.UUID;

public class Note implements NoteInterface {
    private String noteId;
    private String message;
    private Boolean isDeleted;

    public Note(String noteId, String message, Boolean isDeleted) {
        this.noteId = UUID.randomUUID().toString();
        this.message = message;
        this.isDeleted = isDeleted;
    }

    public Note() {
    }

    @Override
    public String getNoteId() {
        return noteId;
    }

    @Override
    public void setNoteId(String noteId) {
        this.noteId = noteId;
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
                "noteId='" + noteId + '\'' +
                ", message='" + message + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
