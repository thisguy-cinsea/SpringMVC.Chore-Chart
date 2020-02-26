package com.github.thisguy_cinsea.model;

public interface NoteInterface {
    String getNoteId();
    String getMessage();
    Boolean getDeleted();

    void setNoteId(String noteId);
    void setMessage(String message);
    void setDeleted(Boolean deleted);
}
