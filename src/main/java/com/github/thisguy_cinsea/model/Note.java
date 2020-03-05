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

    public Note(String noteId, String message, int isDeleted) {
        this(noteId, message, isDeleted == 1);
    }

    public Note(String message){
        this(null, message, null);
    }

    public Note() {
    }

    @Override
    public String getId() {
        return noteId;
    }

    @Override
    public void setId(String noteId) {
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
    public String getTableName() {
        return "note_tbl";
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
